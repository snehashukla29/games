package com.avanti.game.screen;

import com.avanti.game.PopBalloons;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainScreen implements Screen {
    private PopBalloons game;
    public BitmapFont font;

    public MainScreen(PopBalloons game) {
        this.game = game;
        this.font = new BitmapFont();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

        Texture bgImage = new Texture("bgImg.png");

        game.batch.begin();
        game.batch.draw(bgImage, 0, 0);
        game.font.setColor(Color.BLUE);
        game.font.draw(game.batch, "Welcome to Pop Balloons. Tap anywhere to begin ", 250, 250);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }

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

    }
}
