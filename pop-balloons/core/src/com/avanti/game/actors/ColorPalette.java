package com.avanti.game.actors;

import com.avanti.game.Constants;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ColorPalette extends Actor {

    private TextureRegion region;
    private Texture colorPalletteTexture = new Texture("palette.png");
    private static int xBound = 672;
    private static int yBound = 352;
    private Color touchedColor;

    public ColorPalette() {
        region = new TextureRegion(colorPalletteTexture);
        setBounds(xBound, yBound,
                region.getRegionWidth(), region.getRegionHeight());
        setName(Constants.colorPaletteName);

        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("palette touched");
                region.getTexture().getTextureData().prepare();
                touchedColor = new Color(region.getTexture().getTextureData().consumePixmap().getPixel((int) x, (int) y));
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
