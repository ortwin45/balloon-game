package org.ojothepojo.input.mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import org.ojothepojo.state.GameState;

public class MouseInputProcessor extends InputAdapter {
    private final OrthographicCamera camera;
    private final GameState gameState;


    public MouseInputProcessor(OrthographicCamera camera, GameState gameState) {
        super();
        this.camera = camera;
        this.gameState = gameState;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Vector3 unproject = camera.unproject(new Vector3(x, y, 0));
            Gdx.app.log("Mouse",  "Unproject X "+ unproject.x + " Unproject Y " + unproject.y);
            gameState.shoot(unproject.x, unproject.y);
            return true;
        }
        return false;
    }
}
