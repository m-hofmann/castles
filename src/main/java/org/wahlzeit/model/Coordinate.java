package org.wahlzeit.model;

/**
 * Class representing a location on the globe.
 */
public class Coordinate {

    private final static double EARTHRADIUSKM = 6371;

    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // forbid using the constructor without parameters
    private Coordinate() {
    }

    /**
     * Creates a new instance of Coordinate.
     * @param latitude the latitude of the coordinate
     * @param longitude the longitude of the coordinate
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Calculate the distance between two points in kilometers.
     * Does not provide very accurate results due to the formula used.
     * @param other the coordinate to calculate the distance to
     * @return a Coordinate object that represents the distance
     * @throws IllegalArgumentException thrown if a null argument was passed.
     */
    public double getDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        double lat1 = Math.toRadians(this.getLatitude());
        double long1 = Math.toRadians(this.getLongitude());
        double lat2 = Math.toRadians(other.getLatitude());
        double long2 = Math.toRadians(other.getLongitude());

        // see the basic formula at https://en.wikipedia.org/wiki/Great-circle_distance
        double centralAngle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));
        double distance = EARTHRADIUSKM * centralAngle;

        return distance;
    }

    /**
     * Calculates the latitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     */
    public double getLatitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        return other.getLatitude() - this.getLatitude();
    }

    /**
     * Calculates the longitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     */
    public double getLongitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        return other.getLongitude() - this.getLongitude();
    }
}
