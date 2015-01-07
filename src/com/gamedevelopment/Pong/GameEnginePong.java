package com.gamedevelopment.Pong;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameEnginePong {
	private static Game game;
	
	public static void main(String[] args) 
	{
		// initialize the program
		initDisplay();
		initGL();
		initGame();
		
		gameLoop();
		cleanUp();
		
	}

	private static void initDisplay()
	{
		// create display
		try {
			Display.setDisplayMode(new DisplayMode(1000, 600));
			Display.create();
			Display.setVSyncEnabled(true);
			Keyboard.create(); // get user input
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	private static void initGL() 
	{
		glMatrixMode(GL_PROJECTION); 	// select the projection matrix
		glLoadIdentity();				// clears the current matrix
		
		// set the three axis of the screen
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		
		glMatrixMode(GL_MODELVIEW);		// switch to model view matrix
		glClearColor(0, 0, 0, /* alpha channel */ 1); // set the default color
		
		//glDisable(GL_DEPTH);			// only 2D drawings
		
	}
	
	private static void initGame() 
	{
		game = new Game();
	}

	private static void gameLoop() 
	{
		
		while (!Display.isCloseRequested())
		{
			getInput();
			update();
			render();
		}
	}
	
	private static void getInput() 
	{
		game.getInput();
	}
	
	private static void update()
	{
		game.update();
	}
	
	private static void render()
	{
		// clears the screen
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity(); 			// clears the current matrix view
		
		game.render();
		
		Display.update();
		Display.sync(60); 			// FPS
		
		// if someone won, wait a second
		if (Game.SERVE_WIN)
		{
			Game.SERVE_WIN = false;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void cleanUp() 
	{
		Display.destroy();
		Keyboard.destroy();
	}
	
}
