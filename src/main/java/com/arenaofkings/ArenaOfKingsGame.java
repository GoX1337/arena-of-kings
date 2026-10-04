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
 * Minimal game: screen-centered character, ZQSD movement, mouse aiming.
 * Character + outfit + shade selectable via 3 dropdown lists (skins under models/).
 *
 * 8-direction mapping derived from the atlases (index = dir * 10000 + frame):
 *   0 = South (facing camera), 1 = South-East, 2 = East, 3 = North-East,
 *   4 = North (back), 5 = North-West, 6 = West, 7 = South-West.
 */
public class ArenaOfKingsGame extends ApplicationAdapter {
  private static final float SPEED = 500f;
  private static final float SCALE = 2.5f;
  /** Zoom out: the camera shows ZOOM x more world (1 = no zoom). */
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
  /** Left click: "attack" / "attack_run". */
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] attackAnims = new Animation[8];
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] attackRunAnims = new Animation[8];
  /** Right click: "cast" / "cast_run". */
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] castAnims = new Animation[8];
  @SuppressWarnings("unchecked")
  private Animation<TextureAtlas.AtlasSprite>[] castRunAnims = new Animation[8];
  /** Ongoing action (attack or spell): stationary / moving variants. */
  private Animation<TextureAtlas.AtlasSprite>[] actAnims = null;
  private Animation<TextureAtlas.AtlasSprite>[] actRunAnims = null;
  private boolean actIsAttack = true;
  /** Original canvas size of the current skin (max "orig" field), in pixels. */
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

  // --- UI: character selection ---
  private Stage stage;
  private Skin uiSkin;
  private BitmapFont uiFont;
  private final java.util.List<Texture> uiTextures = new ArrayList<>();
  private SelectBox<String> charBox;
  private SelectBox<String> outfitBox;
  private SelectBox<String> variantBox;
  /** character -> outfit -> shades ("-" = no variant). */
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

  /** Reads assets/skins.list (one line = folder containing full.atlas, e.g. "wizard/outfit_1/dark"). */
  private void loadSkinManifest() {
    try {
      String content = Gdx.files.internal(SKIN_MANIFEST).readString("UTF-8");
      // The file may start with a UTF-8 BOM (PowerShell): strip it,
      // otherwise the first key contains an invisible char and shows up twice.
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
      Gdx.app.log("ArenaOfKings", "manifest not found, falling back to default skin");
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

  /** Loads a skin: new atlas + rebuild of the 8 directions. */
  private void loadSkin(String relDir) {
    if (relDir.equals(curSkin) && atlas != null) {
      return;
    }
    TextureAtlas next;
    try {
      next = new TextureAtlas(Gdx.files.internal(SKIN_DIR + relDir + "/full.atlas"));
    } catch (Exception e) {
      Gdx.app.log("ArenaOfKings", "unreadable skin: " + relDir);
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
   * Builds an animation for (name, direction) by filtering on index = dir*10000 + frame.
   * Uses AtlasSprite (not a raw TextureRegion) because many frames are packed
   * with "rotate: true": only AtlasSprite compensates the 90-degree rotation at render time.
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

  /** Replaces missing directions with the closest non-empty direction. */
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
    root.add(new Label("Character", labelStyle));
    root.add(charBox).width(150);
    root.add(new Label("Outfit", labelStyle));
    root.add(outfitBox).width(130);
    root.add(new Label("Shade", labelStyle));
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

  /** Current selection as "character/outfit[/shade]". */
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

  // ------------------------------------------------------------------ game

  /**
   * Converts a world-space vector (dx, dy) to a direction 0..7.
   * 0=S, 1=SE, 2=E, 3=NE, 4=N, 5=NW, 6=W, 7=SW.
   */
  static int computeDir(float dx, float dy) {
    if (dx == 0 && dy == 0) {
      return 0;
    }
    float ang = MathUtils.atan2(dy, dx) * MathUtils.radiansToDegrees; // -180..180, 0=East
    if (ang < 0) {
      ang += 360f;
    }
    return (Math.round(ang / 45f) + 2) % 8;
  }

  @Override
  public void render() {
    float dt = Math.min(Gdx.graphics.getDeltaTime(), 1f / 20f);
    stateTime += dt;

    // --- ZQSD movement (also accept WASD + arrows for AZERTY/QWERTY) ---
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

    // --- Mouse -> world, character facing ---
    Vector3 m = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
    cam.unproject(m);
    mouseWorld.set(m.x, m.y);
    dir = computeDir(mouseWorld.x - player.x, mouseWorld.y - player.y);

    // --- Clicks: left = attack, right = spell (ignored when the UI is clicked) ---
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

    // --- Camera locked on the player: character always centered ---
    cam.position.set(player.x, player.y, 0);
    cam.update();

    ScreenUtils.clear(0.07f, 0.07f, 0.11f, 1f);

    drawGrid();
    drawPlayer();
    drawHud();

    stage.act(dt);
    stage.draw();
  }

  /** World grid to visualize movement (required with a follow camera). */
  private void drawGrid() {
    shapes.setProjectionMatrix(cam.combined);
    shapes.begin(ShapeRenderer.ShapeType.Line);
    float step = 128f;
    // With zoom, the visible area is viewport * zoom.
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
    // origin axes
    shapes.setColor(new Color(0.3f, 0.3f, 0.4f, 1f));
    shapes.line(x0, 0, x1, 0);
    shapes.line(0, y0, 0, y1);
    // mouse cursor + aim line
    shapes.setColor(Color.ORANGE);
    shapes.line(player.x, player.y, mouseWorld.x, mouseWorld.y);
    shapes.circle(mouseWorld.x, mouseWorld.y, 12f * cam.zoom, 24);
    shapes.end();
  }

  private void drawPlayer() {
    Animation<TextureAtlas.AtlasSprite> anim;
    float t;
    if (acting && actAnims != null && actAnims[dir] != null) {
      // While moving, prefer the "run" variant of the action (attack_run / cast_run).
      if (moving && actRunAnims != null && actRunAnims[dir] != null) {
        anim = actRunAnims[dir];
        actionLabel = actIsAttack ? "ATTACK_RUN" : "CAST_RUN";
      } else {
        anim = actAnims[dir];
        actionLabel = actIsAttack ? "ATTACK" : "CAST";
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

    // scaled original-canvas dimensions of the current skin
    float w = canvasW * SCALE;
    float h = canvasH * SCALE;

    // setBounds positions the sprite in the original-canvas space:
    // atlas offsets + rotation handled by AtlasSprite, no more 90-degree frames or jitter.
    batch.setProjectionMatrix(cam.combined);
    batch.begin();
    sprite.setBounds(player.x - w / 2f, player.y - h / 2f, w, h);
    sprite.draw(batch);
    batch.end();
  }

  private void drawHud() {
    batch.setProjectionMatrix(cam.combined);
    // text at the bottom-left of the view (character panel is top-left)
    float vw = cam.viewportWidth * cam.zoom, vh = cam.viewportHeight * cam.zoom;
    float hx = cam.position.x - vw / 2 + 12 * cam.zoom;
    float base = cam.position.y - vh / 2 + 12 * cam.zoom;
    batch.begin();
    font.setColor(Color.LIGHT_GRAY);
    String state = actionLabel;
    font.draw(batch, "ZQSD / WASD / Arrows = move | Left click = attack | Right click = spell | Esc = quit", hx, base + 40 * cam.zoom);
    font.draw(batch, "skin=" + curSkin + " state=" + state + " dir=" + dir, hx, base + 20 * cam.zoom);
    font.draw(batch, "0=S 1=SE 2=E 3=NE 4=N 5=NW 6=W 7=SW", hx, base);
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
