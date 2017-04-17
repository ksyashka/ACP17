package reflection;

/**
 * Created by ksyashka on 15.04.2017.
 */
public class Cat {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat() {

    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Cat cat = (Cat) object;

        return name != null ? name.equals(cat.name) : cat.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
