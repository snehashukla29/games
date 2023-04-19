package com.avanti.game.screen;

import com.avanti.game.PopBalloons;
import com.avanti.game.actors.Balloon;
import com.avanti.game.actors.PoppedBalloon;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndScreen implements Screen {
    private PopBalloons game;
    public BitmapFont font;
    private Array<Balloon> balloons;

    public EndScreen(PopBalloons game, Array<Balloon> balloons) {
        this.game = game;
        this.font = new BitmapFont();

        this.balloons = balloons;

        for (Balloon b : balloons) {
            PoppedBalloon poppedBalloon = new PoppedBalloon(b.getX(), b.getY(), b.getOwnColor());
            game.stage.addActor(poppedBalloon);
        }
        this.game = game;
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.stage.act(delta);
        game.stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.stage.dispose();
    }
}
