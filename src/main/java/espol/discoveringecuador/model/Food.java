package espol.discoveringecuador.model;

public class Food {
    public String name;
    public Province province;

    public Food(String name, Province province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Food: {" +
                "name:\'" + name + '\'' +
                ", province:" + province +
                '}';
    }
}
