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

import java.util.HashMap;

public class CastlePhotoManager extends PhotoManager {

    protected static final CastlePhotoManager instance = new CastlePhotoManager();

    private final HashMap<String, CastleType> allCastleTypes = new HashMap<>();

    @Override
    public Photo getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        Photo result = doGetPhotoFromId(id);

        if (result == null) {
            result = CastlePhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;
    }

    public CastleType getOrCreateCastleType(String name,
                                       ArchitecturalStyle architecturalStyle,
                                       GeographicalArea geographicalArea) {
        if (allCastleTypes.containsKey(name)) {
                return allCastleTypes.get(name);
        }

        synchronized (allCastleTypes) {
            CastleType newType = new CastleType(name, architecturalStyle, geographicalArea);
            allCastleTypes.put(name, newType);
            return  newType;
        }
    }

    public Castle createCastle(CastleType castleType) {
        Castle newCastle = new Castle(castleType);
        castleType.addInstance(newCastle);
        return newCastle;
    }
}
