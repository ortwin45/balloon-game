package org.ojothepojo.input.key;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class KeyboardInputHandler {
    private ExitCommand ExitCommand = new ExitCommand();
    private final float rotationSpeed = 0.5f;

    public void handle(OrthographicCamera cam) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            ExitCommand.execute();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            cam.translate(-1, 0, 0);
            //If the LEFT Key is pressed, translate the camera -3 units in the X-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            cam.translate(1, 0, 0);
            //If the RIGHT Key is pressed, translate the camera 3 units in the X-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            cam.translate(0, -1, 0);
            //If the DOWN Key is pressed, translate the camera -3 units in the Y-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            cam.translate(0, 1, 0);
            //If the UP Key is pressed, translate the camera 3 units in the Y-Axis
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            cam.rotate(-rotationSpeed, 0, 0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            cam.rotate(rotationSpeed, 0, 0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cam.zoom += 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            cam.zoom -= 0.02;
        }

    }
}
