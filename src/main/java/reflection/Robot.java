package reflection;

import java.util.Arrays;
import java.util.List;

public class Robot {

    private int id;
    private String model;
    private double price;
    private String[] commands;
    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Robot(int id, String model, double price, String[] commands, Cat cat) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.commands = commands;
        this.cat = cat;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    public Robot(int id, String model, double price, String[] commands) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.commands = commands;
    }

    public Robot() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Robot robot = (Robot) object;

        if (id != robot.id) return false;
        if (Double.compare(robot.price, price) != 0) return false;
        if (model != null ? !model.equals(robot.model) : robot.model != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(commands, robot.commands)) return false;
        return cat != null ? cat.equals(robot.cat) : robot.cat == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(commands);
        result = 31 * result + (cat != null ? cat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", commands=" + Arrays.toString(commands) +
                ", cat=" + cat +
                '}';
    }
}

