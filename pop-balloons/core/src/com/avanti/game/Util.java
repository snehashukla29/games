package com.avanti.game;

import static com.avanti.game.Constants.BalloonConstants.dim;
import static com.avanti.game.Constants.BalloonConstants.distX;
import static com.avanti.game.Constants.BalloonConstants.distY;
import static com.avanti.game.Constants.BalloonConstants.limitPerLine;
import static com.avanti.game.Constants.ColorPaletteConstants.xBound;
import static com.avanti.game.Constants.ColorPaletteConstants.yBound;
import static com.avanti.game.Constants.StageConstants.height;
import static com.avanti.game.Constants.StageConstants.width;

import com.avanti.game.actors.Balloon;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Random;

public class Util {

    @Deprecated
    public static Array<Balloon> spawnBalloons(int numBalloons) {
        Random r = new Random();
        Array<Balloon> temp = new Array<>(numBalloons);

        ArrayList<Integer> randomYs = new ArrayList<>(numBalloons);

        for (int i = 0; i < numBalloons; i++) {
            randomYs.add(MathUtils.random(0, yBound - dim));
        }

        for (int i = 0; i < numBalloons; i++) {
            Balloon balloon = new Balloon(MathUtils.random(0, xBound - dim), randomYs.get(i));
            temp.add(balloon);
        }

        return temp;
    }

    public static Array<Balloon> spawnBalloonsNew(int numBalloons) {
        switch (numBalloons) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 15:
            case 20:
            case 25:
                return createBalloons(numBalloons, limitPerLine);
            default:
                System.out.println("OInvalid value for numBalloons!");
                break;
        }

        return null;
    }

    private static Array<Balloon> createBalloons(int numBalloons, int limitPerLine) {
        Array<Balloon> temp = new Array<>(numBalloons);

        int numLines = numBalloons > limitPerLine ? (numBalloons / limitPerLine) + (numBalloons % limitPerLine == 0 ? 0 : 1) : 1;

        for (int i = 0; i < numLines; i++) {
            boolean newLine = true;
            Balloon prev = null;

            //Handle last line with values like 6/7. You should have 5 balloons per line till the time you have less than 5 left.
            if(i == numLines - 1)
                limitPerLine = numBalloons % limitPerLine;


            for (int j = 0; j < limitPerLine; j++) {
                Balloon b;
                if (newLine) {
                    //Handle first line for the first time
                    if (i == 0)
                        b = new Balloon(distX, height - distY);
                    //Handle first balloon in the second line onwards
                    else
                        b = new Balloon(distX, height - (distY * (i + 1)));
                    newLine = false;
                } else {
                    b = new Balloon((int) prev.getX() + distX, (int) prev.getY());
                }
                temp.add(b);
                prev = b;
            }
        }


        return temp;
    }
}
