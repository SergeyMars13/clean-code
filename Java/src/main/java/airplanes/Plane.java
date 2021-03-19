package airplanes;

import java.util.Objects;

abstract public class Plane {
    String modelPlane;
    private int maximumSpeedPlane;
    private int maximumFlightDistancePlane;
    private int maximumLoadCapacityPlane;

    public Plane(String modelPlane, int maximumSpeedPlane, int maximumFlightDistancePlane,
                 int maximumLoadCapacityPlane) {
        this.modelPlane = modelPlane;
        this.maximumSpeedPlane = maximumSpeedPlane;
        this.maximumFlightDistancePlane = maximumFlightDistancePlane;
        this.maximumLoadCapacityPlane = maximumLoadCapacityPlane;
    }

//    public String getModelPlane() {
//        return modelPlane;
//    }

    public int getMaximumSpeedPlane() {
        return maximumSpeedPlane;
    }

    public int getMaximumFlightDistancePlane() {
        return maximumFlightDistancePlane;
    }

    public int getMaximumLoadCapacityPlane() {
        return maximumLoadCapacityPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return maximumSpeedPlane == plane.maximumSpeedPlane
                && maximumFlightDistancePlane == plane.maximumFlightDistancePlane
                && maximumLoadCapacityPlane == plane.maximumLoadCapacityPlane
                && Objects.equals(modelPlane, plane.modelPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelPlane, maximumSpeedPlane, maximumFlightDistancePlane, maximumLoadCapacityPlane);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "modelPlane='" + modelPlane + '\'' +
                ", maximumSpeedPlane=" + maximumSpeedPlane +
                ", maximumFlightDistancePlane=" + maximumFlightDistancePlane +
                ", maximumLoadCapacityPlane=" + maximumLoadCapacityPlane +
                '}';
    }
}
