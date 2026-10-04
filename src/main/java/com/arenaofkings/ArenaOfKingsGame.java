package com.arenaofkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Jeu minimaliste : personnage centre a l'ecran, deplacement ZQSD, orientation vers la souris.
 * Personnage + tenue + teinte selectionnables via 3 listes deroulantes (skins sous models/).
 *
 * Mapping des 8 directions deduit des atlas (index = dir * 10000 + frame) :
 *   0 = Sud (face camera), 1 = Sud-Est, 2 = Est, 3 = Nord-Est,
 *   4 = Nord (dos), 5 = Nord-Ouest, 6 = Ouest, 7 = Sud-Ouest.
 */
public class ArenaOfKingsGame extends ApplicationAdapter {
  private static final float SPEED = 500f;
  private static final float SCALE = 2.5f;
  /** Dezoom : la camera montre ZOOM x plus de monde (1 = pas de zoom). */
  private static final float ZOOM = 2f;
  private static final float IDLE_FPS = 1f / 20f;
  private static final float RUN_FPS = 1f / 40f;
  private static final float HIT_FPS = 1f / 50f;
  private static final String SKIN_MANIFEST = "skins.list";
  private static final String SKIN_DIR = "models/";
  private static final String DEFAULT_SKIN = "wizard/outfit_1/dark";

  private SpriteBatch batch;
  private ShapeRenderer shapes;
  private BitmapFont font;
  private OrthographicCamera cam;
  private TextureAtlas atlas;

  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] idleAnims = new Animation[8];
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] runAnims = new Animation[8];
  /** Clic gauche : "attack" / "attack_run". */
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] attackAnims = new Animation[8];
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] attackRunAnims = new Animation[8];
  /** Clic droit : "cast" / "cast_run". */
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] castAnims = new Animation[8];
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] castRunAnims = new Animation[8];
  /** Action en cours (attaque ou sort) : variantes fixe / en mouvement. */
  private Animation<TextureAtlas.AtlasSprite>[] actAnims = null;
  private Animation<TextureAtlas.AtlasSprite>[] actRunAnims = null;
  private boolean actIsAttack = true;
  /** Taille du canvas d'origine du skin courant (champ "orig" max), en pixels. */
  private float canvasW = 252f;
  private float canvasH = 238f;

  private final Vector2 player = new Vector2(0, 0);
  private final Vector2 mouseWorld = new Vector2(0, 0);
  private String actionLabel = "IDLE";
  private float stateTime = 0f;
  private float actTime = 0f;
  private boolean acting = false;
  private int dir = 0;
  private boolean moving = false;

  // --- UI : selection du personnage ---
  private Stage stage;
  private Skin uiSkin;
  private BitmapFont uiFont;
  private final java.util.List<Texture> uiTextures = new ArrayList<>();
  private SelectBox<String> charBox;
  private SelectBox<String> outfitBox;
  private SelectBox<String> variantBox;
  /** personnage -> tenue -> teintes ("-" = pas de variante). */
  private final Map<String, Map<String, java.util.List<String>>> skins = new TreeMap<>();
  private String curSkin = "";
  private boolean updatingBoxes = false;

  @Override
  public void create() {
    batch = new SpriteBatch();
    shapes = new ShapeRenderer();
    font = new BitmapFont();
    cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    cam.zoom = ZOOM;
    cam.position.set(player.x, player.y, 0);
    cam.update();
    font.getData().setScale(ZOOM);

    loadSkinManifest();
    buildUi();
    loadSkin(DEFAULT_SKIN);
    syncBoxesToSkin(DEFAULT_SKIN);
  }

  // ------------------------------------------------------------------ skins

  /** Lit assets/skins.list (une ligne = dossier contenant full.atlas, ex "wizard/outfit_1/dark"). */
  private void loadSkinManifest() {
    try {
      String content = Gdx.files.internal(SKIN_MANIFEST).readString("UTF-8");
      // Le fichier peut commencer par un BOM UTF-8 (PowerShell) : le retirer
      // sinon la 1re cle contient un caractere invisible et apparait en double.
      if (!content.isEmpty() && content.charAt(0) == '\uFEFF') {
        content = content.substring(1);
      }
      for (String line : content.split("\\r?\\n")) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }
        String[] parts = line.split("/");
        String character = parts[0];
        String outfit = parts.length > 1 ? parts[1] : "-";
        String variant = parts.length > 2 ? parts[2] : "-";
        skins.computeIfAbsent(character, k -> new TreeMap<>())
            .computeIfAbsent(outfit, k -> new ArrayList<>());
        java.util.List<String> variants = skins.get(character).get(outfit);
        if (!variants.contains(variant)) {
          variants.add(variant);
        }
      }
    } catch (Exception e) {
      Gdx.app.log("ArenaOfKings", "manifeste introuvable, repli sur le skin par defaut");
    }
    if (skins.isEmpty()) {
      skins.computeIfAbsent("wizard", k -> new TreeMap<>())
          .computeIfAbsent("outfit_1", k -> new ArrayList<>()).add("dark");
    }
    for (Map<String, java.util.List<String>> outfits : skins.values()) {
      for (java.util.List<String> variants : outfits.values()) {
        variants.sort(String::compareTo);
      }
    }
  }

  /** Charge un skin : nouvel atlas + reconstruction des 8 directions. */
  private void loadSkin(String relDir) {
    if (relDir.equals(curSkin) && atlas != null) {
      return;
    }
    TextureAtlas next;
    try {
      next = new TextureAtlas(Gdx.files.internal(SKIN_DIR + relDir + "/full.atlas"));
    } catch (Exception e) {
      Gdx.app.log("ArenaOfKings", "skin illisible : " + relDir);
      return;
    }
    if (atlas != null) {
      atlas.dispose();
    }
    atlas = next;

    for (int d = 0; d < 8; d++) {
      idleAnims[d] = buildAnim("idle", d, IDLE_FPS, Animation.PlayMode.LOOP);
      runAnims[d] = buildAnim("run", d, RUN_FPS, Animation.PlayMode.LOOP);
      attackAnims[d] = buildAnim("attack", d, HIT_FPS, Animation.PlayMode.NORMAL);
      attackRunAnims[d] = buildAnim("attack_run", d, HIT_FPS, Animation.PlayMode.NORMAL);
      castAnims[d] = buildAnim("cast", d, HIT_FPS, Animation.PlayMode.NORMAL);
      castRunAnims[d] = buildAnim("cast_run", d, HIT_FPS, Animation.PlayMode.NORMAL);
    }
    applyFallback(idleAnims);
    applyFallback(runAnims);
    applyFallback(attackAnims);
    applyFallback(attackRunAnims);
    applyFallback(castAnims);
    applyFallback(castRunAnims);

    canvasW = 1;
    canvasH = 1;
    for (TextureAtlas.AtlasRegion r : atlas.getRegions()) {
      canvasW = Math.max(canvasW, r.originalWidth);
      canvasH = Math.max(canvasH, r.originalHeight);
    }
    curSkin = relDir;
    stateTime = 0f;
    acting = false;
    actAnims = null;
    actRunAnims = null;
  }

  /**
   * Construit une animation pour (nom, direction) en filtrant sur index = dir*10000 + frame.
   * Utilise AtlasSprite (et non TextureRegion brute) car de nombreuses frames sont packees
   * avec "rotate: true" : seul AtlasSprite compense la rotation de 90 degres a l'affichage.
   */
  private Animation<TextureAtlas.AtlasSprite> buildAnim(String animName, int direction, float frameDuration,
      Animation.PlayMode mode) {
    java.util.List<TextureAtlas.AtlasRegion> list = new ArrayList<>();
    for (TextureAtlas.AtlasRegion r : atlas.getRegions()) {
      if (animName.equals(r.name) && r.index / 10000 == direction) {
        list.add(r);
      }
    }
    if (list.isEmpty()) {
      return null;
    }
    list.sort(Comparator.comparingInt(r -> r.index % 10000));
    com.badlogic.gdx.utils.Array<TextureAtlas.AtlasSprite> frames = new com.badlogic.gdx.utils.Array<>();
    for (TextureAtlas.AtlasRegion r : list) {
      frames.add(new TextureAtlas.AtlasSprite(r));
    }
    return new Animation<>(frameDuration, frames, mode);
  }

  /** Remplace les directions manquantes par la direction non-nulle la plus proche. */
  private void applyFallback(Animation<TextureAtlas.AtlasSprite>[] anims) {
    for (int d = 0; d < 8; d++) {
      if (anims[d] != null) {
        continue;
      }
      for (int k = 1; k < 8; k++) {
        Animation<TextureAtlas.AtlasSprite> cand = anims[(d + k) % 8];
        if (cand != null) {
          anims[d] = cand;
          break;
        }
      }
    }
  }

  // ------------------------------------------------------------------ UI

  private TextureRegionDrawable boxDrawable(Color c) {
    Pixmap pm = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    pm.setColor(c);
    pm.fill();
    Texture t = new Texture(pm);
    pm.dispose();
    uiTextures.add(t);
    return new TextureRegionDrawable(new TextureRegion(t));
  }

  private void buildUi() {
    uiFont = new BitmapFont();
    uiSkin = new Skin();
    uiSkin.add("default-font", uiFont, BitmapFont.class);

    ScrollPane.ScrollPaneStyle scrollStyle = new ScrollPane.ScrollPaneStyle();
    scrollStyle.background = boxDrawable(new Color(0.10f, 0.10f, 0.14f, 0.95f));
    scrollStyle.vScroll = boxDrawable(new Color(0.25f, 0.25f, 0.32f, 1f));
    scrollStyle.vScrollKnob = boxDrawable(new Color(0.55f, 0.55f, 0.65f, 1f));
    scrollStyle.hScroll = boxDrawable(new Color(0.25f, 0.25f, 0.32f, 1f));
    scrollStyle.hScrollKnob = boxDrawable(new Color(0.55f, 0.55f, 0.65f, 1f));

    List.ListStyle listStyle = new List.ListStyle();
    listStyle.font = uiFont;
    listStyle.fontColorSelected = Color.WHITE;
    listStyle.fontColorUnselected = new Color(0.85f, 0.85f, 0.85f, 1f);
    listStyle.selection = boxDrawable(new Color(0.25f, 0.45f, 0.75f, 1f));
    listStyle.background = boxDrawable(new Color(0.10f, 0.10f, 0.14f, 0.95f));

    SelectBox.SelectBoxStyle boxStyle = new SelectBox.SelectBoxStyle();
    boxStyle.font = uiFont;
    boxStyle.fontColor = Color.WHITE;
    boxStyle.background = boxDrawable(new Color(0.16f, 0.16f, 0.22f, 0.95f));
    boxStyle.scrollStyle = scrollStyle;
    boxStyle.listStyle = listStyle;
    uiSkin.add("default", boxStyle, SelectBox.SelectBoxStyle.class);

    Label.LabelStyle labelStyle = new Label.LabelStyle(uiFont, Color.WHITE);

    charBox = new SelectBox<>(uiSkin);
    outfitBox = new SelectBox<>(uiSkin);
    variantBox = new SelectBox<>(uiSkin);
    charBox.setStyle(boxStyle);
    outfitBox.setStyle(boxStyle);
    variantBox.setStyle(boxStyle);

    ChangeListener reload = new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        if (updatingBoxes) {
          return;
        }
        if (actor == charBox) {
          refreshOutfitBox(selectedOrFirst(charBox));
          refreshVariantBox(selectedOrFirst(charBox), selectedOrFirst(outfitBox));
        } else if (actor == outfitBox) {
          refreshVariantBox(selectedOrFirst(charBox), selectedOrFirst(outfitBox));
        }
        loadSkin(currentSelection());
      }
    };
    charBox.addListener(reload);
    outfitBox.addListener(reload);
    variantBox.addListener(reload);

    Table root = new Table();
    root.top().left();
    root.setFillParent(true);
    root.pad(10);
    root.defaults().left().padRight(8);
    root.add(new Label("Perso", labelStyle));
    root.add(charBox).width(150);
    root.add(new Label("Tenue", labelStyle));
    root.add(outfitBox).width(130);
    root.add(new Label("Teinte", labelStyle));
    root.add(variantBox).width(110);

    stage = new Stage(new ScreenViewport());
    stage.addActor(root);
    Gdx.input.setInputProcessor(stage);
  }

  private String selectedOrFirst(SelectBox<String> box) {
    String s = box.getSelected();
    if (s == null && box.getItems().size > 0) {
      s = box.getItems().first();
    }
    return s == null ? "-" : s;
  }

  private void setBoxItems(SelectBox<String> box, java.util.List<String> items, String keep) {
    com.badlogic.gdx.utils.Array<String> arr = new com.badlogic.gdx.utils.Array<>(items.toArray(new String[0]));
    box.setItems(arr);
    box.setSelected(items.contains(keep) ? keep : items.get(0));
  }

  private void refreshCharBox(String keep) {
    setBoxItems(charBox, new ArrayList<>(skins.keySet()), keep);
  }

  private void refreshOutfitBox(String character) {
    Map<String, java.util.List<String>> outfits = skins.get(character);
    if (outfits == null) {
      return;
    }
    setBoxItems(outfitBox, new ArrayList<>(outfits.keySet()), selectedOrFirst(outfitBox));
  }

  private void refreshVariantBox(String character, String outfit) {
    Map<String, java.util.List<String>> outfits = skins.get(character);
    if (outfits == null) {
      return;
    }
    java.util.List<String> variants = outfits.get(outfit);
    if (variants == null) {
      return;
    }
    setBoxItems(variantBox, variants, selectedOrFirst(variantBox));
  }

  /** Selection courante sous forme "perso/tenue[/teinte]". */
  private String currentSelection() {
    String c = selectedOrFirst(charBox);
    String o = selectedOrFirst(outfitBox);
    String v = selectedOrFirst(variantBox);
    return "-".equals(v) ? c + "/" + o : c + "/" + o + "/" + v;
  }

  private void syncBoxesToSkin(String relDir) {
    updatingBoxes = true;
    try {
      String[] parts = relDir.split("/");
      refreshCharBox(parts[0]);
      refreshOutfitBox(parts[0]);
      refreshVariantBox(parts[0], parts.length > 1 ? parts[1] : "-");
      if (parts.length > 2) {
        variantBox.setSelected(parts[2]);
      }
    } finally {
      updatingBoxes = false;
    }
  }

  // ------------------------------------------------------------------ jeu

  /**
   * Convertit un vecteur (dx, dy) en monde vers une direction 0..7.
   * 0=S, 1=SE, 2=E, 3=NE, 4=N, 5=NO, 6=O, 7=SO.
   */
  static int computeDir(float dx, float dy) {
    if (dx == 0 && dy == 0) {
      return 0;
    }
    float ang = MathUtils.atan2(dy, dx) * MathUtils.radiansToDegrees; // -180..180, 0=Est
    if (ang < 0) {
      ang += 360f;
    }
    return (Math.round(ang / 45f) + 2) % 8;
  }

  @Override
  public void render() {
    float dt = Math.min(Gdx.graphics.getDeltaTime(), 1f / 20f);
    stateTime += dt;

    // --- Deplacement ZQSD (on accepte aussi WASD + fleches pour AZERTY/QWERTY) ---
    float ix = 0, iy = 0;
    if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.Z)
        || Gdx.input.isKeyPressed(Input.Keys.UP)) {
      iy += 1;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      iy -= 1;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.Q)
        || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      ix -= 1;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      ix += 1;
    }
    moving = (ix != 0 || iy != 0);
    if (moving) {
      float len = (float) Math.sqrt(ix * ix + iy * iy);
      ix /= len;
      iy /= len;
      player.x += ix * SPEED * dt;
      player.y += iy * SPEED * dt;
    }

    // --- Souris -> monde, orientation du personnage ---
    Vector3 m = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
    cam.unproject(m);
    mouseWorld.set(m.x, m.y);
    dir = computeDir(mouseWorld.x - player.x, mouseWorld.y - player.y);

    // --- Clics : gauche = attaque, droit = sort (ignore si c'est l'UI qui est cliquee) ---
    Vector2 st = stage.screenToStageCoordinates(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
    boolean overUi = stage.hit(st.x, st.y, true) != null;
    if (!overUi) {
      if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && attackAnims[dir] != null) {
        acting = true;
        actTime = 0f;
        actAnims = attackAnims;
        actRunAnims = attackRunAnims;
        actIsAttack = true;
      } else if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT) && castAnims[dir] != null) {
        acting = true;
        actTime = 0f;
        actAnims = castAnims;
        actRunAnims = castRunAnims;
        actIsAttack = false;
      }
    }
    if (acting) {
      actTime += dt;
      if (actAnims[dir] == null || actAnims[dir].isAnimationFinished(actTime)) {
        acting = false;
      }
    }
    if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }

    // --- Camera verrouillee sur le joueur : personnage toujours centre ---
    cam.position.set(player.x, player.y, 0);
    cam.update();

    ScreenUtils.clear(0.07f, 0.07f, 0.11f, 1f);

    drawGrid();
    drawPlayer();
    drawHud();

    stage.act(dt);
    stage.draw();
  }

  /** Grille monde pour visualiser le mouvement (camera suiveuse oblige). */
  private void drawGrid() {
    shapes.setProjectionMatrix(cam.combined);
    shapes.begin(ShapeRenderer.ShapeType.Line);
    float step = 128f;
    // Avec le zoom, la zone visible vaut viewport * zoom.
    float w = cam.viewportWidth * cam.zoom, h = cam.viewportHeight * cam.zoom;
    float x0 = player.x - w / 2, x1 = player.x + w / 2;
    float y0 = player.y - h / 2, y1 = player.y + h / 2;
    shapes.setColor(new Color(0.16f, 0.16f, 0.22f, 1f));
    for (float x = (float) Math.floor(x0 / step) * step; x <= x1; x += step) {
      shapes.line(x, y0, x, y1);
    }
    for (float y = (float) Math.floor(y0 / step) * step; y <= y1; y += step) {
      shapes.line(x0, y, x1, y);
    }
    // axes origine
    shapes.setColor(new Color(0.3f, 0.3f, 0.4f, 1f));
    shapes.line(x0, 0, x1, 0);
    shapes.line(0, y0, 0, y1);
    // viseur souris + ligne de visee
    shapes.setColor(Color.ORANGE);
    shapes.line(player.x, player.y, mouseWorld.x, mouseWorld.y);
    shapes.circle(mouseWorld.x, mouseWorld.y, 12f * cam.zoom, 24);
    shapes.end();
  }

  private void drawPlayer() {
    Animation<TextureAtlas.AtlasSprite> anim;
    float t;
    if (acting && actAnims != null && actAnims[dir] != null) {
      // En mouvement on prefere la variante "run" de l'action (attack_run / cast_run).
      if (moving && actRunAnims != null && actRunAnims[dir] != null) {
        anim = actRunAnims[dir];
        actionLabel = actIsAttack ? "ATTAQUE_RUN" : "CAST_RUN";
      } else {
        anim = actAnims[dir];
        actionLabel = actIsAttack ? "ATTAQUE" : "CAST";
      }
      t = actTime;
    } else if (moving) {
      anim = runAnims[dir];
      t = stateTime;
      actionLabel = "RUN";
    } else {
      anim = idleAnims[dir];
      t = stateTime;
      actionLabel = "IDLE";
    }
    TextureAtlas.AtlasSprite sprite = anim.getKeyFrame(t, anim.getPlayMode() == Animation.PlayMode.LOOP);

    // dimensions du canvas d'origine du skin courant mises a l'echelle
    float w = canvasW * SCALE;
    float h = canvasH * SCALE;

    // setBounds positionne le sprite dans l'espace du canvas d'origine :
    // offsets + rotation d'atlas geres par AtlasSprite, plus de frame a 90 degres ni de tremblement.
    batch.setProjectionMatrix(cam.combined);
    batch.begin();
    sprite.setBounds(player.x - w / 2f, player.y - h / 2f, w, h);
    sprite.draw(batch);
    batch.end();
  }

  private void drawHud() {
    batch.setProjectionMatrix(cam.combined);
    // texte en bas-gauche de la vue (le panneau perso est en haut-gauche)
    float vw = cam.viewportWidth * cam.zoom, vh = cam.viewportHeight * cam.zoom;
    float hx = cam.position.x - vw / 2 + 12 * cam.zoom;
    float base = cam.position.y - vh / 2 + 12 * cam.zoom;
    batch.begin();
    font.setColor(Color.LIGHT_GRAY);
    String state = actionLabel;
    font.draw(batch, "ZQSD / WASD / Fleches = bouger | Clic gauche = attaque | Clic droit = sort | Echap = quitter", hx, base + 40 * cam.zoom);
    font.draw(batch, "skin=" + curSkin + " etat=" + state + " dir=" + dir, hx, base + 20 * cam.zoom);
    font.draw(batch, "0=S 1=SE 2=E 3=NE 4=N 5=NO 6=O 7=SO", hx, base);
    batch.end();
  }

  @Override
  public void resize(int width, int height) {
    cam.viewportWidth = width;
    cam.viewportHeight = height;
    cam.zoom = ZOOM;
    cam.update();
    font.getData().setScale(ZOOM);
    stage.getViewport().update(width, height, true);
  }

  @Override
  public void dispose() {
    batch.dispose();
    shapes.dispose();
    font.dispose();
    uiFont.dispose();
    for (Texture t : uiTextures) {
      t.dispose();
    }
    stage.dispose();
    atlas.dispose();
  }
}
