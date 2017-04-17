package reflection;

import java.util.Arrays;

/**
 * Created by ksyashka on 16.04.2017.
 */
public class RobotSimple {
    private int id;
    private String model;
    private double price;
    private String[] commands;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RobotSimple{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", commands=" + Arrays.toString(commands) +
                '}';
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        RobotSimple that = (RobotSimple) object;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(commands, that.commands);

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
        return result;
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

    public RobotSimple() {

    }

    public RobotSimple(int id, String model, double price, String[] commands) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.commands = commands;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }
}
