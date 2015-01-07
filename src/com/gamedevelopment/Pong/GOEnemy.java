package com.gamedevelopment.Pong;

import org.lwjgl.opengl.Display;

public class GOEnemy extends GameObject {
	
	public static final int SIZEX = 16;
	public final static int SIZEY = SIZEX * 7;
	public static final float MAX_SPEEDY = 8f;
	public static final float DAMPING = 0.1f;
	
	// starting position
	public float startX;
	public float startY;
	
	private GOBall ball;
	
	public GOEnemy(float x, float y, GOBall ball)
	{
		this.x = x;
		this.y = y;
		this.sx = SIZEX;
		this.sy = SIZEY;
		
		this.startX = x;
		this.startY = y;
		
		this.ball = ball;
	}
	
	public void resetPosition()
	{
		this.x = this.startX;
		this.y = this.startY;
	}

	@Override
	void update() 
	{
		if (Physics.checkCollisions(this, ball))
		{
			System.out.println("Ball hits the enemy...");
			ball.reverseX(this.getCenterY());
		}
			
		
		float speed = (ball.getCenterY() - this.getCenterY()) * DAMPING;
		
		if (speed > MAX_SPEEDY) speed = MAX_SPEEDY;
		if (speed < -MAX_SPEEDY) speed = -MAX_SPEEDY;
		
		this.y += speed;
		this.checkBounds();
		
	}
	
	private void checkBounds() {
		if (this.y < 0) this.y = 0;
		if (this.y > Display.getHeight() - GOPlayer.SIZEY)
			this.y = Display.getHeight() - GOPlayer.SIZEY;
	}

}
