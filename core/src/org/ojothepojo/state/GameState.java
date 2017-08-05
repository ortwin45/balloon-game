package org.ojothepojo.state;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState {


    private Balloon[] balloons;

    public GameState() {
        balloons = new Balloon[10];

        for (int i = 0; i < balloons.length; i++) {
            balloons[i] = new Balloon();
        }
    }

    public void draw(SpriteBatch batch) {
        for (Balloon balloon : balloons) {
            balloon.getSprite().draw(batch);
        }
    }

    public void update() {
        for (Balloon balloon : balloons) {
            balloon.move();
        }
    }

    public void shoot(float x, float y) {
        for (Balloon balloon :balloons) {
            if (balloon.isHit(x, y)) {

            }
        }
    }
}
