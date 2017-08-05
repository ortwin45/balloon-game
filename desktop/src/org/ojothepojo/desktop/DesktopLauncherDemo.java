package org.ojothepojo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.ojothepojo.BalloonGame;
import org.ojothepojo.OrthographicCameraExample;

public class DesktopLauncherDemo {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 1920;
		config.height  = 1080;
		config.fullscreen = true;

		new LwjglApplication(new OrthographicCameraExample(), config);
	}
}
