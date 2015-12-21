package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
public class CastleType extends DataObject {
    //region Objectify

    @Id
    long id;

    //endregion

    //region Type Object Implementation

    private final List<Castle> instances = new LinkedList<>();

    public List<Castle> getInstances() {
        return Collections.unmodifiableList(instances);
    }

    public void addInstance(Castle castle) {
        instances.add(castle);
    }

    public void removeInstance(Castle castle) {
        instances.remove(castle);
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

    private ArchitecturalStyle architecturalStyle;

    public ArchitecturalStyle getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(ArchitecturalStyle architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
    }

    private GeographicalArea geographicalArea;

    public GeographicalArea getGeographicalArea() {
        return geographicalArea;
    }

    public void setGeographicalArea(GeographicalArea geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    //endregion

    //region Constructors

    public CastleType(String name, ArchitecturalStyle architecturalStyle, GeographicalArea geographicalArea) {
        this.name = name;
        this.architecturalStyle = architecturalStyle;
        this.geographicalArea = geographicalArea;
    }

    //endregion
}
