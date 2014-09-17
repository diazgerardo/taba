package ar.com.scriptorum.beans;

import java.util.Set;

public class PName implements PersistentEntity {

    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String creation;
    private Set<PUnit> punits;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PUnit> getPunits() {
        return punits;
    }

    public void setPunits(Set<PUnit> punits) {
        this.punits = punits;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

}
