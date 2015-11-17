package org.wahlzeit.model;

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

public abstract class AbstractCoordinate implements Coordinate {
    /**
     * Calculate the distance between two points in kilometers.
     * Does not provide very accurate results due to the formula used.
     * @param other the coordinate to calculate the distance to
     * @return a Coordinate object that represents the distance
     * @throws IllegalArgumentException thrown if a null argument was passed.
     * @methodtype get
     */
    @Override
    public double getDistance(Coordinate other) {

        double distance = CoordinateDistanceCalculation.getDistance(this, other);

        return distance;
    }
}
