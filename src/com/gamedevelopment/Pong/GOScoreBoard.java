package com.gamedevelopment.Pong;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;


public class GOScoreBoard extends GameObject{
	public static final int SIZE = 100;
	
	private Texture texture;
	private int score;
	
	public GOScoreBoard(float x, float y, float sx, float sy, Texture texture) {
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		this.score = 0;
		this.texture = texture;
		
		// bind the texture;
		this.texture.bind();
	}

	@Override
	public void update() {

	}
	
	@Override
	public void render() {
		// create an own unique matrix view for our shape
		glPushMatrix();
		{
			// shifts the entire matrix on x and y axis
			glTranslatef(x, y, 0);
			
			glBegin(GL_QUADS);
			{
				// draw a rectangle
				glVertex2f(0, 0);
				glVertex2f(0, SIZE);
				glVertex2f(SIZE, SIZE);
				glVertex2f(SIZE, 0);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
}
