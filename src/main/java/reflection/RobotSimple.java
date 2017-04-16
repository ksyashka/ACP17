package reflection;

/**
 * Created by ksyashka on 16.04.2017.
 */
public class RobotSimple {
    private int id;
    private String model;
    private double price;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RobotSimple{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        RobotSimple that = (RobotSimple) object;

        return id == that.id;

    }

    @Override
    public int hashCode() {
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

    public RobotSimple() {

    }

    public RobotSimple(int id, String model, double price) {

        this.id = id;
        this.model = model;
        this.price = price;
    }
}
