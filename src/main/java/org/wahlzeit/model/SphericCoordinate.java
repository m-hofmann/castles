package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * Class representing a location on the globe.
 */
@Subclass
public class SphericCoordinate extends AbstractCoordinate {

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

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Forbid using the constructor without parameters
     * @methodtype constructor
     */
    private SphericCoordinate() {

    }

    /**
     * Creates a new instance of Coordinate.
     * @param latitude the latitude of the coordinate
     * @param longitude the longitude of the coordinate
     * @methodtype constructor
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    /**
     * Calculates the latitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     * @methodtype get
     */
    public double getLatitudinalDistance(SphericCoordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        return other.getLatitude() - this.getLatitude();
    }

    /**
     * Calculates the longitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     * @methodtype get
     */
    public double getLongitudinalDistance(SphericCoordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("argument other must not be null");
        }

        return other.getLongitude() - this.getLongitude();
    }

    /**
     * Compare two coordinate objects for equality...
     * @param other the coordinate to compare
     * @return true iff objects are equal
     * @methodtype comparison
     */
    @Override
    public boolean isEqual(Coordinate other) {
        return equals(other);
    }

    /**
     * Determines whether another Object is equal to this object.
     * @param o the object to compare
     * @return true iff the objects are equal
     * @methodtype comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphericCoordinate that = (SphericCoordinate) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        return Double.compare(that.longitude, longitude) == 0;

    }

    /**
     * @return a hash code for this object
     * @methodtype get
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
