package tangramGame.project;

import com.jogamp.opengl.GL2;

public class Shapes {

	public static void square(GL2 gl) {
		square(gl, 1, true);
	}

	public static void square(GL2 gl, double side, boolean makeTextureCoordinate) {

		double radius = side / 2;

		gl.glBegin(GL2.GL_POLYGON);

		// a unit vector
		// the use-case for normals are for light calculation
		gl.glNormal3f(0, 0, 1);

		// setting the texture for the top left corner of the square
		if(makeTextureCoordinate == true) {
			// sets the current texture coordinate
			gl.glTexCoord2d(0, 1);
		}

		gl.glVertex2d(-radius, radius);

		// setting the texture for the bottom left corner of the square
		if(makeTextureCoordinate == true) {
			// sets the current texture coordinate
			gl.glTexCoord2d(0, 0);
		}

		gl.glVertex2d(-radius, -radius);

		// set the texture for the bottom right corner of the square
		if(makeTextureCoordinate == true) {
			// sets the current texture coordinate
			gl.glTexCoord2d(1, 0);
		}

		gl.glVertex2d(radius, -radius);

		// set the texture for the top right corner of the square
		if(makeTextureCoordinate == true) {
			// sets the current texture coordinate
			gl.glTexCoord2d(1, 1);
		}

		gl.glVertex2d(radius, radius);


		gl.glEnd();
	}

	public static void triangle(GL2 gl) {
		triangle(gl, 0.5, true);
	}

	public static void triangle(GL2 gl, double side, boolean makeTextureCoordinate) {

		double radius = side / 2;

		gl.glBegin(GL2.GL_POLYGON);

		// a unit vector
		// the use-case for normals are for light calculation
		gl.glNormal3f(0, 0, 1);

		gl.glVertex2d(-radius/26, radius-0.05);

		gl.glVertex2d(-radius, -radius);

		gl.glVertex2d(radius, -radius);

		gl.glEnd();
	}

	public static void hexagon(GL2 gl) {
		hexagon(gl, 0.5, true);
	}

	public static void hexagon(GL2 gl, double side, boolean makeTextureCoordinate) {

		gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3f(0, 0, 1);

			gl.glVertex2d(-0.5f * side, 1.0f * side);

			gl.glVertex2d(0.5f * side,1.0f * side);

			gl.glVertex2d(1.1f * side,0.0f * side);

			gl.glVertex2d(0.5f * side,-1.0f * side);

			gl.glVertex2d(-0.5f * side,-1.0f * side);

			gl.glVertex2d(-1.1f* side,0.0f * side);
		gl.glEnd();
	}

	public static void rhombus(GL2 gl) {
		rhombus(gl, 0.5, true);
	}

	public static void rhombus(GL2 gl, double side, boolean makeTextureCoordinate) {

		double radius = side / 2;

		gl.glBegin(GL2.GL_POLYGON);

		gl.glNormal3f(0, 0, 1);

		// top left
		gl.glVertex2d(-radius+0.5, radius);

		gl.glVertex2d(-radius, -radius);

		gl.glVertex2d(radius, -radius);

		// top right
		gl.glVertex2d(radius+0.5, radius);


		gl.glEnd();
	}

	public static void rhombusNarrow(GL2 gl) {
		rhombusNarrow(gl, 0.6, true);
	}

	public static void rhombusNarrow(GL2 gl, double side, boolean makeTextureCoordinate) {

		double radius = side / 2;

		gl.glBegin(GL2.GL_POLYGON);

		gl.glNormal3f(0, 0, 1);

		// top left
		gl.glVertex2d(-radius-0.8, radius-0.2);

		// bottom left
		gl.glVertex2d(-radius, -radius);

		// bottom right
		gl.glVertex2d(radius, -radius);

		// top right
		gl.glVertex2d(radius-0.8, radius-0.2);

		gl.glEnd();
	}

	public static void trapezium(GL2 gl) {
		trapezium(gl, 0.5, true);
	}

	public static void trapezium(GL2 gl, double side, boolean makeTextureCoordinate) {

		double radius = side / 2;

		gl.glBegin(GL2.GL_POLYGON);

		gl.glNormal3f(0, 0, 1);

		// top left
		gl.glVertex2d(-radius, radius);

		// bottom left
		gl.glVertex2d(-radius-0.29, -radius);

		// bottom right
		gl.glVertex2d(radius+0.29, -radius);

		// top right
		gl.glVertex2d(radius, radius);

		gl.glEnd();
	}
}
