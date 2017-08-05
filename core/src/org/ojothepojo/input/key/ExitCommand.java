package org.ojothepojo.input.key;

import com.badlogic.gdx.Gdx;

public class ExitCommand implements InputCommand {

    @Override
    public void execute() {
        Gdx.app.exit();
    }
}
