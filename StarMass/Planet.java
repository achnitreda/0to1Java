import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star s, int m) {
        super(name, x, y, z, m);
        centerStar = s;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star s) {
        centerStar = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((!(obj instanceof Planet)) || (!super.equals(obj))) {
            return false;
        }
        Planet other = (Planet) obj;
        return centerStar.equals(other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, centerStar);
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar);
    }
}