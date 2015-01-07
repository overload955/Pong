package com.gamedevelopment.Pong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Game {
	private ArrayList<GameObject> objects; 
	
	private GOPlayer player;
	private GOEnemy enemy;
	private GOBall ball;
	
	private int playerScore;
	private int enemyScore;
	public static boolean SERVE_WIN;
	
	public Game()
	{
		this.objects = new ArrayList<GameObject>();
		
		this.playerScore = 0;
		this.enemyScore = 0;
		SERVE_WIN = false;
		
		// load texture
		Texture playerScoreTexture = loadTexture("score");
		Texture enemyScoreTexture = loadTexture("score");
		
		this.ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE/2, 
				Display.getHeight()/2 - GOBall.SIZE/2);
		
		this.player = new GOPlayer(0, Display.getHeight()/2 - GOPlayer.SIZEY/2, ball);
		
		this.enemy = new GOEnemy(Display.getWidth() - GOEnemy.SIZEX, 
				Display.getHeight()/2 - GOPlayer.SIZEY/2, ball);
		
		GOWall wall1 = new GOWall(0, 0, Display.getWidth(), GOWall.STANDARD_SIZE, ball);
		GOWall wall2 = new GOWall(0, Display.getHeight() - GOWall.STANDARD_SIZE, 
				Display.getWidth(), GOWall.STANDARD_SIZE, ball);
		
		GODottedLine dottedLine = new GODottedLine(Display.getWidth()/2 - GODottedLine.STANDARD_SIZE/2,
				0, GODottedLine.STANDARD_SIZE, Display.getHeight());
		
//		GOScoreBoard playerScore = new GOScoreBoard(Display.getWidth()/2 - 2*GOScoreBoard.SIZE, 
//			Display.getHeight() - (GOScoreBoard.SIZE + 50), GOScoreBoard.SIZE, GOScoreBoard.SIZE, playerScoreTexture);
//		
//		GOScoreBoard enemyScore = new GOScoreBoard(Display.getWidth()/2 + GOScoreBoard.SIZE, 
//			Display.getHeight() - (GOScoreBoard.SIZE + 50), GOScoreBoard.SIZE, GOScoreBoard.SIZE, enemyScoreTexture);
		
		// add the objects to the list of objects
		objects.add(ball);
		objects.add(player);
		objects.add(enemy);
		objects.add(wall1);
		objects.add(wall2);
		objects.add(dottedLine);
		//objects.add(playerScore);
		//objects.add(enemyScore);
	}

	public void getInput()
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP))
			player.move(1);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			player.move(-1);
	}

	/**
	 * Update all objects
	 */
	public void update() 
	{
		for (GameObject go : objects) 
		{
			go.update();
		}
		
		if (ball.getX() > Display.getWidth()) {
			this.playerScore++;
			this.ball.resetPosition();
			this.player.resetPosition();
			this.enemy.resetPosition();
			SERVE_WIN = true;
		}
		
		if (ball.getX() < 0) {
			this.enemyScore++;
			this.ball.resetPosition();
			this.player.resetPosition();
			this.enemy.resetPosition();
			SERVE_WIN = true;
		}
	}

	/**
	 * Draw all objects
	 */
	public void render() 
	{
		for (GameObject go : objects)
		{
			go.render();
		}
		
		Display.setTitle("Player " + this.playerScore 
				+ " : " + this.enemyScore + " Computer");
	}
	
	@SuppressWarnings("unused")
	private Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("png", new FileInputStream(new File("res/" + key + ".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Texture couldn't be loaded!");
		return null;
	}
	

}
