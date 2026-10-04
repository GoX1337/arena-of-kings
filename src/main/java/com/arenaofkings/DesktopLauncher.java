package com.arenaofkings;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
  public static void main(String[] args) {
    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setTitle("Arena of Kings - ZQSD + Mouse");
    config.setWindowedMode(1280, 720);
    config.setWindowIcon("icons/app-icon.png");
    config.useVsync(true);
    config.setForegroundFPS(60);
    new Lwjgl3Application(new ArenaOfKingsGame(), config);
  }
}
