package espol.discoveringecuador.model;

import java.util.ArrayList;
import java.util.Set;

public class Country {
    private Set<Region> regions;
    private String name;

    public Country(Set<Region> regions) {
        this.regions = regions;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    public ArrayList<Region> getRegionList() {
        ArrayList<Region> tmp = new ArrayList<>();
        for (Region r : regions) {
            tmp.add(r);
        }
        return tmp;
    }

    @Override
    public String toString() {
        return "Country: {" +
                "Name: \"" + name + "\", " +
                "Regions:" + regions +
                '}';
    }
}
