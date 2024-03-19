package com.chase.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.chase.game.Chase;

public class mainMenu implements Screen {
    final Chase game;

    Texture menuBackground;

    Texture menuBackground2;

    Image startButton;

    Image exitButton;

    Image optionsButton;

    Label startLabel;

    Label optionsLabel;

    Label exitLabel;

    Stage stage;

    Texture backGroundTexture;

    private float backGroundx = 0;

    private double backGroundVelocity = 1.5;

	public mainMenu(final Chase game) {
        this.game = game;

        menuBackground = new Texture("background/city.png");

        menuBackground2 = new Texture("background/city.png");

        startButton = new Image(new Texture("frames/buttonorange.png"));

        optionsButton = new Image(new Texture("frames/buttonorange.png"));

        exitButton = new Image(new Texture("frames/buttonorange.png"));

        BitmapFont pixelFont = new BitmapFont(Gdx.files.internal("fonts/fdf.fnt"));

        startLabel = new Label("Start Game", new Label.LabelStyle(pixelFont, Color.WHITE));

        startLabel.setAlignment(Align.center);

        optionsLabel = new Label("Options", new Label.LabelStyle(pixelFont, Color.WHITE));

        optionsLabel.setAlignment(Align.center);


        exitLabel = new Label("Exit", new Label.LabelStyle(pixelFont, Color.WHITE));

        exitLabel.setAlignment(Align.center);

        backGroundTexture = new Texture(Gdx.files.internal("frames/menu_bg.png"));


        Drawable backgroundDrawable = new TextureRegionDrawable(backGroundTexture);

        stage = new Stage(new ScreenViewport());

        Table table = new Table();
        table.setFillParent(true);
        table.setBackground(backgroundDrawable);
        table.add(startLabel).padBottom(20).row();
        table.add(optionsLabel).padBottom(20).row();
        table.add(exitLabel).padBottom(20).row();

        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
	}

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getViewport().apply();

        game.getBatch().setProjectionMatrix(stage.getViewport().getCamera().combined);

        game.getBatch().begin();
        game.getBatch().draw(menuBackground, backGroundx, 0, stage.getWidth(), stage.getHeight());
        game.getBatch().draw(menuBackground2, backGroundx + stage.getWidth(), 0, stage.getWidth(), stage.getHeight());
        game.getBatch().end();

        backGroundx -= backGroundVelocity;

        if (backGroundx + stage.getWidth() == 0) {
            backGroundx = 0;
        }

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void show() {
        // TODO
    }

    @Override
    public void pause() {
        // TODO
    }

    @Override
    public void resume() {
        // TODO
    }

    @Override
    public void hide() {
        // TODO
    }

    @Override
    public void dispose() {
        stage.dispose();
        menuBackground.dispose();
    }

}