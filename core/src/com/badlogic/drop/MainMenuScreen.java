package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {

    final Drop game;

    // Implement pause to main menu
    GameScreen gamescreen;

    OrthographicCamera camera;

    public MainMenuScreen(final Drop gam) {
        game = gam;

        // Implement pause to main menu
        // Pass this MainMenuScreen to the GameScreen.
        gamescreen = new GameScreen(game, this);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            // game.setScreen(new GameScreen(game));
            // dispose();

            // Implement pause to main menu;
            // switches back to game screen to resume game
            gamescreen.setGameState(State.RUN);
            game.setScreen(gamescreen);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}