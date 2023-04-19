package com.avanti.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class PoppedBalloon extends Actor {

    private TextureRegion region;
    private Texture balloonTexture = new Texture("explosion.png");
    private float xPos;
    private float yPos;
    private Color color;

    public PoppedBalloon(float posX, float posY, Color color) {
        init(posX, posY, color);
        region = new TextureRegion(balloonTexture);

        setBounds(xPos, yPos,
                region.getRegionWidth(), region.getRegionHeight());

        setTouchable(Touchable.enabled);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
//        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, xPos, yPos, getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    private void init(float x, float y, Color color) {
        this.xPos = x;
        this.yPos = y;
        this.color = color;
    }

}
