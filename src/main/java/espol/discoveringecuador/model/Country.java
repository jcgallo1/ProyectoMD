package espol.discoveringecuador.model;

import java.util.Set;

public class Country {
    private Set<Region> regions;

    public Country(Set<Region> regions) {
        this.regions = regions;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Country: {" +
                "Regions:" + regions +
                '}';
    }
}
