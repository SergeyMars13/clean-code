package airplanes;

import java.util.Objects;

public class PassengerPlane extends Plane{
    private int seatingCapacityPassengerPlane;

    public PassengerPlane(String modelPlane, int maximumSpeedPlane, int maximumFlightDistancePlane,
                          int maximumLoadCapacityPlane, int seatingCapacityPassengerPlane) {
        super(modelPlane, maximumSpeedPlane, maximumFlightDistancePlane, maximumLoadCapacityPlane);
        this.seatingCapacityPassengerPlane = seatingCapacityPassengerPlane;
    }

    public int getSeatingCapacityPassengerPlane() {
        return seatingCapacityPassengerPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return seatingCapacityPassengerPlane == that.seatingCapacityPassengerPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatingCapacityPassengerPlane);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", seatingCapacityPassengerPlane=" + seatingCapacityPassengerPlane +
                        '}');
    }
}
