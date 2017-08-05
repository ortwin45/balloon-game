package org.ojothepojo;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.ojothepojo.input.key.KeyboardInputHandler;
import org.ojothepojo.input.mouse.MouseInputProcessor;
import org.ojothepojo.state.GameState;

public class BalloonGame extends ApplicationAdapter {
    public static final float WORLD_WIDTH = 128;
    public static final float WORLD_HEIGHT = 72;

    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Sprite background;

    private KeyboardInputHandler keyboardInputHandler;

    private GameState gameState;

    @Override
    public void create() {
        Cursor customCursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("crosshair.png")), 64, 64);
        Gdx.graphics.setCursor(customCursor);

        Gdx.app.setLogLevel(Application.LOG_ERROR);
        background = new Sprite(new Texture(Gdx.files.internal("background.png")));
        background.setPosition(0, 0);
        background.setSize(WORLD_WIDTH, WORLD_HEIGHT);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(WORLD_WIDTH / 2 , WORLD_HEIGHT / 2 * (h / w));
        cam.position.set(WORLD_WIDTH / 2f, WORLD_HEIGHT / 2f, 0);
        cam.update();

        batch = new SpriteBatch();

        gameState = new GameState();
        keyboardInputHandler = new KeyboardInputHandler();
        Gdx.input.setInputProcessor(new MouseInputProcessor(cam, gameState));
    }

    @Override
    public void render() {
        keyboardInputHandler.handle(cam);

        gameState.update();

        cam.update();
        batch.setProjectionMatrix(cam.combined);


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        gameState.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();

    }

    @Override
    public void resize(int width, int height) {
        cam.viewportWidth = WORLD_WIDTH;
        cam.viewportHeight = WORLD_WIDTH * height / width; // Lets keep things in proportion.
        cam.update();
    }

}
