package airplanes;

public class PrivatePlane extends Plane {
    private String privatePLaneOwner;

    public PrivatePlane(String modelPlane, int maximumSpeedPlane, int maximumFlightDistancePlane,
                        int maximumLoadCapacityPlane, String privatePLaneOwner) {
        super(modelPlane, maximumSpeedPlane, maximumFlightDistancePlane, maximumLoadCapacityPlane);
        this.privatePLaneOwner = privatePLaneOwner;
    }
}
