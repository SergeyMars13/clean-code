import airplanes.ExperimentalPlane;
import classifications.SecrecyLevelType;
import classifications.ExperimentalPlaneType;
import classifications.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.Test;
import airplanes.MilitaryPlane;
import airplanes.PassengerPlane;
import airplanes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, SecrecyLevelType.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, SecrecyLevelType.TOP_SECRET)
    );

    private static PassengerPlane expectedPlaneWithMaximumSeatingCapacityPassenger = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private static List<MilitaryPlane> expectedListMilitaryPlanesTransportType = Arrays.asList(
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT)
    );
    private static List<MilitaryPlane> expectedListMilitaryPlanesBomberType = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER)
    );
    private static List<ExperimentalPlane> expectedListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified  = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, SecrecyLevelType.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, SecrecyLevelType.TOP_SECRET)
    );


    @Test
    public void testHasListOnlyMilitaryPlanesWithTransportType() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> actualListMilitaryPlanesTransportType = airport
                .getListMilitaryPlanesTransportType();
        Assert.assertEquals(actualListMilitaryPlanesTransportType, expectedListMilitaryPlanesTransportType);
    }

    @Test
    public void testReceivedPassengerPlaneIsObjectWithMaximumSeatingCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane actualPlaneWithMaximumSeatingCapacityPassenger = airport
                .getPassengerPlaneWithMaximumSeatingCapacity();
        Assert.assertEquals(actualPlaneWithMaximumSeatingCapacityPassenger
                , expectedPlaneWithMaximumSeatingCapacityPassenger);
    }

    @Test
    public void testSortListPlanesByMaximumLoadCapacity() {
        Airport airport = new Airport(planes);
        List<? extends Plane> listPlanesSortedByMaximumLoadCapacity = airport
                .sortListPlanesByMaximumLoadCapacity()
                .getListPlanes();
        for (int i = 0; i < listPlanesSortedByMaximumLoadCapacity.size() - 1; i++) {
            Assert.assertTrue(listPlanesSortedByMaximumLoadCapacity.get(i).getMaximumLoadCapacityPlane()
                    <= listPlanesSortedByMaximumLoadCapacity.get(i + 1).getMaximumLoadCapacityPlane());
        }
    }

    @Test
    public void testHasListOnlyMilitaryPlanesWithBomberType() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> actualListMilitaryPlanesBomberType = airport.getListMilitaryPlanesBomberType();
        Assert.assertEquals(actualListMilitaryPlanesBomberType, expectedListMilitaryPlanesBomberType);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> actualListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified = airport
                .getListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified();
        Assert.assertEquals(actualListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified
                , expectedListExperimentalPlanesWithSecrecyLevelTypeHigherThanUnclassified);
    }
}