package com.gamedevelopment.Pong;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Draw {
	
	
	
	/**
	 * Wrapper for the drawRect method when the rotation angle is 0
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void rect(float x, float y, float width, float height)
	{
		rect(x, y, width, height, 0);
	}
	
	/**
	 * Draws a rectangle on the screen
	 * @param x - x coordinate of the lower left corner
	 * @param y - y coordinate of the lower left corner
	 * @param width
	 * @param height
	 * @param angle - rotation angle
	 */
	public static void rect(float x, float y, float width, float height, float angle)
	{
		// create an own unique matrix view for our shape
		glPushMatrix();
		{
			// shifts the entire matrix on x and y axis
			glTranslatef(x, y, 0);
			
			// rotate on the z axis
			glRotatef(angle, 0, 0, 1);
			
			glBegin(GL_QUADS);
			{
				// draw a rectangle
				glVertex2f(0, 0);
				glVertex2f(0, height);
				glVertex2f(width, height);
				glVertex2f(width, 0);
			}
			glEnd();
		}
		glPopMatrix();
	}

}
