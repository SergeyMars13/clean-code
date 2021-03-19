import airplanes.ExperimentalPlane;
import classifications.MilitaryPlaneType;
import airplanes.MilitaryPlane;
import airplanes.PassengerPlane;
import airplanes.Plane;
import classifications.SecrecyLevelType;

import java.util.*;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> listPlanes;

    public Airport(List<? extends Plane> listPlanes) {
        this.listPlanes = listPlanes;
    }

    public List<? extends Plane> getListPlanes() {
        return listPlanes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "listPlanes=" + listPlanes +
                '}';
    }

    public List<PassengerPlane> getListPassengerPlanes() {
        List<PassengerPlane> listPassengerPlanes = new ArrayList<>();
        for (Plane plane : listPlanes) {
            if (plane instanceof PassengerPlane) {
                listPassengerPlanes.add((PassengerPlane) plane);
            }
        }
        return listPassengerPlanes;
    }

    public List<MilitaryPlane> getListMilitaryPlanes() {
        List<MilitaryPlane> listMilitaryPlanes = new ArrayList<>();
        for (Plane plane : listPlanes) {
            if (plane instanceof MilitaryPlane) {
                listMilitaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return listMilitaryPlanes;
    }

    public List<ExperimentalPlane> getListExperimentalPlanes() {
        List<ExperimentalPlane> listExperimentalPlanes = new ArrayList<>();
        for (Plane plane : listPlanes) {
            if (plane instanceof ExperimentalPlane) {
                listExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return listExperimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaximumSeatingCapacity() {
        List<PassengerPlane> passengerPlanes = getListPassengerPlanes();
        passengerPlanes.sort((o1, o2) -> o1.getSeatingCapacityPassengerPlane() - o2.getSeatingCapacityPassengerPlane());
        return passengerPlanes.get(passengerPlanes.size() - 1);
    }

    public List<MilitaryPlane> getListMilitaryPlanesTransportType() {
        return getListMilitaryPlanes()
                .stream()
                .filter(plane -> plane.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getListMilitaryPlanesBomberType() {
        return getListMilitaryPlanes()
                .stream()
                .filter(plane -> plane.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER)
                .collect(Collectors.toList());
    }

    public Airport sortListPlanesByMaximumFlightDistance() {
        listPlanes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaximumFlightDistancePlane()
                - o2.getMaximumFlightDistancePlane());
        return this;
    }

    public Airport sortListPlanesByMaximumSpeed() {
        listPlanes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaximumSpeedPlane()
                - o2.getMaximumSpeedPlane());
        return this;
    }

    public Airport sortListPlanesByMaximumLoadCapacity() {
        listPlanes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaximumLoadCapacityPlane()
                - o2.getMaximumLoadCapacityPlane());
        return this;
    }

    public List<ExperimentalPlane> getListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified () {
        return getListExperimentalPlanes()
                .stream()
                .filter(experimentalPlane -> experimentalPlane.getSecrecyLevelType() != SecrecyLevelType.UNCLASSIFIED)
                .collect(Collectors.toList());
    }
}
