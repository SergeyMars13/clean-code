package airplanes;

import classifications.SecrecyLevelType;
import classifications.ExperimentalPlaneType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{
    private ExperimentalPlaneType experimentalPlaneType;
    private SecrecyLevelType secrecyLevelType;

    public ExperimentalPlane(String modelPlane, int maximumSpeedPlane, int maximumFlightDistancePlane,
                             int maximumLoadCapacityPlane, ExperimentalPlaneType experimentalPlaneType,
                             SecrecyLevelType secrecyLevelType) {
        super(modelPlane, maximumSpeedPlane, maximumFlightDistancePlane, maximumLoadCapacityPlane);
        this.experimentalPlaneType = experimentalPlaneType;
        this.secrecyLevelType = secrecyLevelType;
    }

    public SecrecyLevelType getSecrecyLevelType(){
        return secrecyLevelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return experimentalPlaneType == that.experimentalPlaneType && secrecyLevelType == that.secrecyLevelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalPlaneType, secrecyLevelType);
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "modelPlane='" + modelPlane + '\'' +
                '}';
    }
}

