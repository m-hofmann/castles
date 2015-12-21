package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Castle extends DataObject {
    //region Objectify

    @Id long id;

    //endregion

    //region Type Object Implementation

    private CastleType castleType;

    public CastleType getCastleType() {
        return castleType;
    }

    public void setCastleType(CastleType castleType) {
        this.castleType = castleType;
    }

    public CastlePhoto createCastlePhoto() {
        CastlePhoto thePhoto = CastlePhotoFactory.getInstance().createPhoto();
        return thePhoto;
    }

    //endregion

    //region Properties

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Date buildDate;

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    private String architectName;

    public String getArchitectName() {
        return architectName;
    }

    public void setArchitectName(String architectName) {
        this.architectName = architectName;
    }

    //endregion

    //region Constructors

    private Castle() {
    }

    public Castle(CastleType type) {
        this.castleType = type;
    }

    //endregion
}
