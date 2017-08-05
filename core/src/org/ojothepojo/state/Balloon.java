package org.ojothepojo.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import org.ojothepojo.BalloonGame;

import java.util.Random;

public class Balloon {
    private static final Texture texture = new Texture(Gdx.files.internal("balloon_red.png"));
    private static final Random random = new Random();
    private static final float INITIAL_SIZE_X = 10f;
    private static final float INIITAL_SIZE_Y =  12f;
    private float sizeX ;
    private float sizeY ;

    private float velocity;
    private float x;
    private float y;
    private Sprite sprite;

    public Balloon() {
        initialize();
        this.sprite = new Sprite(texture);


    }

    public Sprite getSprite() {
        sprite.setPosition(x, y);
        sprite.setSize(sizeX, sizeY);
        return sprite;
    }

    public void move() {
        y = y + velocity;
        if (y > 1.1f * BalloonGame.WORLD_HEIGHT || y < -0.3f * BalloonGame.WORLD_HEIGHT) {
            initialize();
        }
    }

    private void initialize() {
        this.sizeX = INITIAL_SIZE_X;
        this.sizeY = INIITAL_SIZE_Y;
        this.velocity = .1f + random.nextFloat() / 5;
        this.x = random.nextFloat() * BalloonGame.WORLD_WIDTH - this.sizeX / 2;
        this.y = -0.2f * BalloonGame.WORLD_HEIGHT - this.sizeY / 2;
    }

    public boolean isHit(float mouseX, float mouseY) {
        Gdx.app.log("Balloon", toString());

        if (Math.abs((x + sizeX / 2) - mouseX) < sizeX / 2 && Math.abs((y + sizeY / 2) - mouseY) < sizeY / 2) {
            Gdx.app.log("balloon", "hit!");
            this.velocity = Math.abs(this.velocity) * (-1f) - 0.1f;
            this.sizeX = this.sizeX * 0.8f;
            this.sizeY = this.sizeY * 0.8f;
            this.x = this.x + this.sizeX * 0.1f;
            this.y = this.y + this.sizeY * 0.1f;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "velocity=" + velocity +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
