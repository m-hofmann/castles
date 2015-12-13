package org.wahlzeit.model.coordinate;

import com.googlecode.objectify.annotation.Subclass;

/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 *  This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

/**
 * Class representing a location on the globe.
 */
@Subclass
public class SphericCoordinate extends AbstractCoordinate {

    private final double latitude;

    public double getLatitude() {
        return latitude;
    }

    public SphericCoordinate setLatitude(double latitude) {
        return CoordinateFactory.CreateSpheric(latitude, longitude, radius);
    }

    private final double longitude;

    public double getLongitude() {
        return longitude;
    }

    public SphericCoordinate setLongitude(double longitude) {
        return CoordinateFactory.CreateSpheric(latitude, longitude, radius);
    }

    private final double radius;

    public double getRadius() {
        return radius;
    }

    public SphericCoordinate setRadius(double radius) {
        return CoordinateFactory.CreateSpheric(latitude, longitude, radius);
    }

    /**
     * Creates a new instance of Coordinate.
     * @param latitude the latitude of the coordinate
     * @param longitude the longitude of the coordinate
     * @methodtype constructor
     */
    protected SphericCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        assertClassInvariants();
    }

    /**
     * Calculates the latitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     * @methodtype get
     */
    public double getLatitudinalDistance(SphericCoordinate other) {
        assert other != null : "argument other must not be null";

        return other.getLatitude() - this.getLatitude();
    }

    /**
     * Calculates the longitudinal distance of this Coordinate to another instance.
     * @param other the other coordinate
     * @return the distance as double (may be positive or negative)
     * @methodtype get
     */
    public double getLongitudinalDistance(SphericCoordinate other) {
        assert other != null : "argument other must not be null";

        return other.getLongitude() - this.getLongitude();
    }

    private void assertClassInvariants() {
        assert latitude <= 90 : "latitude too large";
        assert latitude >= -90 : "latitude too small";

        assert longitude <= 180 : "longitude too large";
        assert longitude >= -180 : "longitude too small";

        assert radius > 0 : "invalid value for radius";
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
