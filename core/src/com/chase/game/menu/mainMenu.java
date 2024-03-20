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
import org.w3c.dom.Text;

public class mainMenu implements Screen {
    final Chase game;

    Texture menuBackground;

    Texture menuBackground2;
    Label startLabel;

    Label optionsLabel;

    Label exitLabel;

    Stage stage;

    Texture backGroundTexture;

    private float backGroundx = 0;

    private double backGroundVelocity = 1.5;

    public Label createLabel(BitmapFont font, Color col, String text) {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = font;
        style.fontColor = col;
        Label name = new Label(text, style);
        return name;
    }

	public mainMenu(final Chase game) {
        this.game = game;

        menuBackground = new Texture("background/city.png");

        menuBackground2 = new Texture("background/city.png");

        BitmapFont pixelFont = new BitmapFont(Gdx.files.internal("fonts/fdf.fnt"));

        startLabel = createLabel(pixelFont, Color.WHITE, "Start Game");

        optionsLabel = createLabel(pixelFont, Color.WHITE, "Option Game");

        exitLabel = createLabel(pixelFont, Color.WHITE, "Exit");

        

        backGroundTexture = new Texture(Gdx.files.internal("frames/menu_bg.png"));

        Drawable backgroundDrawable = new TextureRegionDrawable(backGroundTexture);

        stage = new Stage(new ScreenViewport());

        Table table = new Table();

        table.setSize(250f, 250f);

        table.setBackground(backgroundDrawable);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2, (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.add(startLabel).padBottom(20).row();

        table.add(optionsLabel).padBottom(20).row();

        table.add(exitLabel).padBottom(20).row();

        table.setName("tableActor");
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
	}

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        Table table = stage.getRoot().findActor("tableActor");
        table.setPosition((stage.getWidth() - table.getWidth()) / 2, (stage.getHeight() - table.getHeight()) / 2);
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