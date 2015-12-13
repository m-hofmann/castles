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

import java.util.HashMap;

public class CoordinateFactory {
    //region Private Fields

    private static HashMap<Coordinate, Coordinate> sharedCoordinateInstances = new HashMap<>();

    //endregion

    //region public Factory interface

    public static SphericCoordinate CreateSpheric(double latitude, double longitude, double radius) {
        SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude, radius);

        return (SphericCoordinate)GetOrCreateInternal(CoordinateUtils.createCartesianFromSpheric(coordinate), coordinate);
    }

    public static CartesianCoordinate CreateCartesian(double x, double y, double z) {
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);

        return (CartesianCoordinate)GetOrCreateInternal(coordinate, coordinate);
    }

    //endregion

    // region Private Shared object management

    /**
     * @methodtype factory
     */
    private static Coordinate GetOrCreateInternal(Coordinate key, Coordinate value) {
        if (sharedCoordinateInstances.containsKey(key)) {
            return sharedCoordinateInstances.get(key);
        } else {
            sharedCoordinateInstances.put(key, value);
            return value;
        }
    }

    //endregion
}
