package org.wahlzeit.model.coordinate;

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

public class CoordinateDistanceCalculation {

    //region Public Static Methods

    /**
     * Calculate the distance between two objects of type Coordinate
     * @param from the left hand side coordinate of the distance calculation
     * @param to the right hand side coordinate of the distance calculation
     * @return the distance between the two coordinates
     * @methodtype get
     */
    public static double getDistance(Coordinate from, Coordinate to) {
        double distance;

        assert from != null : "from coordinate was null";
        assert to != null : "to coordinate was null";

        if (from instanceof CartesianCoordinate && to instanceof CartesianCoordinate) {
            distance =  getDistanceCartesian((CartesianCoordinate) from, (CartesianCoordinate) to);
        } else if (from instanceof SphericCoordinate && to instanceof SphericCoordinate) {
            distance = getDistanceSpheric((SphericCoordinate) from, (SphericCoordinate) to);
        } else if (from instanceof SphericCoordinate && to instanceof CartesianCoordinate) {
            CartesianCoordinate fromAsCartesian = CoordinateUtils.createCartesianFromSpheric((SphericCoordinate) from);

            distance = getDistanceCartesian(fromAsCartesian, (CartesianCoordinate) to);
        } else if (from instanceof CartesianCoordinate && to instanceof SphericCoordinate) {
            CartesianCoordinate toAsCartesian = CoordinateUtils.createCartesianFromSpheric((SphericCoordinate) to);

            distance = getDistanceCartesian((CartesianCoordinate) from, toAsCartesian);
        } else {
            throw new IllegalArgumentException("Unknown coordinate type passed, check if distance calculation has been implemented for this type");
        }

        assert distance >= 0 : "negative values for distance are invalid";

        return distance;
    }

    //endregion

    //region Private Static Methods

    /**
     * Calculate the distance between two coordinates
     * @param from the left hand side coordinate
     * @param to the right hand side variable
     * @return the distance in whatever
     * @methodtype get 
     */
    private static double getDistanceCartesian(CartesianCoordinate from, CartesianCoordinate to) {
        return Math.sqrt(
                Math.pow(to.getX() - from.getX(), 2)
                        + Math.pow(to.getY() - from.getY(), 2)
                        + Math.pow(to.getZ() - from.getZ(), 2)
        );
    }

    /**
     * Calculate the distance between two coordinates
     * @param from the left hand side coordinate
     * @param to the right hand side variable
     * @return the distance in whatever
     * @methodtype get
     */
    private static double getDistanceSpheric(SphericCoordinate from, SphericCoordinate to) {
        assert from.getRadius() == to.getRadius() : "Cannot calculate distances between coordinates not on the same planet.";

        double lat1 = Math.toRadians(from.getLatitude());
        double long1 = Math.toRadians(from.getLongitude());
        double lat2 = Math.toRadians(to.getLatitude());
        double long2 = Math.toRadians(to.getLongitude());

        // see the basic formula at https://en.wikipedia.org/wiki/Great-circle_distance
        double centralAngle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));

        return from.getRadius() * centralAngle;
    }

    //endregion
}
