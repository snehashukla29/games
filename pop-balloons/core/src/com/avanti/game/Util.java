package com.avanti.game;

import com.avanti.game.actors.Balloon;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Util {

    public static Array<Balloon> spawnBalloons(int numBalloons) {
        Array<Balloon> temp = new Array<>(numBalloons);

        for (int i = 0; i < numBalloons; i++) {
            Balloon balloon = new Balloon(MathUtils.random(0, 672 - 128), MathUtils.random(0, 352 - 128));
            temp.add(balloon);
        }

        return temp;
    }
}
