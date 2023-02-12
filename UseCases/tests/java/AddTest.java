import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    @Test
    void newStation() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));
        SubwayMap map = new SubwayMap(dummyData);
        Train train = new Train(forTrain);

        String[] input = {"Pulaski", "0.0", "1.1", "Elevated", "False", "Green", "Brown"};
        Add add = new Add(train, map);
        add.newStation(input);

        String[] newNames = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski"};
        ArrayList<String> expectedLine = new ArrayList<>(Arrays.asList(newNames));
        Station expectedData = new Station(input);

        assertEquals(expectedLine, train.getAllStations());
        assertEquals(expectedData.toString(), map.getStationData("Pulaski").toString());
        assertNotNull(map.getStationData("Pulaski"));
    }
}