package com.gamedevelopment.Pong;

import org.lwjgl.opengl.Display;

public class GOPlayer extends GameObject {
	public static final int HUMAN = 0;
	public static final int COMPUTER = 1;
	
	public static final int SIZEX = 16;
	public final static int SIZEY = SIZEX * 7;
	public static final float SPEED = 8f;
	
	// starting position
	public float startX;
	public float startY;
	
	private GOBall ball;
	
	public GOPlayer(float x, float y, GOBall ball)
	{
		this.x = x;
		this.y = y;
		
		this.startX = x;
		this.startY = y;
		
		this.sx = SIZEX;
		this.sy = SIZEY;
		this.ball = ball;
	}
	
	public void move(float magnitude)
	{
		this.y += SPEED * magnitude;
		this.checkBounds();
	}

	private void checkBounds() {
		if (this.y < 0) this.y = 0;
		if (this.y > Display.getHeight() - GOPlayer.SIZEY)
			this.y = Display.getHeight() - GOPlayer.SIZEY;
	}
	
	public void resetPosition()
	{
		this.x = this.startX;
		this.y = this.startY;
	}

	@Override
	void update() {
		// if the ball hits the player
		if (Physics.checkCollisions(this, ball))
		{
			System.out.println("Ball hits the player...");
			ball.reverseX(this.getCenterY());
		}
	}

}
