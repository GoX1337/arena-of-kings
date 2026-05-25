/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class Skin
implements Disposable {
    ObjectMap<Class, ObjectMap<String, Object>> resources = new ObjectMap();
    TextureAtlas atlas;
    float scale = 1.0f;
    private final ObjectMap<String, Class> jsonClassTags = new ObjectMap(defaultTagClasses.length);
    private static final Class[] defaultTagClasses = new Class[]{BitmapFont.class, Color.class, TintedDrawable.class, NinePatchDrawable.class, SpriteDrawable.class, TextureRegionDrawable.class, TiledDrawable.class, Button.ButtonStyle.class, CheckBox.CheckBoxStyle.class, ImageButton.ImageButtonStyle.class, ImageTextButton.ImageTextButtonStyle.class, Label.LabelStyle.class, List.ListStyle.class, ProgressBar.ProgressBarStyle.class, ScrollPane.ScrollPaneStyle.class, SelectBox.SelectBoxStyle.class, Slider.SliderStyle.class, SplitPane.SplitPaneStyle.class, TextButton.TextButtonStyle.class, TextField.TextFieldStyle.class, TextTooltip.TextTooltipStyle.class, Touchpad.TouchpadStyle.class, Tree.TreeStyle.class, Window.WindowStyle.class};

    public Skin() {
        for (Class clazz : defaultTagClasses) {
            this.jsonClassTags.put(clazz.getSimpleName(), clazz);
        }
    }

    public Skin(FileHandle fileHandle) {
        for (Class clazz : defaultTagClasses) {
            this.jsonClassTags.put(clazz.getSimpleName(), clazz);
        }
        FileHandle fileHandle2 = fileHandle.sibling(fileHandle.nameWithoutExtension() + ".atlas");
        if (fileHandle2.exists()) {
            this.atlas = new TextureAtlas(fileHandle2);
            this.addRegions(this.atlas);
        }
        this.load(fileHandle);
    }

    public Skin(FileHandle fileHandle, TextureAtlas textureAtlas) {
        for (Class clazz : defaultTagClasses) {
            this.jsonClassTags.put(clazz.getSimpleName(), clazz);
        }
        this.atlas = textureAtlas;
        this.addRegions(textureAtlas);
        this.load(fileHandle);
    }

    public Skin(TextureAtlas textureAtlas) {
        for (Class clazz : defaultTagClasses) {
            this.jsonClassTags.put(clazz.getSimpleName(), clazz);
        }
        this.atlas = textureAtlas;
        this.addRegions(textureAtlas);
    }

    public void load(FileHandle fileHandle) {
        try {
            this.getJsonLoader(fileHandle).fromJson(Skin.class, fileHandle);
        }
        catch (SerializationException serializationException) {
            throw new SerializationException("Error reading file: " + fileHandle, serializationException);
        }
    }

    public void addRegions(TextureAtlas textureAtlas) {
        Array<TextureAtlas.AtlasRegion> array = textureAtlas.getRegions();
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            TextureAtlas.AtlasRegion atlasRegion = array.get(i2);
            String string = atlasRegion.name;
            if (atlasRegion.index != -1) {
                string = string + "_" + atlasRegion.index;
            }
            this.add(string, atlasRegion, TextureRegion.class);
        }
    }

    public void add(String string, Object object) {
        this.add(string, object, object.getClass());
    }

    public void add(String string, Object object, Class clazz) {
        if (string == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        if (object == null) {
            throw new IllegalArgumentException("resource cannot be null.");
        }
        ObjectMap<String, Object> objectMap = this.resources.get(clazz);
        if (objectMap == null) {
            objectMap = new ObjectMap(clazz == TextureRegion.class || clazz == Drawable.class || clazz == Sprite.class ? 256 : 64);
            this.resources.put(clazz, objectMap);
        }
        objectMap.put(string, object);
    }

    public void remove(String string, Class clazz) {
        if (string == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        ObjectMap<String, Object> objectMap = this.resources.get(clazz);
        objectMap.remove(string);
    }

    public <T> T get(Class<T> clazz) {
        return this.get("default", clazz);
    }

    public <T> T get(String string, Class<T> clazz) {
        if (string == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (clazz == Drawable.class) {
            return (T)this.getDrawable(string);
        }
        if (clazz == TextureRegion.class) {
            return (T)this.getRegion(string);
        }
        if (clazz == NinePatch.class) {
            return (T)this.getPatch(string);
        }
        if (clazz == Sprite.class) {
            return (T)this.getSprite(string);
        }
        ObjectMap<String, Object> objectMap = this.resources.get(clazz);
        if (objectMap == null) {
            throw new GdxRuntimeException("No " + clazz.getName() + " registered with name: " + string);
        }
        Object object = objectMap.get(string);
        if (object == null) {
            throw new GdxRuntimeException("No " + clazz.getName() + " registered with name: " + string);
        }
        return (T)object;
    }

    @Null
    public <T> T optional(String string, Class<T> clazz) {
        if (string == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        ObjectMap<String, Object> objectMap = this.resources.get(clazz);
        if (objectMap == null) {
            return null;
        }
        return (T)objectMap.get(string);
    }

    public boolean has(String string, Class clazz) {
        ObjectMap<String, Object> objectMap = this.resources.get(clazz);
        if (objectMap == null) {
            return false;
        }
        return objectMap.containsKey(string);
    }

    @Null
    public <T> ObjectMap<String, T> getAll(Class<T> clazz) {
        return this.resources.get(clazz);
    }

    public Color getColor(String string) {
        return this.get(string, Color.class);
    }

    public BitmapFont getFont(String string) {
        return this.get(string, BitmapFont.class);
    }

    public TextureRegion getRegion(String string) {
        TextureRegion textureRegion = this.optional(string, TextureRegion.class);
        if (textureRegion != null) {
            return textureRegion;
        }
        Texture texture = this.optional(string, Texture.class);
        if (texture == null) {
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + string);
        }
        textureRegion = new TextureRegion(texture);
        this.add(string, textureRegion, TextureRegion.class);
        return textureRegion;
    }

    @Null
    public Array<TextureRegion> getRegions(String string) {
        Array<TextureRegion> array = null;
        int n2 = 0;
        TextureRegion textureRegion = this.optional(string + "_" + n2++, TextureRegion.class);
        if (textureRegion != null) {
            array = new Array<TextureRegion>();
            while (textureRegion != null) {
                array.add(textureRegion);
                textureRegion = this.optional(string + "_" + n2++, TextureRegion.class);
            }
        }
        return array;
    }

    public TiledDrawable getTiledDrawable(String string) {
        TiledDrawable tiledDrawable = this.optional(string, TiledDrawable.class);
        if (tiledDrawable != null) {
            return tiledDrawable;
        }
        tiledDrawable = new TiledDrawable(this.getRegion(string));
        tiledDrawable.setName(string);
        if (this.scale != 1.0f) {
            this.scale(tiledDrawable);
            tiledDrawable.setScale(this.scale);
        }
        this.add(string, tiledDrawable, TiledDrawable.class);
        return tiledDrawable;
    }

    public NinePatch getPatch(String string) {
        NinePatch ninePatch = this.optional(string, NinePatch.class);
        if (ninePatch != null) {
            return ninePatch;
        }
        try {
            int[] nArray;
            TextureRegion textureRegion = this.getRegion(string);
            if (textureRegion instanceof TextureAtlas.AtlasRegion && (nArray = ((TextureAtlas.AtlasRegion)textureRegion).findValue("split")) != null) {
                ninePatch = new NinePatch(textureRegion, nArray[0], nArray[1], nArray[2], nArray[3]);
                int[] nArray2 = ((TextureAtlas.AtlasRegion)textureRegion).findValue("pad");
                if (nArray2 != null) {
                    ninePatch.setPadding(nArray2[0], nArray2[1], nArray2[2], nArray2[3]);
                }
            }
            if (ninePatch == null) {
                ninePatch = new NinePatch(textureRegion);
            }
            if (this.scale != 1.0f) {
                ninePatch.scale(this.scale, this.scale);
            }
            this.add(string, ninePatch, NinePatch.class);
            return ninePatch;
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + string);
        }
    }

    public Sprite getSprite(String string) {
        Sprite sprite = this.optional(string, Sprite.class);
        if (sprite != null) {
            return sprite;
        }
        try {
            TextureRegion textureRegion = this.getRegion(string);
            if (textureRegion instanceof TextureAtlas.AtlasRegion) {
                TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion)textureRegion;
                if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
                    sprite = new TextureAtlas.AtlasSprite(atlasRegion);
                }
            }
            if (sprite == null) {
                sprite = new Sprite(textureRegion);
            }
            if (this.scale != 1.0f) {
                sprite.setSize(sprite.getWidth() * this.scale, sprite.getHeight() * this.scale);
            }
            this.add(string, sprite, Sprite.class);
            return sprite;
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + string);
        }
    }

    public Drawable getDrawable(String string) {
        TextureRegion textureRegion;
        Object object;
        Drawable drawable = this.optional(string, Drawable.class);
        if (drawable != null) {
            return drawable;
        }
        try {
            object = this.getRegion(string);
            if (object instanceof TextureAtlas.AtlasRegion) {
                textureRegion = (TextureAtlas.AtlasRegion)object;
                if (textureRegion.findValue("split") != null) {
                    drawable = new NinePatchDrawable(this.getPatch(string));
                } else if (textureRegion.rotate || textureRegion.packedWidth != textureRegion.originalWidth || textureRegion.packedHeight != textureRegion.originalHeight) {
                    drawable = new SpriteDrawable(this.getSprite(string));
                }
            }
            if (drawable == null) {
                drawable = new TextureRegionDrawable((TextureRegion)object);
                if (this.scale != 1.0f) {
                    this.scale(drawable);
                }
            }
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            // empty catch block
        }
        if (drawable == null) {
            object = this.optional(string, NinePatch.class);
            if (object != null) {
                drawable = new NinePatchDrawable((NinePatch)object);
            } else {
                textureRegion = this.optional(string, Sprite.class);
                if (textureRegion != null) {
                    drawable = new SpriteDrawable((Sprite)textureRegion);
                } else {
                    throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + string);
                }
            }
        }
        if (drawable instanceof BaseDrawable) {
            ((BaseDrawable)drawable).setName(string);
        }
        this.add(string, drawable, Drawable.class);
        return drawable;
    }

    @Null
    public String find(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        ObjectMap<String, Object> objectMap = this.resources.get(object.getClass());
        if (objectMap == null) {
            return null;
        }
        return objectMap.findKey(object, true);
    }

    public Drawable newDrawable(String string) {
        return this.newDrawable(this.getDrawable(string));
    }

    public Drawable newDrawable(String string, float f2, float f3, float f4, float f5) {
        return this.newDrawable(this.getDrawable(string), new Color(f2, f3, f4, f5));
    }

    public Drawable newDrawable(String string, Color color) {
        return this.newDrawable(this.getDrawable(string), color);
    }

    public Drawable newDrawable(Drawable drawable) {
        if (drawable instanceof TiledDrawable) {
            return new TiledDrawable((TiledDrawable)drawable);
        }
        if (drawable instanceof TextureRegionDrawable) {
            return new TextureRegionDrawable((TextureRegionDrawable)drawable);
        }
        if (drawable instanceof NinePatchDrawable) {
            return new NinePatchDrawable((NinePatchDrawable)drawable);
        }
        if (drawable instanceof SpriteDrawable) {
            return new SpriteDrawable((SpriteDrawable)drawable);
        }
        throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + drawable.getClass());
    }

    public Drawable newDrawable(Drawable drawable, float f2, float f3, float f4, float f5) {
        return this.newDrawable(drawable, new Color(f2, f3, f4, f5));
    }

    public Drawable newDrawable(Drawable drawable, Color color) {
        Drawable drawable2;
        if (drawable instanceof TextureRegionDrawable) {
            drawable2 = ((TextureRegionDrawable)drawable).tint(color);
        } else if (drawable instanceof NinePatchDrawable) {
            drawable2 = ((NinePatchDrawable)drawable).tint(color);
        } else if (drawable instanceof SpriteDrawable) {
            drawable2 = ((SpriteDrawable)drawable).tint(color);
        } else {
            throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + drawable.getClass());
        }
        if (drawable2 instanceof BaseDrawable) {
            BaseDrawable baseDrawable = (BaseDrawable)drawable2;
            if (drawable instanceof BaseDrawable) {
                baseDrawable.setName(((BaseDrawable)drawable).getName() + " (" + color + ")");
            } else {
                baseDrawable.setName(" (" + color + ")");
            }
        }
        return drawable2;
    }

    public void scale(Drawable drawable) {
        drawable.setLeftWidth(drawable.getLeftWidth() * this.scale);
        drawable.setRightWidth(drawable.getRightWidth() * this.scale);
        drawable.setBottomHeight(drawable.getBottomHeight() * this.scale);
        drawable.setTopHeight(drawable.getTopHeight() * this.scale);
        drawable.setMinWidth(drawable.getMinWidth() * this.scale);
        drawable.setMinHeight(drawable.getMinHeight() * this.scale);
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public void setEnabled(Actor actor, boolean bl2) {
        Object object;
        Method method = Skin.findMethod(actor.getClass(), "getStyle");
        if (method == null) {
            return;
        }
        try {
            object = method.invoke(actor, new Object[0]);
        }
        catch (Exception exception) {
            return;
        }
        String string = this.find(object);
        if (string == null) {
            return;
        }
        string = string.replace("-disabled", "") + (bl2 ? "" : "-disabled");
        object = this.get(string, object.getClass());
        method = Skin.findMethod(actor.getClass(), "setStyle");
        if (method == null) {
            return;
        }
        try {
            method.invoke(actor, object);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Null
    public TextureAtlas getAtlas() {
        return this.atlas;
    }

    @Override
    public void dispose() {
        if (this.atlas != null) {
            this.atlas.dispose();
        }
        for (ObjectMap objectMap : this.resources.values()) {
            for (Object e2 : objectMap.values()) {
                if (!(e2 instanceof Disposable)) continue;
                ((Disposable)e2).dispose();
            }
        }
    }

    protected Json getJsonLoader(final FileHandle fileHandle) {
        final Skin skin = this;
        Json json = new Json(){
            private static final String parentFieldName = "parent";

            @Override
            public <T> T readValue(Class<T> clazz, Class clazz2, JsonValue jsonValue) {
                if (jsonValue != null && jsonValue.isString() && !ClassReflection.isAssignableFrom(CharSequence.class, clazz)) {
                    return Skin.this.get(jsonValue.asString(), clazz);
                }
                return super.readValue(clazz, clazz2, jsonValue);
            }

            @Override
            public boolean ignoreUnknownField(Class clazz, String string) {
                return string.equals(parentFieldName);
            }

            @Override
            public void readFields(Object object, JsonValue jsonValue) {
                if (jsonValue.has(parentFieldName)) {
                    String string = this.readValue(parentFieldName, String.class, jsonValue);
                    Class<?> clazz = object.getClass();
                    while (true) {
                        try {
                            this.copyFields(Skin.this.get(string, clazz), object);
                        }
                        catch (GdxRuntimeException gdxRuntimeException) {
                            if ((clazz = clazz.getSuperclass()) != Object.class) continue;
                            SerializationException serializationException = new SerializationException("Unable to find parent resource with name: " + string);
                            serializationException.addTrace(jsonValue.child.trace());
                            throw serializationException;
                        }
                        break;
                    }
                }
                super.readFields(object, jsonValue);
            }
        };
        json.setTypeName(null);
        json.setUsePrototypes(false);
        json.setSerializer(Skin.class, new Json.ReadOnlySerializer<Skin>(){

            @Override
            public Skin read(Json json, JsonValue jsonValue, Class clazz) {
                JsonValue jsonValue2 = jsonValue.child;
                while (jsonValue2 != null) {
                    try {
                        Class clazz2 = json.getClass(jsonValue2.name());
                        if (clazz2 == null) {
                            clazz2 = ClassReflection.forName(jsonValue2.name());
                        }
                        this.readNamedObjects(json, clazz2, jsonValue2);
                    }
                    catch (ReflectionException reflectionException) {
                        throw new SerializationException(reflectionException);
                    }
                    jsonValue2 = jsonValue2.next;
                }
                return skin;
            }

            private void readNamedObjects(Json json, Class clazz, JsonValue jsonValue) {
                Class clazz2 = clazz == TintedDrawable.class ? Drawable.class : clazz;
                JsonValue jsonValue2 = jsonValue.child;
                while (jsonValue2 != null) {
                    Object t2 = json.readValue(clazz, jsonValue2);
                    if (t2 != null) {
                        try {
                            Skin.this.add(jsonValue2.name, t2, clazz2);
                            if (clazz2 != Drawable.class && ClassReflection.isAssignableFrom(Drawable.class, clazz2)) {
                                Skin.this.add(jsonValue2.name, t2, Drawable.class);
                            }
                        }
                        catch (Exception exception) {
                            throw new SerializationException("Error reading " + ClassReflection.getSimpleName(clazz) + ": " + jsonValue2.name, exception);
                        }
                    }
                    jsonValue2 = jsonValue2.next;
                }
            }
        });
        json.setSerializer(BitmapFont.class, new Json.ReadOnlySerializer<BitmapFont>(){

            @Override
            public BitmapFont read(Json json, JsonValue jsonValue, Class clazz) {
                String string = json.readValue("file", String.class, jsonValue);
                int n2 = json.readValue("scaledSize", Integer.TYPE, Integer.valueOf(-1), jsonValue);
                Boolean bl2 = json.readValue("flip", Boolean.class, Boolean.valueOf(false), jsonValue);
                Boolean bl3 = json.readValue("markupEnabled", Boolean.class, Boolean.valueOf(false), jsonValue);
                FileHandle fileHandle3 = fileHandle.parent().child(string);
                if (!fileHandle3.exists()) {
                    fileHandle3 = Gdx.files.internal(string);
                }
                if (!fileHandle3.exists()) {
                    throw new SerializationException("Font file not found: " + fileHandle3);
                }
                String string2 = fileHandle3.nameWithoutExtension();
                try {
                    FileHandle fileHandle2;
                    TextureRegion textureRegion;
                    Array<TextureRegion> array = skin.getRegions(string2);
                    BitmapFont bitmapFont = array != null ? new BitmapFont(new BitmapFont.BitmapFontData(fileHandle3, bl2), array, true) : ((textureRegion = skin.optional(string2, TextureRegion.class)) != null ? new BitmapFont(fileHandle3, textureRegion, (boolean)bl2) : ((fileHandle2 = fileHandle3.parent().child(string2 + ".png")).exists() ? new BitmapFont(fileHandle3, fileHandle2, (boolean)bl2) : new BitmapFont(fileHandle3, bl2)));
                    bitmapFont.getData().markupEnabled = bl3;
                    if (n2 != -1) {
                        bitmapFont.getData().setScale((float)n2 / bitmapFont.getCapHeight());
                    }
                    return bitmapFont;
                }
                catch (RuntimeException runtimeException) {
                    throw new SerializationException("Error loading bitmap font: " + fileHandle3, runtimeException);
                }
            }
        });
        json.setSerializer(Color.class, new Json.ReadOnlySerializer<Color>(){

            @Override
            public Color read(Json json, JsonValue jsonValue, Class clazz) {
                if (jsonValue.isString()) {
                    return Skin.this.get(jsonValue.asString(), Color.class);
                }
                String string = json.readValue("hex", String.class, (String)null, jsonValue);
                if (string != null) {
                    return Color.valueOf(string);
                }
                float f2 = json.readValue("r", Float.TYPE, Float.valueOf(0.0f), jsonValue).floatValue();
                float f3 = json.readValue("g", Float.TYPE, Float.valueOf(0.0f), jsonValue).floatValue();
                float f4 = json.readValue("b", Float.TYPE, Float.valueOf(0.0f), jsonValue).floatValue();
                float f5 = json.readValue("a", Float.TYPE, Float.valueOf(1.0f), jsonValue).floatValue();
                return new Color(f2, f3, f4, f5);
            }
        });
        json.setSerializer(TintedDrawable.class, new Json.ReadOnlySerializer(){

            @Override
            public Object read(Json json, JsonValue jsonValue, Class clazz) {
                String string = json.readValue("name", String.class, jsonValue);
                Color color = json.readValue("color", Color.class, jsonValue);
                if (color == null) {
                    throw new SerializationException("TintedDrawable missing color: " + jsonValue);
                }
                Drawable drawable = Skin.this.newDrawable(string, color);
                if (drawable instanceof BaseDrawable) {
                    BaseDrawable baseDrawable = (BaseDrawable)drawable;
                    baseDrawable.setName(jsonValue.name + " (" + string + ", " + color + ")");
                }
                return drawable;
            }
        });
        for (ObjectMap.Entry entry : this.jsonClassTags) {
            json.addClassTag((String)entry.key, (Class)entry.value);
        }
        return json;
    }

    public ObjectMap<String, Class> getJsonClassTags() {
        return this.jsonClassTags;
    }

    @Null
    private static Method findMethod(Class clazz, String string) {
        for (Method method : ClassReflection.getMethods(clazz)) {
            if (!method.getName().equals(string)) continue;
            return method;
        }
        return null;
    }

    public static class TintedDrawable {
        public String name;
        public Color color;
    }
}

