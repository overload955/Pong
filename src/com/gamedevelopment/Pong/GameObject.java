package com.gamedevelopment.Pong;

public abstract class GameObject {
	protected float x;
	protected float y;
	protected float sx; // width
	protected float sy; // height
	
	abstract void update();
	
	/**
	 * Draw the object
	 */
	public void render()
	{
		Draw.rect(x, y, sx, sy);
	}
	
	public float getX()
	{
		return this.x;
	}
	
	public float getY()
	{
		return this.y;
	}
	
	public float getSx()
	{
		return this.sx;
	}
	
	public float getSy()
	{
		return this.sy;
	}
	
	/**
	 * Get the center of the object on y axis
	 * @return
	 */
	public float getCenterY()
	{
		return (this.sy / 2) + this.y;
	}

}
