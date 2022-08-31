package espol.discoveringecuador.model;

public class Province {
    public String name;

    public Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province: {" +
                "name:\'" + name + '\'' +
                '}';
    }
}
