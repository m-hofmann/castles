package org.wahlzeit.model;

/**
 * Class representing a location on the globe.
 */
public class Coordinate {

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
     * Calculates the distance in both latitudinal and longitudinal direction and returns it as coordinate object.
     * Note: The interface is strange, but returning a coordinate object is the requirement.
     * @param other the coordinate to calculate the distance to
     * @return a Coordinate object that represents the distance
     * @throws IllegalArgumentException thrown if a null argument was passed.
     */
    public Coordinate getDistance(Coordinate other) {
        return new Coordinate(getLatitudinalDistance(other), getLongitudinalDistance(other));
    }

    /**
     * Calculates the latitudinal distance of this Coordinate to another instance.
     * @param other
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
     * @param other
     * @return the distance as double (may be positive or negative)
     */
    public double getLongitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        return other.getLongitude() - this.getLongitude();
    }
}
