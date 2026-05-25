/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class axf
extends ShapeRenderer {
    public void a(float f2, float f3, float f4, float f5, float f6) {
        super.rect(f2 + f6, f3 + f6, f4 - 2.0f * f6, f5 - 2.0f * f6);
        super.rect(f2 + f6, f3, f4 - 2.0f * f6, f6);
        super.rect(f2 + f4 - f6, f3 + f6, f6, f5 - 2.0f * f6);
        super.rect(f2 + f6, f3 + f5 - f6, f4 - 2.0f * f6, f6);
        super.rect(f2, f3 + f6, f6, f5 - 2.0f * f6);
        super.arc(f2 + f6, f3 + f6, f6, 180.0f, 90.0f);
        super.arc(f2 + f4 - f6, f3 + f6, f6, 270.0f, 90.0f);
        super.arc(f2 + f4 - f6, f3 + f5 - f6, f6, 0.0f, 90.0f);
        super.arc(f2 + f6, f3 + f5 - f6, f6, 90.0f, 90.0f);
    }

    public void b(float f2, float f3, float f4, float f5, float f6) {
        Color color = new Color(0.5294118f, 0.5254902f, 0.5019608f, 1.0f);
        this.setColor(color);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.a(f2 - 2.0f, f3 - 2.0f, f4 + 4.0f, f5 + 4.0f, f6);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.a(f2, f3, f4, f5, f6);
    }

    public void c(float f2, float f3, float f4, float f5, float f6) {
        Color color = axe.o;
        this.setColor(color);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.a(f2 - 2.0f, f3 - 2.0f, f4 + 4.0f, f5 + 4.0f, f6);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.a(f2, f3, f4, f5, f6);
    }

    public void a(boolean bl2, float f2, float f3, float f4, float f5, float f6) {
        if (bl2) {
            this.set(ShapeRenderer.ShapeType.Filled);
            this.setColor(0.32941177f, 0.32941177f, 0.32941177f, 0.9f);
            this.rect(f2, f3, f4, f5);
        } else {
            this.set(ShapeRenderer.ShapeType.Filled);
            this.setColor(0.0f, 0.0f, 0.0f, 0.9f);
            this.rect(f2, f3, f4, f5);
        }
    }

    public void d(float f2, float f3, float f4, float f5, float f6) {
        this.set(ShapeRenderer.ShapeType.Filled);
        this.setColor(0.09411765f, 0.09411765f, 0.09411765f, 0.7f);
        this.rect(f2, f3, f4, f5);
    }

    public void a(ItemRarity itemRarity, int n2, float f2, float f3, float f4, float f5, float f6) {
        Color color = Color.WHITE;
        switch (itemRarity) {
            case COMMON: {
                color = Colors.get("RARITY_COMMON");
                break;
            }
            case EPIC: {
                color = Colors.get("RARITY_EPIC");
                break;
            }
            case LEGENDARY: {
                color = Colors.get("RARITY_LEGENDARY");
                break;
            }
            case RARE: {
                color = Colors.get("RARITY_RARE");
                break;
            }
            case UNCOMMON: {
                color = Colors.get("RARITY_UNCOMMON");
                break;
            }
            case UNIQUE: {
                color = Colors.get("RARITY_UNIQUE");
                break;
            }
            case ANCIENT: {
                color = Colors.get("RARITY_ANCIENT");
                break;
            }
        }
        if (n2 == 1) {
            color = Colors.get("RARITY_CORRUPTED");
        }
        this.setColor(color);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.a(f2 - 2.0f, f3 - 2.0f, f4 + 4.0f, f5 + 4.0f, f6);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.setColor(0.0f, 0.0f, 0.0f, 0.9f);
        this.a(f2, f3, f4, f5, f6);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, Color color) {
        this.setColor(color);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.a(f2 - 2.0f, f3 - 2.0f, f4 + 4.0f, f5 + 4.0f, f6);
        this.set(ShapeRenderer.ShapeType.Filled);
        this.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.a(f2, f3, f4, f5, f6);
    }
}

