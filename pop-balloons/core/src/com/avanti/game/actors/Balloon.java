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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import jdk.vm.ci.meta.Constant;

public class Balloon extends Actor {

    private TextureRegion region;
    private Texture balloonTexture = new Texture("balloon.png");
    private int xPos = 0;
    private int yPos = 0;

    public Balloon(int posX, int posY) {
        init(posX, posY);
        region = new TextureRegion(balloonTexture);
        setBounds(xPos, yPos,
                region.getRegionWidth(), region.getRegionHeight());

        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Color touchedColor = (Color) getParent().getUserObject();

                if (touchedColor != null)
                    event.getTarget().setColor(touchedColor);

                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, xPos, yPos, getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void init(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }


}
