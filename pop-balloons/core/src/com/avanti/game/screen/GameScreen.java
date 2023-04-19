package com.avanti.game.screen;

import com.avanti.game.PopBalloons;
import com.avanti.game.Util;
import com.avanti.game.actors.Balloon;
import com.avanti.game.actors.ColorPalette;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    private final PopBalloons game;
    private static int numBalloons = 6;
    private Array<Balloon> balloons;
    private ColorPalette colorPalette;

    public GameScreen(final PopBalloons game) {
        colorPalette = new ColorPalette();
        game.stage.addActor(colorPalette);

        balloons = new Array<>(Util.spawnBalloonsNew(numBalloons));

        for (Balloon b : balloons) {
            game.stage.addActor(b);
        }
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.stage.act(delta);
        game.stage.draw();

        Boolean enableNextScreen = checkBalloonStatus();

        if(enableNextScreen) {
            dispose();
            game.setScreen(new EndScreen(game, balloons));

        }
    }

    private Boolean checkBalloonStatus() {
        for(Balloon b : balloons) {
            if(b.isTouchable())
                return false;
        }

        return true;
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
        game.stage.clear();
//        game.stage.dispose();

    }
}
