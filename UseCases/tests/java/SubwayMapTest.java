import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubwayMapTest {

    @Test
    void addStation() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};

        SubwayMap map = new SubwayMap(dummyData);

        String[] newStation = {"Pulaski", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"};
        map.addStation(newStation);
        Station obj = new Station(newStation);

        assertEquals(obj.toString(), map.getStationData("Pulaski").toString());
    }

    @Test
    void getStationData_whenExist() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};

        SubwayMap map = new SubwayMap(dummyData);

        String[] newStation = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station obj = new Station(newStation);

        assertEquals(obj.toString(), map.getStationData("Harlem").toString());

    }

    @Test
    void getStationData_whenNotExist() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};

        SubwayMap map = new SubwayMap(dummyData);

        assertNull(map.getStationData("Pulaski"));

    }
}