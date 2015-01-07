package com.gamedevelopment.Pong;

public class GOWall extends GameObject {
	
	public static final int STANDARD_SIZE = 1;
	private GOBall ball;
	
	public GOWall(float x, float y, float sx, float sy, GOBall ball)
	{
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		this.ball = ball;
	}


	@Override
	void update() 
	{
		if (Physics.checkCollisions(this, ball))
		{
			System.out.println("Ball hits the wall...");
			ball.reverseY();
		}
			
	}
	
}
