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

import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.model.coordinate.Coordinate;

@Entity
public class Location {

    @Id
    Long id;

    @Container
    public Coordinate coordinate;

    private String name;

    public String getName() {
        return name;
    }


    /**
     * Needed for Google App Engine integration
     */
    protected Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, Coordinate coordinate) {
        this(name);
        //this.coordinate = coordinate;
    }
}
