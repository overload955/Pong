package com.gamedevelopment.Pong;

/**
 * Class that represents the ball in the game
 * @author Ovi
 *
 */
public class GOBall extends GameObject {
	
	public static final int SIZE = 16;
	
	// set max speed on each axis
	public static final float MAX_SPEEDX = 10f;
	public static final float MAX_SPEEDY = 10f;
	public static final float DAMPING = 0.05f;
	
	// velocity represents the speed in a certain direction
	public float velX;	// velocity in X
	public float velY;  // velocity in Y
	
	// starting position
	public float startX;
	public float startY;
	
	public GOBall(float x, float y)
	{
		// set the position of the ball
		this.x = x;
		this.y = y;
		
		// keep the staring position
		this.startX = x;
		this.startY = y;
		
		this.sx = SIZE;
		this.sy = SIZE;
		
		this.velX = -MAX_SPEEDX; // move to the left
		this.velY = 0;			 // no moving in the y axis
	}
	
	public void reverseX(float center)
	{
		this.velX *= -1;		// change direction on x axis
		this.velY += (getCenterY() - center) * DAMPING;
		
		if (velY > MAX_SPEEDY) velY = MAX_SPEEDY;
		if (velY < -MAX_SPEEDY) velY = -MAX_SPEEDY;
	}
	
	public void reverseY() {
		this.velY *= -1;
	}
	
	public void resetPosition()
	{
		this.x = this.startX;
		this.y = this.startY;
		
		// ball goes in the direction of the player who win the point
		this.velX *= -1;
		this.velY = 0;
	}

	@Override
	void update() 
	{
		this.x += this.velX;
		this.y += this.velY;
	}

}
