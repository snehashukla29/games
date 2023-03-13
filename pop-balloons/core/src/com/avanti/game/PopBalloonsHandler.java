package com.avanti.game;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class PopBalloonsHandler extends ApplicationAdapter {
    private Texture balloonImg;
    private Texture blackBalloonImg;
    private Sound popSound;
    private Music backgroundMusic;
    private static final Integer numBalloons = 10;
    private Array<Rectangle> balloons;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    @Override
    public void create() {
        balloonImg = new Texture("balloon.png");
        blackBalloonImg = new Texture("black_balloon.png");
        popSound = Gdx.audio.newSound(Gdx.files.internal("pop.mp3"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("background.mp3"));

        backgroundMusic.setLooping(true);
        backgroundMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();
        balloons = new Array<>(numBalloons);
        spawnBalloons();

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                for (Rectangle b : balloons) {
                    Vector3 tmp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                    camera.unproject(tmp);

                    if (b.contains(tmp.x, tmp.y)) {
                        System.out.println("This balloon is touched : " + b.toString());
                    }
                }
                return true;
            }
        });



    }


    private void spawnBalloons() {
        for (int i = 0; i < numBalloons; i++) {
            Rectangle balloon = new Rectangle();
            balloon.x = MathUtils.random(0, 800 - 64);
            balloon.y = MathUtils.random(0, 480 - 64);
            balloon.width = 64;
            balloon.height = 64;
            balloons.add(balloon);
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        for (Rectangle b : balloons) {
            batch.draw(balloonImg, b.x, b.y);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        balloonImg.dispose();
    }
}
