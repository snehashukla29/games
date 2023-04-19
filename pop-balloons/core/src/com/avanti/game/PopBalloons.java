package com.avanti.game;

import com.avanti.game.screen.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PopBalloons extends Game {
    public Stage stage;
    public BitmapFont font;
    public SpriteBatch batch;

    public void create() {
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
        this.setScreen(new MainScreen(this));

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    public void resize(int width, int height) {
        // See below for what true means.
        stage.getViewport().update(width, height, true);
    }

    public void render() {
        super.render();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    public void dispose() {
        stage.dispose();
    }

}
