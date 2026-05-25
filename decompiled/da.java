/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;

public class da
implements axr {
    protected Animation<Sprite> var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a;
    protected Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_a;
    private boolean var_boolean_a = true;
    private boolean var_boolean_b;
    private boolean var_boolean_c = false;
    private boolean var_boolean_d = false;
    private Color var_com_badlogic_gdx_graphics_Color_a = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private ajw var_ajw_a;
    private String var_java_lang_String_a = "";
    private Vector3 var_com_badlogic_gdx_math_Vector3_a = new Vector3();
    private int var_int_a;
    private int var_int_b;
    private int var_int_c;
    private int var_int_d;
    private float var_float_c;
    private float var_float_d = 0.0f;
    private Animation.PlayMode var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a;
    private Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_b;
    private float var_float_e = 1.0f;
    private float var_float_f = 1.0f;
    private float var_float_g = 0.0f;
    private boolean var_boolean_e = false;
    private boolean var_boolean_f;
    private boolean var_boolean_g;
    float var_float_a;
    float var_float_b;

    @Deprecated
    public da() {
    }

    public da(Animation<Sprite> animation, int n2, int n3) {
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a = animation;
        this.var_int_a = n2;
        this.var_int_b = n3;
        this.var_float_c = 0.0f;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = animation.getKeyFrame(this.var_float_c);
        this.var_int_d = animation.getKeyFrames().length;
        this.var_boolean_b = true;
    }

    public da(ajw ajw2, String string, int n2, float f2, float f3, Animation.PlayMode playMode, int n3, int n4) {
        this.var_ajw_a = ajw2;
        this.var_java_lang_String_a = string;
        this.var_int_d = n2;
        this.var_float_g = f3;
        this.var_float_d = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_int_a = n3;
        this.var_int_b = n4;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite();
        this.var_boolean_b = false;
    }

    public da(ajw ajw2, String string, int n2, int n3, float f2, float f3, Animation.PlayMode playMode, int n4, int n5) {
        this.var_ajw_a = ajw2;
        this.var_java_lang_String_a = string;
        this.var_int_c = n2;
        this.var_int_d = n3;
        this.var_float_g = f3;
        this.var_float_d = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_int_a = n4;
        this.var_int_b = n5;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite();
        this.var_boolean_b = false;
    }

    @Deprecated
    public da(AssetManager assetManager, String string, String string2, int n2, float f2, Animation.PlayMode playMode, int n3, int n4) {
        Engine.a("in " + string2);
        TextureAtlas textureAtlas = (TextureAtlas)assetManager.get(string);
        Sprite[] spriteArray = new Sprite[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            if (textureAtlas.findRegion(string2, i2) == null) {
                Engine.a("[ERROR] problem loading and finding region for " + string + " " + string2 + " index: " + i2 + " not found in spritesheet .. fix immediately");
                continue;
            }
            spriteArray[i2] = textureAtlas.createSprite(string2, i2);
            spriteArray[i2].setColor(this.var_com_badlogic_gdx_graphics_Color_a);
        }
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a = new Animation<Sprite>(f2, spriteArray);
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setPlayMode(playMode);
        this.var_float_c = 0.0f;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        this.var_int_a = n3;
        this.var_int_b = n4;
        this.var_java_lang_String_a = string2;
        this.var_boolean_b = true;
        Engine.a("loaded anim " + string2);
    }

    public void a(TextureAtlas textureAtlas) {
        Engine.a("spriteSheetAnimation.loadGFX a " + this.var_int_d + " lookupname: " + this.var_java_lang_String_a);
        Sprite[] spriteArray = new Sprite[this.var_int_d - this.var_int_c];
        int n2 = 0;
        int n3 = this.var_int_c;
        while (n2 < spriteArray.length) {
            if (textureAtlas.findRegion(this.var_java_lang_String_a, n3) == null) {
                Engine.a("[ERROR] problem loading and finding region for " + this.var_ajw_a.toString() + " " + this.var_java_lang_String_a + " index: " + n3 + " not found in spritesheet .. fix immediately");
            } else {
                spriteArray[n2] = textureAtlas.createSprite(this.var_java_lang_String_a, n3);
                spriteArray[n2].scale(this.var_float_g);
                spriteArray[n2].setColor(this.var_com_badlogic_gdx_graphics_Color_a);
            }
            ++n2;
            ++n3;
        }
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a = new Animation<Sprite>(this.var_float_d, spriteArray);
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setPlayMode(this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        this.var_boolean_b = true;
    }

    public void a(axm axm2, boolean bl2, boolean bl3) {
        Engine.a("spriteSheetAnimation.loadGFX b " + this.var_int_d + " yay " + this.var_java_lang_String_a);
        Sprite[] spriteArray = new Sprite[this.var_int_d - this.var_int_c];
        int n2 = 0;
        int n3 = this.var_int_c;
        while (n2 < spriteArray.length) {
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(this.var_ajw_a);
            if (textureAtlas != null) {
                if (textureAtlas.findRegion(this.var_java_lang_String_a, n3) == null) {
                    Engine.a("[ERROR] problem loading and finding region for " + this.var_ajw_a.toString() + " " + this.var_java_lang_String_a + " index: " + n3 + " not found in spritesheet .. fix immediately");
                } else {
                    spriteArray[n2] = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(this.var_ajw_a).createSprite(this.var_java_lang_String_a, n3);
                    spriteArray[n2].scale(this.var_float_g);
                    spriteArray[n2].setColor(this.var_com_badlogic_gdx_graphics_Color_a);
                }
            }
            ++n2;
            ++n3;
        }
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a = new Animation<Sprite>(this.var_float_d, spriteArray);
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setPlayMode(this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        this.var_float_c = 0.0f;
        if (bl2) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b = bl3 ? axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("nameplate_health_bar") : axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("nameplate_rage_bar");
        }
        this.var_boolean_b = true;
        Engine.a("spriteSheetAnimation.loadGFX b out");
    }

    public void a(axm axm2, boolean bl2, boolean bl3, boolean bl4) {
        Engine.a("spriteSheetAnimation.loadGFX b " + this.var_int_d + " yay " + this.var_java_lang_String_a);
        Sprite[] spriteArray = new Sprite[this.var_int_d - this.var_int_c];
        int n2 = 0;
        int n3 = this.var_int_c;
        while (n2 < spriteArray.length) {
            if (axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(this.var_ajw_a).findRegion(this.var_java_lang_String_a, n3) == null) {
                Engine.a("[ERROR] problem loading and finding region for " + this.var_ajw_a.toString() + " " + this.var_java_lang_String_a + " index: " + n3 + " not found in spritesheet .. fix immediately");
            } else {
                spriteArray[n2] = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(this.var_ajw_a).createSprite(this.var_java_lang_String_a, n3);
                spriteArray[n2].scale(this.var_float_g);
                spriteArray[n2].setColor(this.var_com_badlogic_gdx_graphics_Color_a);
                if (bl4) {
                    spriteArray[n2].setFlip(true, false);
                }
            }
            ++n2;
            ++n3;
        }
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a = new Animation<Sprite>(this.var_float_d, spriteArray);
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setPlayMode(this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        this.var_float_c = 0.0f;
        if (bl2) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b = bl3 ? axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("nameplate_health_bar") : axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("nameplate_rage_bar");
        }
        this.var_boolean_b = true;
        Engine.a("spriteSheetAnimation.loadGFX b out");
    }

    public void void_a() {
        this.var_boolean_d = false;
        this.var_float_c = 0.0f;
        if (this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_boolean_d = false;
        this.var_float_c += f2;
        if (this.var_boolean_b) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
            if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_com_badlogic_gdx_math_Vector3_a.x + (float)this.var_int_a, this.var_com_badlogic_gdx_math_Vector3_a.y + (float)this.var_int_b);
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setRotation(this.var_com_badlogic_gdx_math_Vector3_a.z);
                if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_a.x, engine.var_com_badlogic_gdx_math_Vector3_a.y)) {
                    this.var_boolean_f = true;
                    this.void_b();
                    if (Gdx.input.isButtonPressed(0)) {
                        this.var_boolean_g = true;
                        this.void_c();
                    } else {
                        this.var_boolean_g = false;
                    }
                } else {
                    this.var_boolean_f = false;
                    this.var_boolean_g = false;
                }
            }
        }
    }

    public void void_b() {
    }

    public void void_c() {
    }

    public void a(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_float_a = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            this.var_float_b = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setColor(this.var_com_badlogic_gdx_graphics_Color_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_float_a, this.var_float_b);
        }
    }

    public void a(float f2, float f3, float f4, azi azi2, float f5) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_float_a = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            this.var_float_b = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setColor(this.var_com_badlogic_gdx_graphics_Color_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f5);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(1.0f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_float_a, this.var_float_b);
        }
    }

    public void b(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3 + (float)this.var_int_a + -122.0f, f4 + (float)this.var_int_b + -80.0f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void c(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void d(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3 + (float)this.var_int_a + -122.0f, f4 + (float)this.var_int_b + -80.0f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void e(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3 + (float)this.var_int_a + -122.0f, f4 + (float)this.var_int_b + -80.0f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_e);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void f(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3 + (float)this.var_int_a, f4 + (float)this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void g(float f2, float f3, float f4, azi azi2) {
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3 + (float)this.var_int_a, f4 + (float)this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_e);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
    }

    public void h(float f2, float f3, float f4, azi azi2) {
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_b != null && this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(f3 - 36.0f, f4 + 90.0f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setAlpha(this.var_float_f);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.draw(azi2);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        if (!this.var_boolean_c) {
            this.a(f2, engine);
            this.var_boolean_c = true;
        }
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2 + this.var_int_a, n3 + this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setColor(this.var_com_badlogic_gdx_graphics_Color_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        }
    }

    public void c(float f2, Engine engine) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_f);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(1.0f);
        this.var_boolean_d = true;
    }

    public void d(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(this.var_float_e);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(1.0f);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_com_badlogic_gdx_math_Vector3_a.x + (float)this.var_int_a, this.var_com_badlogic_gdx_math_Vector3_a.y + (float)this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setColor(this.var_com_badlogic_gdx_graphics_Color_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        }
    }

    public void a(float f2, azi azi2) {
        float f3 = this.var_float_c;
        this.var_float_c = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_com_badlogic_gdx_math_Vector3_a.x + (float)this.var_int_a, this.var_com_badlogic_gdx_math_Vector3_a.y + (float)this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setRotation(this.var_com_badlogic_gdx_math_Vector3_a.z);
        }
        if (this.var_boolean_b && this.var_boolean_a && this.var_com_badlogic_gdx_graphics_g2d_Sprite_a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_com_badlogic_gdx_math_Vector3_a.x + (float)this.var_int_a, this.var_com_badlogic_gdx_math_Vector3_a.y + (float)this.var_int_b);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
        }
        this.var_float_c = f3;
    }

    public void void_d() {
        this.var_float_c = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getFrameDuration();
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrame(this.var_float_c);
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    public boolean boolean_b() {
        return this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.isAnimationFinished(this.var_float_c);
    }

    public void a(Color color) {
        this.var_com_badlogic_gdx_graphics_Color_a = color;
    }

    public Color com_badlogic_gdx_graphics_Color_a() {
        return this.var_com_badlogic_gdx_graphics_Color_a;
    }

    public void a(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public Animation<Sprite> a() {
        return this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a;
    }

    public float float_a() {
        return this.var_float_c;
    }

    public void a(Vector3 vector3) {
        this.var_com_badlogic_gdx_math_Vector3_a = vector3;
    }

    public void a(float f2) {
        this.var_float_c = f2;
    }

    public void b(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void b(float f2) {
        this.var_float_e = f2;
    }

    public void c(float f2) {
        this.var_float_f = f2;
    }

    public void d(float f2) {
        this.var_float_g = f2;
    }

    public void e(float f2) {
        this.var_float_d = f2;
        if (this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setFrameDuration(f2);
        }
    }

    public int int_a() {
        return this.var_int_a;
    }

    public int int_b() {
        return this.var_int_b;
    }

    public Vector3 com_badlogic_gdx_math_Vector3_a() {
        return this.var_com_badlogic_gdx_math_Vector3_a;
    }

    public void a(Animation.PlayMode playMode) {
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.setPlayMode(playMode);
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_a() {
        return this.var_com_badlogic_gdx_graphics_g2d_Sprite_a;
    }

    public int int_c() {
        return this.var_int_d;
    }

    public Animation.PlayMode com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a() {
        return this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a;
    }

    public ajw ajw_a() {
        return this.var_ajw_a;
    }

    public float float_b() {
        return this.var_float_d;
    }

    public float float_c() {
        return this.var_float_f;
    }

    public float float_d() {
        return this.var_com_badlogic_gdx_math_Vector3_a.x;
    }

    public float e() {
        return this.var_com_badlogic_gdx_math_Vector3_a.y;
    }

    public void a(float f2, float f3) {
        this.var_com_badlogic_gdx_math_Vector3_a.x = f2;
        this.var_com_badlogic_gdx_math_Vector3_a.y = f3;
    }

    public boolean boolean_c() {
        return this.var_boolean_d;
    }

    public void c(boolean bl2) {
        this.var_boolean_d = bl2;
    }

    public String toString() {
        return "SpriteSheetAnimation [visible=" + this.var_boolean_a + ", loaded=" + this.var_boolean_b + ", screenDependency=" + (Object)((Object)this.var_ajw_a) + ", lookup_name=" + this.var_java_lang_String_a + ", x=" + this.var_com_badlogic_gdx_math_Vector3_a.x + ", y=" + this.var_com_badlogic_gdx_math_Vector3_a.y + ", xOffset=" + this.var_int_a + ", yOffset=" + this.var_int_b + ", numFrames=" + this.var_int_d + ", stateTime=" + this.var_float_c + ", timeBetweenFrames=" + this.var_float_d + ", playMode=" + (Object)((Object)this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a) + "]";
    }
}

