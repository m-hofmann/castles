package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.CoordinateFactory;
import org.wahlzeit.model.coordinate.SphericCoordinate;

import static org.junit.Assert.*;

/*
 * Test cases for the Coordinate class.
 */
public class SphericCoordinateTest {

    /**
     * Needed for assertEquals() on doubles, provides a boundary for floating point precision errors.
     */
    private final double epsilon = 0.000001;

    private SphericCoordinate coordinateA;
    private SphericCoordinate coordinateB;

    @Before
    public void setUp() {
        coordinateA = CoordinateFactory.CreateSpheric(3, 4, 6371);
        coordinateB = CoordinateFactory.CreateSpheric(2.5, 5.3, 6371);
    }

    @Test
    public void testGetter() {
        assertEquals(3, coordinateA.getLatitude(), epsilon);
        assertEquals(4, coordinateA.getLongitude(), epsilon);
    }

    @Test
    public void testSetter() {
        SphericCoordinate resultLat = coordinateA.setLatitude(42);
        SphericCoordinate resultLatLon = resultLat.setLongitude(23);

        assertEquals(3, coordinateA.getLatitude(), epsilon);
        assertEquals(4, coordinateA.getLongitude(), epsilon);

        assertEquals(42, resultLat.getLatitude(), epsilon);
        assertEquals(42, resultLatLon.getLatitude(), epsilon);
        assertEquals(23, resultLatLon.getLongitude(), epsilon);
    }

    @Test(expected = AssertionError.class)
    public void testDistanceWithNull() {
        coordinateA.getDistance(null);
    }

    @Test
    public void testLatitudinalDistance() {
        assertEquals(-0.5, coordinateA.getLatitudinalDistance(coordinateB), epsilon);
    }

    @Test(expected = AssertionError.class)
    public void testLatitudinalDistanceWithNull() {
        coordinateA.getLatitudinalDistance(null);
    }

    @Test
    public void testLongitudinalDistance() {
        assertEquals(1.3, coordinateA.getLongitudinalDistance(coordinateB), epsilon);
    }

    @Test(expected = AssertionError.class)
    public void testLongitudinalDistanceWithNull() {
        coordinateA.getLongitudinalDistance(null);
    }

    @Test
    public void testDistance() {
        double distance = coordinateA.getDistance(coordinateB);

        assertEquals(154.72081192, distance, epsilon);
    }
}
