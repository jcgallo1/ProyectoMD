package espol.discoveringecuador.model;

import java.util.Set;
import java.util.TreeSet;

public class Province {
    public String name;
    private Set<Food> food;

    public Province(String name) {
        this.name = name;
        this.food = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    public void addFood(Food food) {
        this.food.add(food);
    }

    @Override
    public String toString() {
        return "Province: {" +
                "Name:\'" + name + '\'' +
                "Food:" + food +
                '}';
    }
}
