package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    /**
     * Needed for assertEquals() on doubles, provides a boundary for floating point precision errors.
     */
    private final double epsilon = 0.000001;

    private Coordinate coordinateA;
    private Coordinate coordinateB;

    @Before
    public void setUp() {
        coordinateA = new Coordinate(3, 4);
        coordinateB = new Coordinate(2.5, 5.3);
    }

    @Test
    public void testGetter() {
        assertEquals(3, coordinateA.getLatitude(), epsilon);
        assertEquals(4, coordinateA.getLongitude(), epsilon);
    }

    @Test
    public void testSetter() {
        coordinateA.setLatitude(42);
        coordinateA.setLongitude(23);

        assertEquals(42, coordinateA.getLatitude(), epsilon);
        assertEquals(23, coordinateA.getLongitude(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistanceWithNull() {
        coordinateA.getDistance(null);
    }

    @Test
    public void testLatitudinalDistance() {
        assertEquals(-0.5, coordinateA.getLatitudinalDistance(coordinateB), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLatitudinalDistanceWithNull() {
        coordinateA.getLatitudinalDistance(null);
    }

    @Test
    public void testLongitudinalDistance() {
        assertEquals(1.3, coordinateA.getLongitudinalDistance(coordinateB), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongitudinalDistanceWithNull() {
        coordinateA.getLongitudinalDistance(null);
    }

    @Test
    public void testDistance() {
        double distance = coordinateA.getDistance(coordinateB);

        assertEquals(154.72081192, distance, epsilon);
    }
}
