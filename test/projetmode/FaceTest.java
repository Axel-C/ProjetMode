package projetmode;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;

public class FaceTest {

	@Test
	public void testTranslate() {
		Face actualFace = new Face(new Point[] { new Point(5, 0, 10), new Point(5, 5, 10), new Point(0, 5, 15) });
		System.out.println(actualFace);
		System.out.println(actualFace.getPoints()[0]);
		Matrix columnMatrix = new Matrix(new double[][] { { 0 }, { 5 }, { 0 }, { 1 } });
		actualFace.translate(columnMatrix);
		Face expectedFace = new Face(new Point[] {
				new Point(5 + columnMatrix.getElement(0, 0), 0 + columnMatrix.getElement(1, 0),
						10 + columnMatrix.getElement(2, 0)),
				new Point(5 + columnMatrix.getElement(0, 0), 5 + columnMatrix.getElement(1, 0),
						10 + columnMatrix.getElement(2, 0)),
				new Point(0 + columnMatrix.getElement(0, 0), 5 + columnMatrix.getElement(1, 0),
						15 + columnMatrix.getElement(2, 0)) });
		for (int i = 0; i < expectedFace.getPoints().length; i++) {
			assertEquals(expectedFace.getPoints()[i].getX(), actualFace.getPoints()[i].getX(), 0.1);
			assertEquals(expectedFace.getPoints()[i].getY(), actualFace.getPoints()[i].getY(), 0.1);
			assertEquals(expectedFace.getPoints()[i].getZ(), actualFace.getPoints()[i].getZ(), 0.1);
		}
	}
	
	@Test
	public void testNormal() {
		Face actualFace = new Face(new Point[] { new Point(5, 0, 10), new Point(5, 5, 10), new Point(0, 5, 15) });
		Matrix expectedNormal= new Matrix(3,1);
		expectedNormal.setElement(0, 0, 25.0);
		expectedNormal.setElement(1, 0, 0.0);
		expectedNormal.setElement(2, 0, 25.0);
		Matrix actualNormal= new Matrix(3,1);
		actualNormal=actualFace.normal();
		for (int i = 0; i < expectedNormal.getM(); i++) {
			assertEquals(expectedNormal.getElement(i, 0), actualNormal.getElement(i, 0), 0.1);
		}
	}

	@Test
	public void testScale() {
		Face actualFace = new Face(new Point[] { new Point(5, 0, 10), new Point(5, 5, 10), new Point(0, 5, 15) });
		Matrix columnMatrix = new Matrix(new double[][] { { 0 }, { 5 }, { 0 }, { 1 } });
		actualFace.scale(columnMatrix);
		Face expectedFace = new Face(new Point[] {
				new Point(5 * columnMatrix.getElement(0, 0), 0 * columnMatrix.getElement(1, 0),
						10 * columnMatrix.getElement(2, 0)),
				new Point(5 * columnMatrix.getElement(0, 0), 5 * columnMatrix.getElement(1, 0),
						10 * columnMatrix.getElement(2, 0)),
				new Point(0 * columnMatrix.getElement(0, 0), 5 * columnMatrix.getElement(1, 0),
						15 * columnMatrix.getElement(2, 0)) });
		for (int i = 0; i < expectedFace.getPoints().length; i++) {
			assertEquals(expectedFace.getPoints()[i].getX(), actualFace.getPoints()[i].getX(), 0.1);
			assertEquals(expectedFace.getPoints()[i].getY(), actualFace.getPoints()[i].getY(), 0.1);
			assertEquals(expectedFace.getPoints()[i].getZ(), actualFace.getPoints()[i].getZ(), 0.1);
		}
	}

}
