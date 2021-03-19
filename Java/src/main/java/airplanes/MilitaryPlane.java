package airplanes;

import classifications.MilitaryPlaneType;

import java.util.Objects;

public class MilitaryPlane extends Plane{
    private MilitaryPlaneType militaryPlaneType;

    public MilitaryPlane(String modelPlane, int maximumSpeedPlane, int maximumFlightDistancePlane,
                         int maximumLoadCapacityPlane, MilitaryPlaneType militaryPlaneType) {
        super(modelPlane, maximumSpeedPlane, maximumFlightDistancePlane, maximumLoadCapacityPlane);
        this.militaryPlaneType = militaryPlaneType;
    }

    public MilitaryPlaneType getMilitaryPlaneType() {
        return militaryPlaneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return militaryPlaneType == that.militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", militaryPlaneType=" + militaryPlaneType +
                        '}');
    }
}
