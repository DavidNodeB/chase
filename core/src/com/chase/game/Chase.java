package com.chase.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.chase.game.menu.mainMenu;


public class Chase extends Game {

	private SpriteBatch batch;
	private mainMenu menuScreen;

	private BitmapFont font;
	public mainMenu getMenu() {
		return menuScreen;
	}

	public SpriteBatch getBatch() {
		return batch; 
	}


	public void create() {
		batch = new SpriteBatch();
		menuScreen = new mainMenu(this);
		font = new BitmapFont(Gdx.files.internal("fonts/fdf.fnt"));
		this.setScreen(menuScreen);
	}

	public void dispose() {
		super.dispose();
		batch.dispose();
	}

}