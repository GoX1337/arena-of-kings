package com.arenaofkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Cursor;
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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.arenaofkings.net.Net;
import com.arenaofkings.net.NetClient;

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

  // --- Custom mouse cursor: gray default, gray "down" while a button is held ---
  private Cursor cursorNormal;
  private Cursor cursorDown;
  private boolean cursorIsDown = false;

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

  // --- Spell bar: clickable spells of the selected character ---
  private static final float SPELL_COOLDOWN = 4f;
  private static final float SPELL_FX_FPS = 1f / 30f;
  private static final float SPELL_TICK_TIME = 1.0f;
  private static final int MAX_EFFECTS = 12;
  private TextureAtlas spellIcons;
  private Table spellBar;
  private final java.util.List<ImageButton> spellButtons = new ArrayList<>();
  private final java.util.List<Label> spellLabels = new ArrayList<>();
  private final java.util.List<Table> spellVeils = new ArrayList<>();
  private final java.util.List<Label> spellCdLabels = new ArrayList<>();
  private final java.util.List<Float> spellCooldowns = new ArrayList<>();
  private static final int SPELLS_PER_ROW = 8;
  private static final int SPELL_KEYS = 9;
  private String spellCharacter = "";
  private String lastCastSpell = "-";
  private Label lastSpellLabel;
  /** Manual hover tooltip (reliable positioning, follows the mouse). */
  private Table tooltipBox;
  private Label tooltipTitle;
  private Label tooltipBody;

  /** World-anchored spell visual: tick loop, then optional one-shot impact. */
  private static final class ActiveEffect {
    TextureAtlas atlas;
    Animation<TextureAtlas.AtlasSprite> tick;
    Animation<TextureAtlas.AtlasSprite> impact;
    float time;
    float x, y, w, h;
    boolean impactPhase;
  }

  private final java.util.List<ActiveEffect> effects = new ArrayList<>();
  private final Map<String, Sound> soundCache = new TreeMap<>();

  // --- Net movement (server authoritative, local fallback when unreachable) ---
  private NetClient net;
  private boolean netMode;
  private final Map<Integer, Vector2> netRender = new TreeMap<>();
  private final Map<Integer, Integer> netDir = new TreeMap<>();
  private final java.util.Set<Integer> netMoving = new java.util.HashSet<>();
  private final Map<Integer, String> netSkins = new TreeMap<>();
  private float lastNetIx;
  private float lastNetIy;
  private int lastNetDir = -1;
  private long lastNetSend;
  private final Vector2 tmpV = new Vector2();

  /** Prediction history for reconciliation: seq -> input + send time. */
  private static final class Hist {
    float x, y;
    long ms;
  }

  private final java.util.TreeMap<Integer, Hist> netHist = new java.util.TreeMap<>();
  /** Last prediction error (distance to server pos before reconcile). */
  private float netErr;
  /** Worst prediction error since connect (diagnoses snaps vs smooth melt). */
  private float netMaxErr;
  /** Temporary network diagnosis logs (game output). Flip off when done. */
  private static final boolean NET_DEBUG = true;
  private long lastSnapMs = -1;
  /** Interpolation buffer: recent snapshots with local receipt time. */
  private static final class Snap {
    Net.Snapshot s;
    long at;
  }

  private final java.util.ArrayDeque<Snap> netSnaps = new java.util.ArrayDeque<>();
  private static final long INTERP_DELAY_NS = 100_000_000L;
  private static final long INTERP_KEEP_NS = 600_000_000L;

  /** Remote player skin (shared cache, one atlas per skin folder). */
  private static final class RemoteSkin {
    @SuppressWarnings("unchecked")
    final Animation<TextureAtlas.AtlasSprite>[] idle = new Animation[8];
    @SuppressWarnings("unchecked")
    final Animation<TextureAtlas.AtlasSprite>[] run = new Animation[8];
    TextureAtlas atlas;
    float canvasW = 1;
    float canvasH = 1;
  }

  private final Map<String, RemoteSkin> remoteSkins = new TreeMap<>();
  private final java.util.Set<String> badRemoteSkins = new java.util.HashSet<>();

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

    Pixmap cursorPm = new Pixmap(Gdx.files.internal("cursors/cursor_default_gray.png"));
    cursorNormal = Gdx.graphics.newCursor(cursorPm, 0, 0);
    cursorPm.dispose();
    cursorPm = new Pixmap(Gdx.files.internal("cursors/cursor_down_gray.png"));
    cursorDown = Gdx.graphics.newCursor(cursorPm, 0, 0);
    cursorPm.dispose();
    Gdx.graphics.setCursor(cursorNormal);

    loadSkinManifest();
    buildUi();
    buildSpellBar();
    loadSkin(DEFAULT_SKIN);
    syncBoxesToSkin(DEFAULT_SKIN);
    rebuildSpells(selectedOrFirst(charBox));

    net = new NetClient();
    // Host override for VPS play: env AOK_HOST, else -Dserver.host=<ip-or-dns>.
    String host = System.getenv().getOrDefault("AOK_HOST",
        System.getProperty("server.host", "127.0.0.1"));
    netMode = net.connect(host, 2000, currentSelection());
    if (!netMode) {
      Gdx.app.log("ArenaOfKings", "no server at " + host + ", local movement fallback");
    }
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

  /** Same as {@link #buildAnimFor} on the current skin atlas. */
  private Animation<TextureAtlas.AtlasSprite> buildAnim(String animName, int direction, float frameDuration,
      Animation.PlayMode mode) {
    return buildAnimFor(atlas, animName, direction, frameDuration, mode);
  }

  /**
   * Builds an animation for (name, direction) by filtering on index = dir*10000 + frame.
   * Uses AtlasSprite (not a raw TextureRegion) because many frames are packed
   * with "rotate: true": only AtlasSprite compensates the 90-degree rotation at render time.
   */
  private Animation<TextureAtlas.AtlasSprite> buildAnimFor(TextureAtlas a, String animName, int direction,
      float frameDuration, Animation.PlayMode mode) {
    java.util.List<TextureAtlas.AtlasRegion> list = new ArrayList<>();
    for (TextureAtlas.AtlasRegion r : a.getRegions()) {
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
        rebuildSpells(selectedOrFirst(charBox));
        if (netMode) {
          net.sendSkin(currentSelection());
        }
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

  // ------------------------------------------------------------ spell bar

  private void buildSpellBar() {
    spellIcons = new TextureAtlas(Gdx.files.internal("icons/SpellIcons-10.atlas"));
    Label.LabelStyle labelStyle = new Label.LabelStyle(uiFont, Color.WHITE);
    lastSpellLabel = new Label("Sort: -", labelStyle);

    // Tooltip descriptions reuse the [TAG]...[] markup from the decompiled code.
    uiFont.getData().markupEnabled = true;
    putMarkupColor("white", Color.WHITE);
    putMarkupColor("orange", new Color(1f, 0.65f, 0f, 1f));
    putMarkupColor("green", Color.GREEN);
    putMarkupColor("yellow", Color.YELLOW);
    putMarkupColor("red", Color.RED);
    putMarkupColor("sky", new Color(0.53f, 0.81f, 0.92f, 1f));
    putMarkupColor("gold", new Color(1f, 0.84f, 0f, 1f));
    putMarkupColor("violet", new Color(0.6f, 0.2f, 1f, 1f));
    putMarkupColor("teal", new Color(0f, 0.5f, 0.5f, 1f));
    putMarkupColor("brown", new Color(0.65f, 0.25f, 0.15f, 1f));
    putMarkupColor("salmon", new Color(0.98f, 0.5f, 0.45f, 1f));
    putMarkupColor("purple", new Color(0.63f, 0.13f, 0.94f, 1f));

    tooltipTitle = new Label("", labelStyle);
    tooltipBody = new Label("", labelStyle);
    tooltipBody.setWrap(true);
    tooltipBox = new Table();
    tooltipBox.setBackground(boxDrawable(new Color(0.06f, 0.06f, 0.09f, 0.97f)));
    tooltipBox.pad(8);
    tooltipBox.add(tooltipTitle).left().row();
    tooltipBox.add(tooltipBody).width(400).left();
    tooltipBox.setVisible(false);
    tooltipBox.setTouchable(Touchable.disabled);
    stage.addActor(tooltipBox);

    spellBar = new Table();
    spellBar.bottom();
    spellBar.setFillParent(true);
    spellBar.pad(10);
    // Only the buttons block clicks; empty bar area lets attacks through.
    spellBar.setTouchable(Touchable.childrenOnly);
    spellBar.add(lastSpellLabel).colspan(8).padBottom(4);
    spellBar.row();
    stage.addActor(spellBar);
  }

  /** Registers a markup color under both cases (lookup case varies by tag). */
  private static void putMarkupColor(String name, Color color) {
    Colors.put(name.toLowerCase(java.util.Locale.ROOT), color);
    Colors.put(name.toUpperCase(java.util.Locale.ROOT), color);
  }

  /** Fills and shows the hover tooltip near the cursor (official EN description). */
  private void showSpellTip(String spell, float stageX, float stageY) {
    tooltipTitle.setText(spellHeader(spell));
    String desc = SpellDescriptions.description(spellCharacter, spell);
    tooltipBody.setText(desc == null
        ? "No official description found in decompiled code."
        : resolveSpellValues(spell, decodeNoise(desc)));
    tooltipBox.pack();
    moveSpellTip(stageX, stageY);
    tooltipBox.setVisible(true);
    tooltipBox.toFront();
  }

  /**
   * Restores words mangled by the Client.jar rename step: obfuscated classes were
   * literally named {@code to/of/is/on/in/it}, and the whole-word rename replaced them
   * even inside tooltip strings ({@code MAPPING.csv}: {@code to}→RunicShieldEnchantment,
   * {@code of}→WIZARD_MagicMissiles, {@code is}→CHAMPION_Lacerate,
   * {@code on}→WIZARD_VolcanicEruption, {@code in}→CHAMPION_CrushingBlow,
   * {@code it}→CHAMPION_MasterOfTheSword). Verified byte-for-byte against the jar's
   * constant pool (Fireball, Annihilate, Daze, Envenom, Slap): decoded text == original.
   */
  private static String decodeNoise(String desc) {
    return desc.replace("RunicShieldEnchantment", "to")
        .replace("WIZARD_MagicMissiles", "of")
        .replace("CHAMPION_Lacerate", "is")
        .replace("WIZARD_VolcanicEruption", "on")
        .replace("CHAMPION_CrushingBlow", "in")
        .replace("CHAMPION_MasterOfTheSword", "it");
  }

  /**
   * Replaces {@code %d} markers like the original client does: each marker takes the
   * next {@code a(coef)} value, i.e. {@code (int)(Power * coef)} evaluated with Java int
   * semantics (see {@code ui.a(double)} in Client.jar). Power defaults to the base 365
   * shared by every class ({@code dg} stat sheet), so values are level-1 without gear.
   */
  private String resolveSpellValues(String spell, String desc) {
    int[] values = SpellDescriptions.values(spellCharacter, spell);
    if (values == null || values.length == 0) {
      return desc;
    }
    StringBuilder out = new StringBuilder();
    int from = 0;
    int i = 0;
    int at;
    while ((at = desc.indexOf("%d", from)) >= 0 && i < values.length) {
      out.append(desc, from, at).append(values[i++]);
      from = at + 2;
    }
    out.append(desc.substring(from));
    return out.toString();
  }

  private void hideSpellTip() {
    tooltipBox.setVisible(false);
  }

  /** Keeps the tooltip next to the cursor and inside the screen. */
  private void moveSpellTip(float stageX, float stageY) {
    float w = tooltipBox.getWidth();
    float h = tooltipBox.getHeight();
    float x = stageX + 16;
    float y = stageY - h - 12;
    float sw = stage.getWidth();
    float sh = stage.getHeight();
    if (x + w > sw) {
      x = Math.max(0, stageX - w - 16);
    }
    if (y < 0) {
      y = Math.min(sh - h, stageY + 16);
    }
    tooltipBox.setPosition(x, Math.max(0, y));
  }

  /** "Name  instant  CD 4s  45 Energy" from the code's mechanic fields. */
  private String spellHeader(String spell) {
    String stats = SpellDescriptions.stats(spellCharacter, spell);
    if (stats == null) {
      return "[GOLD]" + spell + "[]";
    }
    String[] p = stats.split("\\|");
    String res = "c".equals(p[3]) ? "Mana" : "d".equals(p[3]) ? "Energy"
        : "e".equals(p[3]) ? "Rage" : "";
    String kind = p.length > 5 && "a".equals(p[5]) ? "arme" : "sort";
    return "[GOLD]" + p[0] + "[]  " + castText(p[1]) + "  CD " + castText(p[2])
        + (res.isEmpty() ? "" : "  " + p[4] + " " + res) + "  - " + kind;
  }

  private static String castText(String ms) {
    if ("0".equals(ms) || "-1".equals(ms)) {
      return "instant";
    }
    try {
      float s = Long.parseLong(ms) / 1000f;
      return (s == (long) s ? String.valueOf((long) s) : String.valueOf(s)) + "s";
    } catch (NumberFormatException e) {
      return ms + "ms";
    }
  }

  /** Rebuilds bar buttons + clears effects/sounds for the selected character. */
  private void rebuildSpells(String character) {
    if (character.equals(spellCharacter)) {
      return;
    }
    spellCharacter = character;
    clearEffects();
    hideSpellTip();
    for (Sound s : soundCache.values()) {
      s.dispose();
    }
    soundCache.clear();
    spellBar.clear();
    spellBar.add(lastSpellLabel).colspan(8).padBottom(4);
    spellBar.row();
    spellButtons.clear();
    spellLabels.clear();
    spellVeils.clear();
    spellCdLabels.clear();
    spellCooldowns.clear();

    String[] spells = Spells.forCharacter(character);
    Label.LabelStyle labelStyle = new Label.LabelStyle(uiFont, Color.WHITE);
    for (int i = 0; i < spells.length; i++) {
      final int slot = i;
      final String spellName = spells[i];
      TextureAtlas.AtlasRegion icon = spellIcons.findRegion(spellName);
      if (icon == null) {
        icon = spellIcons.findRegion("temp_icon");
      }
      // One style instance per button: sharing it would show the same icon everywhere.
      ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
      style.up = boxDrawable(new Color(0.16f, 0.16f, 0.22f, 0.95f));
      style.down = boxDrawable(new Color(0.25f, 0.45f, 0.75f, 1f));
      style.disabled = boxDrawable(new Color(0.08f, 0.08f, 0.10f, 0.70f));
      ImageButton btn = new ImageButton(style);
      if (icon != null) {
        btn.getStyle().imageUp = new TextureRegionDrawable(icon);
        btn.getStyle().imageDisabled = new TextureRegionDrawable(icon);
      }
      btn.addListener(new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
          castSpell(slot);
        }
      });
      // Hover shows the tooltip + previews the spell name below the bar.
      btn.addListener(new InputListener() {
        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
          lastSpellLabel.setText("Sort: " + spellName);
          showSpellTip(spellName, event.getStageX(), event.getStageY());
        }

        @Override
        public boolean mouseMoved(InputEvent event, float x, float y) {
          if (tooltipBox.isVisible()) {
            moveSpellTip(event.getStageX(), event.getStageY());
          }
          return false;
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
          lastSpellLabel.setText("Sort: " + lastCastSpell);
          hideSpellTip();
        }
      });
      Label name = new Label(String.valueOf(i + 1), labelStyle);
      spellButtons.add(btn);
      spellLabels.add(name);
      spellCooldowns.add(0f);
      // Gray veil + countdown stacked over the icon while cooling down.
      Table veil = new Table();
      veil.setBackground(boxDrawable(new Color(0.05f, 0.05f, 0.07f, 0.65f)));
      veil.setVisible(false);
      veil.setTouchable(Touchable.disabled);
      Label cd = new Label("", labelStyle);
      cd.setAlignment(Align.center);
      veil.add(cd).expand().fill();
      spellVeils.add(veil);
      spellCdLabels.add(cd);
      Table cell = new Table();
      Stack stack = new Stack();
      stack.add(btn);
      stack.add(veil);
      cell.add(stack).size(44);
      cell.row();
      cell.add(name);
      spellBar.add(cell).padRight(4);
      if ((i + 1) % SPELLS_PER_ROW == 0 && i + 1 < spells.length) {
        spellBar.row();
      }
    }
    lastCastSpell = "-";
    lastSpellLabel.setText("Sort: -");
  }

  /** Casts a bar spell: cast anim + world FX at the mouse + sound + cooldown. */
  private void castSpell(int slot) {
    String[] spells = Spells.forCharacter(spellCharacter);
    if (slot < 0 || slot >= spells.length || spellCooldowns.get(slot) > 0) {
      return;
    }
    // Weapon abilities (uk.a in the original code: daggers, swords, bows...)
    // play the "attack" animation, magic spells play "cast" (see Spells docs).
    boolean weapon = isWeaponSpell(spells[slot]);
    if (weapon && attackAnims[dir] != null) {
      acting = true;
      actTime = 0f;
      actAnims = attackAnims;
      actRunAnims = attackRunAnims;
      actIsAttack = true;
    } else if (!weapon && castAnims[dir] != null) {
      acting = true;
      actTime = 0f;
      actAnims = castAnims;
      actRunAnims = castRunAnims;
      actIsAttack = false;
    }
    spawnEffect(spells[slot], mouseWorld.x, mouseWorld.y);
    playSpellSound(spells[slot]);
    spellCooldowns.set(slot, SPELL_COOLDOWN);
    spellButtons.get(slot).setDisabled(true);
    spellVeils.get(slot).setVisible(true);
    spellCdLabels.get(slot).setText(String.valueOf((int) Math.ceil(SPELL_COOLDOWN)));
    lastCastSpell = spells[slot];
    lastSpellLabel.setText("Sort: " + lastCastSpell);
  }

  private void spawnEffect(String spell, float x, float y) {
    // Atlas file naming varies: "<spell>_on_tick.atlas" or "<spell>.atlas".
    TextureAtlas atlas = loadSpellAtlas(spell, new String[]{
        spell + "_on_tick.atlas", spell + ".atlas"});
    if (atlas == null) {
      Gdx.app.log("ArenaOfKings", "no FX atlas for spell: " + spell);
      return;
    }
    com.badlogic.gdx.utils.Array<TextureAtlas.AtlasSprite> frames = new com.badlogic.gdx.utils.Array<>();
    for (TextureAtlas.AtlasRegion r : atlas.findRegions(spell + "_on_tick")) {
      frames.add(new TextureAtlas.AtlasSprite(r));
    }
    if (frames.size == 0) {
      atlas.dispose();
      return;
    }
    frames.sort(Comparator.comparingInt(s -> s.getAtlasRegion().index));
    ActiveEffect fx = new ActiveEffect();
    fx.atlas = atlas;
    fx.tick = new Animation<>(SPELL_FX_FPS, frames, Animation.PlayMode.LOOP);
    // Impact file naming varies too: "<spell>_on_impact.atlas" or "<spell>Impact.atlas".
    TextureAtlas impactAtlas = loadSpellAtlas(spell, new String[]{
        spell + "_on_impact.atlas", spell + "Impact.atlas"});
    if (impactAtlas != null) {
      com.badlogic.gdx.utils.Array<TextureAtlas.AtlasSprite> impactFrames =
          new com.badlogic.gdx.utils.Array<>();
      for (TextureAtlas.AtlasRegion r : impactAtlas.findRegions(spell + "_on_impact")) {
        impactFrames.add(new TextureAtlas.AtlasSprite(r));
      }
      if (impactFrames.size > 0) {
        impactFrames.sort(Comparator.comparingInt(s -> s.getAtlasRegion().index));
        fx.impact = new Animation<>(SPELL_FX_FPS, impactFrames, Animation.PlayMode.NORMAL);
      }
      impactAtlas.dispose();
    }
    float cw = 1, ch = 1;
    for (TextureAtlas.AtlasRegion r : atlas.getRegions()) {
      cw = Math.max(cw, r.originalWidth);
      ch = Math.max(ch, r.originalHeight);
    }
    fx.time = 0f;
    fx.x = x;
    fx.y = y;
    fx.w = cw * SCALE;
    fx.h = ch * SCALE;
    fx.impactPhase = false;
    effects.add(fx);
    while (effects.size() > MAX_EFFECTS) {
      ActiveEffect old = effects.remove(0);
      old.atlas.dispose();
    }
  }

  /**
   * Weapon ability (plays "attack") or magic spell (plays "cast")? The original client
   * never decides locally — the server sends ATTACK_* vs CAST_* actions, mapped to atlas
   * actions by LegalPlayerAction (a=ATTACK, b=CAST, f/g=_RUN). The closest client-side
   * signal is the {@code uk} spell type in each spell definition: {@code a} = weapon
   * delivery (assassin daggers, champion melee + Whirlwind/Charge, paladin strikes, all
   * ranger bow shots, bear forms), {@code d} = magic, {@code b}/{@code c} = passive/aura
   * (hidden cost line in the original tooltip, cf. hd). Unknown → cast.
   */
  private boolean isWeaponSpell(String spell) {
    String stats = SpellDescriptions.stats(spellCharacter, spell);
    if (stats == null) {
      return false;
    }
    String[] p = stats.split("\\|");
    return p.length > 5 && "a".equals(p[5]);
  }

  /** Tries atlas file names in order, returns null when none exists. */
  private TextureAtlas loadSpellAtlas(String spell, String[] fileNames) {
    for (String file : fileNames) {
      try {
        return new TextureAtlas(
            Gdx.files.internal("spells/" + spellCharacter + "/" + spell + "/" + file));
      } catch (Exception ignored) {
        // Try the next candidate name.
      }
    }
    return null;
  }

  private void playSpellSound(String spell) {
    String[] candidates = {
        "spells/" + spellCharacter + "/" + spell + "/" + spell + ".ogg",
        "spells/" + spellCharacter + "/" + spell + "/" + spell + "-2.ogg",
        "spells/" + spellCharacter + "/cast.ogg",
        "spells/" + spellCharacter + "/cast1.ogg"};
    for (String path : candidates) {
      Sound cached = soundCache.get(path);
      if (cached != null) {
        cached.play(0.8f);
        return;
      }
      try {
        Sound s = Gdx.audio.newSound(Gdx.files.internal(path));
        soundCache.put(path, s);
        s.play(0.8f);
        return;
      } catch (Exception ignored) {
        // Try the next fallback path.
      }
    }
    Gdx.app.log("ArenaOfKings", "no sound for spell: " + spell);
  }

  /** Ticks cooldowns (keys 1-9 cast the first slots too) and advances effects. */
  private void updateSpells(float dt) {
    int[] keys = {Input.Keys.NUM_1, Input.Keys.NUM_2, Input.Keys.NUM_3, Input.Keys.NUM_4,
        Input.Keys.NUM_5, Input.Keys.NUM_6, Input.Keys.NUM_7, Input.Keys.NUM_8, Input.Keys.NUM_9};
    for (int i = 0; i < spellButtons.size() && i < keys.length && i < SPELL_KEYS; i++) {
      if (Gdx.input.isKeyJustPressed(keys[i])) {
        castSpell(i);
      }
    }
    for (int i = 0; i < spellButtons.size(); i++) {
      float cd = spellCooldowns.get(i);
      if (cd > 0) {
        cd = Math.max(0, cd - dt);
        spellCooldowns.set(i, cd);
        if (cd == 0) {
          spellButtons.get(i).setDisabled(false);
          spellVeils.get(i).setVisible(false);
        } else {
          spellCdLabels.get(i).setText(String.valueOf((int) Math.ceil(cd)));
        }
      }
    }
    for (int i = effects.size() - 1; i >= 0; i--) {
      ActiveEffect fx = effects.get(i);
      fx.time += dt;
      if (!fx.impactPhase && fx.time >= SPELL_TICK_TIME) {
        if (fx.impact != null) {
          fx.impactPhase = true;
          fx.time = 0f;
        } else {
          effects.remove(i);
          fx.atlas.dispose();
        }
      } else if (fx.impactPhase && fx.impact.isAnimationFinished(fx.time)) {
        effects.remove(i);
        fx.atlas.dispose();
      }
    }
  }

  private void drawEffects() {
    if (effects.isEmpty()) {
      return;
    }
    batch.setProjectionMatrix(cam.combined);
    batch.begin();
    for (ActiveEffect fx : effects) {
      Animation<TextureAtlas.AtlasSprite> anim = fx.impactPhase ? fx.impact : fx.tick;
      TextureAtlas.AtlasSprite sprite = anim.getKeyFrame(fx.time,
          anim.getPlayMode() == Animation.PlayMode.LOOP);
      sprite.setBounds(fx.x - fx.w / 2f, fx.y - fx.h / 2f, fx.w, fx.h);
      sprite.draw(batch);
    }
    batch.end();
  }

  private void clearEffects() {
    for (ActiveEffect fx : effects) {
      fx.atlas.dispose();
    }
    effects.clear();
  }

  /**
   * Server-authoritative movement: send input intents, render the server snapshots
   * (smoothed). The client never integrates its own position here. Falls back to
   * local mode when the connection drops.
   */
  private void updateNet(float dt) {
    if (!net.isConnected()) {
      netMode = false;
      Gdx.app.log("ArenaOfKings", "server lost, local movement fallback");
      return;
    }
    Integer gone;
    while ((gone = net.pollLeft()) != null) {
      netRender.remove(gone);
      netDir.remove(gone);
      netMoving.remove(gone);
      netSkins.remove(gone);
    }
    Net.Snapshot s = net.snapshot();
    if (s != null) {
      pushSnapshot(s);
      reconcileSelf(s);
      renderRemotes(dt);
    }
  }

  /** Buffers snapshots (local receipt time) for the interpolation delay. */
  private void pushSnapshot(Net.Snapshot s) {
    if (!netSnaps.isEmpty() && s.tick <= netSnaps.peekLast().s.tick) {
      return; // outdated or duplicate (UDP)
    }
    Snap snap = new Snap();
    snap.s = s;
    snap.at = System.nanoTime();
    netSnaps.addLast(snap);
    if (NET_DEBUG) {
      long nowMs = System.currentTimeMillis();
      if (lastSnapMs >= 0) {
        long gap = nowMs - lastSnapMs;
        if (gap > 100) {
          Gdx.app.log("ArenaOfKings", "[netdbg] snap GAP tick=" + s.tick + " gapMs=" + gap);
        }
      }
      lastSnapMs = nowMs;
    }
    long cutoff = snap.at - INTERP_KEEP_NS;
    while (netSnaps.size() > 2 && netSnaps.peekFirst().at < cutoff) {
      netSnaps.pollFirst();
    }
    while (netSnaps.size() > 10) {
      netSnaps.pollFirst();
    }
  }

  /**
   * Reconciliation: snap self to the server position, then replay unacked
   * inputs so prediction continues from the truth instead of rubber-banding.
   * Like the original (smooth offsets vs forced snaps): errors under the
   * threshold melt gently (15%/snapshot) instead of snapping every snapshot
   * (20Hz judder). The threshold stays above the structural lead (~1 frame +
   * tick phase ≈ 8-17u on localhost, proven by netdbg logs).
   */
  private static final float RECONCILE_SNAP_DIST = 40f;
  /** Melt fraction per snapshot for sub-threshold errors. */
  private static final float RECONCILE_MELT = 0.15f;

  private void reconcileSelf(Net.Snapshot s) {
    int n = Math.min(s.ids.length, Math.min(s.xs.length, s.ys.length));
    for (int i = 0; i < n; i++) {
      if (s.ids[i] != net.selfId()) {
        continue;
      }
      float sx = s.xs[i];
      float sy = s.ys[i];
      netErr = tmpV.set(sx, sy).dst(player);
      if (netErr > netMaxErr) {
        netMaxErr = netErr;
      }
      int ack = s.acks != null && i < s.acks.length ? s.acks[i] : 0;
      netHist.headMap(ack + 1).clear();
      if (netErr <= RECONCILE_SNAP_DIST) {
        // Close enough: melt a fraction of the error, keep predicting smoothly.
        player.lerp(tmpV.set(sx, sy), RECONCILE_MELT);
        if (NET_DEBUG && netErr > 1f) {
          Gdx.app.log("ArenaOfKings",
              "[netdbg] melt err=" + (int) (netErr * 10) / 10f + " ack=" + ack + " pend=" + netHist.size());
        }
        return;
      }
      if (NET_DEBUG) {
        Gdx.app.log("ArenaOfKings",
            "[netdbg] SNAP err=" + (int) (netErr * 10) / 10f + " ack=" + ack + " pend=" + netHist.size());
      }
      float px = sx;
      float py = sy;
      long nowMs = System.currentTimeMillis();
      // Replay pending inputs in order, each for its own duration.
      for (Map.Entry<Integer, Hist> e : netHist.tailMap(ack + 1).entrySet()) {
        Hist h = e.getValue();
        Map.Entry<Integer, Hist> next = netHist.higherEntry(e.getKey());
        long endMs = next == null ? nowMs : next.getValue().ms;
        float step = Math.min(0.5f, Math.max(0, (endMs - h.ms) / 1000f));
        if (step > 0) {
          float len = (float) Math.sqrt(h.x * h.x + h.y * h.y);
          float dx = len > 1f ? h.x / len : h.x;
          float dy = len > 1f ? h.y / len : h.y;
          px = clampArena(px + dx * SPEED * step);
          py = clampArena(py + dy * SPEED * step);
        }
      }
      player.set(px, py);
      return;
    }
  }

  private static float clampArena(float v) {
    return Math.max(-Net.ARENA_HALF, Math.min(Net.ARENA_HALF, v));
  }

  /**
   * Remote players render at now-100ms, interpolated between the two snapshots
   * straddling that time: constant delay, zero judder despite jitter.
   * Run/idle still comes from the drawn displacement each frame.
   */
  private void renderRemotes(float dt) {
    if (netSnaps.size() < 2) {
      renderLatest(dt);
      return;
    }
    long renderTime = System.nanoTime() - INTERP_DELAY_NS;
    Snap a = netSnaps.peekFirst();
    Snap b = a;
    for (Snap snap : netSnaps) {
      if (snap.at <= renderTime) {
        a = snap;
      } else {
        b = snap;
        break;
      }
    }
    float alpha = 0f;
    if (b.at > a.at) {
      alpha = Math.min(1, Math.max(0, (float) (renderTime - a.at) / (b.at - a.at)));
    }
    for (int i = 0; i < a.s.ids.length; i++) {
      int id = a.s.ids[i];
      if (id == net.selfId()) {
        continue;
      }
      float ax = a.s.xs[i];
      float ay = a.s.ys[i];
      float bx = ax;
      float by = ay;
      int j = indexOf(b.s, id);
      if (j >= 0) {
        bx = b.s.xs[j];
        by = b.s.ys[j];
      }
      if (a.s.skins != null && i < a.s.skins.length && a.s.skins[i] != null) {
        netSkins.put(id, a.s.skins[i]);
      }
      if (a.s.dirs != null && i < a.s.dirs.length) {
        netDir.put(id, clampDir(a.s.dirs[i]));
      }
      float nx = ax + (bx - ax) * alpha;
      float ny = ay + (by - ay) * alpha;
      Vector2 r = netRender.get(id);
      if (r == null) {
        netRender.put(id, new Vector2(nx, ny));
        if (!netDir.containsKey(id)) {
          netDir.put(id, 0);
        }
      } else {
        float ox = r.x;
        float oy = r.y;
        r.set(nx, ny);
        float dx = r.x - ox;
        float dy = r.y - oy;
        if (dx * dx + dy * dy > 0.04f) {
          netMoving.add(id);
        } else {
          netMoving.remove(id);
        }
      }
    }
    // Just joined (in b but not a yet): show immediately at latest position.
    for (int j = 0; j < b.s.ids.length; j++) {
      int id = b.s.ids[j];
      if (id == net.selfId() || netRender.containsKey(id)) {
        continue;
      }
      netRender.put(id, new Vector2(b.s.xs[j], b.s.ys[j]));
      netDir.put(id, b.s.dirs != null && j < b.s.dirs.length ? clampDir(b.s.dirs[j]) : 0);
      if (b.s.skins != null && j < b.s.skins.length && b.s.skins[j] != null) {
        netSkins.put(id, b.s.skins[j]);
      }
    }
  }

  /** Not enough history yet: render the latest snapshot directly. */
  private void renderLatest(float dt) {
    Net.Snapshot s = netSnaps.isEmpty() ? null : netSnaps.peekLast().s;
    if (s == null) {
      return;
    }
    int n = Math.min(s.ids.length, Math.min(s.xs.length, s.ys.length));
    for (int i = 0; i < n; i++) {
      int id = s.ids[i];
      if (id == net.selfId()) {
        continue;
      }
      float nx = s.xs[i];
      float ny = s.ys[i];
      if (s.skins != null && i < s.skins.length && s.skins[i] != null) {
        netSkins.put(id, s.skins[i]);
      }
      if (s.dirs != null && i < s.dirs.length) {
        netDir.put(id, clampDir(s.dirs[i]));
      }
      Vector2 r = netRender.get(id);
      if (r == null) {
        netRender.put(id, new Vector2(nx, ny));
      } else {
        float ox = r.x;
        float oy = r.y;
        r.lerp(tmpV.set(nx, ny), Math.min(1, dt * 10));
        float dx = r.x - ox;
        float dy = r.y - oy;
        if (dx * dx + dy * dy > 0.04f) {
          netMoving.add(id);
        } else {
          netMoving.remove(id);
        }
      }
    }
  }

  private static int indexOf(Net.Snapshot s, int id) {
    for (int i = 0; i < s.ids.length; i++) {
      if (s.ids[i] == id) {
        return i;
      }
    }
    return -1;
  }

  private static int clampDir(int d) {
    return Math.max(0, Math.min(7, d));
  }

  /** Sends input + facing when anything changed (500ms heartbeat otherwise). */
  private void sendNetInput(float ix, float iy, int d) {
    long now = System.currentTimeMillis();
    if (ix != lastNetIx || iy != lastNetIy || d != lastNetDir || now - lastNetSend > 500) {
      int seq = net.sendInput(ix, iy, d);
      if (seq >= 0) {
        Hist h = new Hist();
        h.x = ix;
        h.y = iy;
        h.ms = now;
        netHist.put(seq, h);
        while (netHist.size() > 300) {
          netHist.pollFirstEntry();
        }
      }
      lastNetIx = ix;
      lastNetIy = iy;
      lastNetDir = d;
      lastNetSend = now;
    }
  }

  /** Loads (and caches) a remote player's skin atlas + idle/run animations. */
  private RemoteSkin loadRemoteSkin(String skin) {
    if (skin == null || skin.isEmpty() || badRemoteSkins.contains(skin)) {
      return null;
    }
    RemoteSkin rs = remoteSkins.get(skin);
    if (rs != null) {
      return rs;
    }
    TextureAtlas a;
    try {
      a = new TextureAtlas(Gdx.files.internal(SKIN_DIR + skin + "/full.atlas"));
    } catch (Exception e) {
      Gdx.app.log("ArenaOfKings", "unreadable remote skin: " + skin);
      badRemoteSkins.add(skin);
      return null;
    }
    rs = new RemoteSkin();
    rs.atlas = a;
    for (int d = 0; d < 8; d++) {
      rs.idle[d] = buildAnimFor(a, "idle", d, IDLE_FPS, Animation.PlayMode.LOOP);
      rs.run[d] = buildAnimFor(a, "run", d, RUN_FPS, Animation.PlayMode.LOOP);
    }
    applyFallback(rs.idle);
    applyFallback(rs.run);
    for (TextureAtlas.AtlasRegion r : a.getRegions()) {
      rs.canvasW = Math.max(rs.canvasW, r.originalWidth);
      rs.canvasH = Math.max(rs.canvasH, r.originalHeight);
    }
    remoteSkins.put(skin, rs);
    return rs;
  }

  /** Remote players with their real skins (ring + id fallback when unknown). */
  private void drawNet() {
    if (!netMode) {
      return;
    }
    batch.setProjectionMatrix(cam.combined);
    batch.begin();
    for (Map.Entry<Integer, Vector2> e : netRender.entrySet()) {
      if (e.getKey() == net.selfId()) {
        continue;
      }
      RemoteSkin rs = loadRemoteSkin(netSkins.get(e.getKey()));
      Vector2 pos = e.getValue();
      if (rs == null) {
        font.setColor(Color.ORANGE);
        font.draw(batch, "P" + e.getKey(), pos.x - 20, pos.y + 60);
        continue;
      }
      int d = netDir.getOrDefault(e.getKey(), 0);
      Animation<TextureAtlas.AtlasSprite> anim =
          netMoving.contains(e.getKey()) ? rs.run[d] : rs.idle[d];
      if (anim == null) {
        continue;
      }
      TextureAtlas.AtlasSprite sprite =
          anim.getKeyFrame(stateTime, anim.getPlayMode() == Animation.PlayMode.LOOP);
      float w = rs.canvasW * SCALE;
      float h = rs.canvasH * SCALE;
      sprite.setBounds(pos.x - w / 2f, pos.y - h / 2f, w, h);
      sprite.draw(batch);
      font.setColor(Color.ORANGE);
      font.draw(batch, "P" + e.getKey(), pos.x - 20, pos.y + h / 2f + 20);
    }
    batch.end();
    shapes.setProjectionMatrix(cam.combined);
    shapes.begin(ShapeRenderer.ShapeType.Line);
    shapes.setColor(Color.ORANGE);
    for (Map.Entry<Integer, Vector2> e : netRender.entrySet()) {
      if (e.getKey() == net.selfId()) {
        continue;
      }
      if (loadRemoteSkin(netSkins.get(e.getKey())) == null) {
        shapes.circle(e.getValue().x, e.getValue().y, 30f, 24);
      }
    }
    shapes.end();
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
    if (netMode) {
      // Predicted locally above; snapshots reconcile below (Phase 2).
      updateNet(dt);
    }

    // --- Mouse -> world, character facing ---
    Vector3 m = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
    cam.unproject(m);
    mouseWorld.set(m.x, m.y);
    dir = computeDir(mouseWorld.x - player.x, mouseWorld.y - player.y);
    if (netMode) {
      sendNetInput(ix, iy, dir);
    }

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
    // Custom cursor: "down" variant while any mouse button is held.
    boolean down = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        || Gdx.input.isButtonPressed(Input.Buttons.RIGHT)
        || Gdx.input.isButtonPressed(Input.Buttons.MIDDLE);
    if (down != cursorIsDown) {
      cursorIsDown = down;
      Gdx.graphics.setCursor(down ? cursorDown : cursorNormal);
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
    updateSpells(dt);

    // --- Camera locked on the player: character always centered ---
    cam.position.set(player.x, player.y, 0);
    cam.update();

    ScreenUtils.clear(0.07f, 0.07f, 0.11f, 1f);

    drawGrid();
    drawPlayer();
    drawEffects();
    drawNet();
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
    font.draw(batch, "ZQSD / WASD / Arrows = move | Left click = attack | Right click = cast | 1-9 / spell bar = spells | Esc = quit", hx, base + 40 * cam.zoom);
    font.draw(batch, "skin=" + curSkin + " state=" + state + " dir=" + dir
        + (netMode ? " net=P" + net.selfId() + "/n=" + netRender.size()
            + "/err=" + (int) netErr + "/" + (int) netMaxErr + "/buf=" + netSnaps.size() : " local"), hx, base + 20 * cam.zoom);
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
    if (cursorNormal != null) {
      cursorNormal.dispose();
    }
    if (cursorDown != null) {
      cursorDown.dispose();
    }
    stage.dispose();
    atlas.dispose();
    if (net != null) {
      net.close();
    }
    for (RemoteSkin rs : remoteSkins.values()) {
      rs.atlas.dispose();
    }
    remoteSkins.clear();
    if (spellIcons != null) {
      spellIcons.dispose();
    }
    clearEffects();
    for (Sound s : soundCache.values()) {
      s.dispose();
    }
    soundCache.clear();
  }
}
