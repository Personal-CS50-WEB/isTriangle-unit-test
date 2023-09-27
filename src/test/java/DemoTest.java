
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class DemoTest {

    @Test
    public void testIsTriangleIsosceles() {
        // Isosceles triangle (two sides are equal)
        assertTrue(Demo.isTriangle(7, 7, 10));
    }

    @Test
    public void testIsTriangleEquilateral() {
        // Equilateral triangle
        assertTrue(Demo.isTriangle(5, 5, 5));
    }

    @Test
    public void testIsTriangleScalene() {
        // Scalene triangle (all sides are different)
        assertTrue(Demo.isTriangle(6, 8, 10));
    }

    @Test
    public void testIsTriangleValid1() {
        assertTrue(Demo.isTriangle(3, 4, 5));

    }

    @Test
    public void testIsTriangleValid2() {
        assertTrue(Demo.isTriangle(5, 12, 13));

    }

    @Test
    public void testIsTriangleValid3() {

        assertTrue(Demo.isTriangle(8, 15, 17));
    }

    @Test
    public void testIsTriangleZeroLengthSides() {
        // All sides have zero length
        assertFalse(Demo.isTriangle(0, 0, 0));
    }

    @Test
    public void testIsTriangleOneSideMaxLength() {
        // One side has an extremely large length
        assertFalse(Demo.isTriangle(Double.MAX_VALUE, 1, 1));
        assertFalse(Demo.isTriangle(1, Double.MAX_VALUE, 1));
        assertFalse(Demo.isTriangle(1, 1, Double.MAX_VALUE));
    }

    @Test
    public void testIsTriangleOneSideZeroLength() {
        // One side has zero length
        assertFalse(Demo.isTriangle(0, 10, 25));
        assertFalse(Demo.isTriangle(4, 0, 5));
        assertFalse(Demo.isTriangle(6, 7, 0));
    }

    @Test
    public void testIsTriangleInvalid() {

        assertFalse(Demo.isTriangle(1, 2, 3));
        assertFalse(Demo.isTriangle(3, -2, 0));
        assertFalse(Demo.isTriangle(1, -2, 1));
        assertFalse(Demo.isTriangle(-1, 2, 1));
        assertFalse(Demo.isTriangle(5, 5, 10)); // Degenerate triangle.
        // assertFalse(Demo.isTriangle(0, 4, 5)); // Non-positive side length.
        assertFalse(Demo.isTriangle(3, 4, 7)); // Sum of two sides is not greater than the third.
        assertFalse(Demo.isTriangle(4, 7, 3)); // Order of sides shouldn't matter.
        assertFalse(Demo.isTriangle(7, 4, 3)); // Order of sides shouldn't matter.
        assertFalse(Demo.isTriangle(0, 0, 3));
        
        // Check for non-positive side lengths
        assertFalse(Demo.isTriangle(-3, 0, 0));
        assertFalse(Demo.isTriangle(0, -3, 0));
        assertFalse(Demo.isTriangle(0, 0, -3));
        assertFalse(Demo.isTriangle(-1, 2, 3));
        assertFalse(Demo.isTriangle(4, 0, 5));
        assertFalse(Demo.isTriangle(6, 7, -8));
    }

    @Test
    public void testMainValidTriangle() {
        // Mock user input for a valid triangle
        String input = "3\n4\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Demo.main(new String[] {});

        String expectedOutput = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is a triangle.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMainInvalidTriangle() {
        // Mock user input for an invalid triangle
        String input = "1\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Demo.main(new String[] {});

        String expectedOutput = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is not a triangle.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
