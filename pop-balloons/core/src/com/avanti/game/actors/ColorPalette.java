package com.avanti.game.actors;

import static com.avanti.game.Constants.ColorPaletteConstants.colorPaletteName;
import static com.avanti.game.Constants.ColorPaletteConstants.xBound;
import static com.avanti.game.Constants.ColorPaletteConstants.yBound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class ColorPalette extends Actor {

    private TextureRegion region;
    private Texture colorPalletteTexture = new Texture("palette.png");

    private Color touchedColor;

    public ColorPalette() {
        region = new TextureRegion(colorPalletteTexture);
        setBounds(xBound, yBound,
                region.getRegionWidth(), region.getRegionHeight());
        setName(colorPaletteName);

        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                region.getTexture().getTextureData().prepare();
                touchedColor = new Color(region.getTexture().getTextureData().consumePixmap().getPixel((int) x, (int) y));
                System.out.println("Touched color on the palette is : " + touchedColor);
                getParent().setUserObject(touchedColor);
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, xBound, yBound, getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public Color getTouchedColor() {
        return touchedColor;
    }
}
