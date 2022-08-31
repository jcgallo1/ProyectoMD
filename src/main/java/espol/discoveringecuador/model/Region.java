package espol.discoveringecuador.model;

import java.util.ArrayList;
import java.util.Set;

public class Region {
    private Set<Province> provinces;
    private String name;

    public Region(String name, Set<Province> provinces) {
        this.name = name;
        this.provinces =  provinces;
    }

    public Set<Province> getProvinces() {
        return provinces;
    }

    public ArrayList<Province> getProvincesList() {
        ArrayList<Province> tmp = new ArrayList<>();
        for (Province province : provinces) {
            tmp.add(province);
        }
        return tmp;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region: {" +
                "Name:\"" + name + "\"," +
                "Provinces:" + provinces +
                '}';
    }
}