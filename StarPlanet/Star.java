import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double m) {
        this.magnitude = m;
    }

    public Star() {
    }

    public Star(String name, double x, double y, double z, double m) {
        this.magnitude = m;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((!(obj instanceof Star)) || (!super.equals(obj))) {
            return false;
        }
        Star other = (Star) obj;
        return Double.compare(this.magnitude, other.magnitude) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude",this.name, this.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, magnitude);
    }
}