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
        Add add = new Add(map);
        add.newStation(input, train);

        String[] newNames = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski"};
        ArrayList<String> expectedLine = new ArrayList<>(Arrays.asList(newNames));
        Station expectedData = new Station(input);

        assertEquals(expectedLine, train.getAllStations());
        assertEquals(expectedData.toString(), map.getStationData("Pulaski").toString());
        assertNotNull(map.getStationData("Pulaski"));
    }

    @Test
    void newStationAtIndex() {
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
        Add add = new Add(map);
        add.newStation(input, train, 4);

        String[] newNames = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Pulaski", "Central", "Laramie", "Cicero"};
        ArrayList<String> expectedLine = new ArrayList<>(Arrays.asList(newNames));
        Station expectedData = new Station(input);

        assertEquals(expectedLine, train.getAllStations());
        assertEquals(expectedData.toString(), map.getStationData("Pulaski").toString());
        assertNotNull(map.getStationData("Pulaski"));
    }

    @Test
    void newStationToMultipleLines()
    {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Roosevelt", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Chicago", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Damian", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Jackson", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Island", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Pulaski", "0.0", "1.1", "Elevated", "True", "Red"},
        };
        String[] namesGreen = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero"};
        String[] namesRed = {"Roosevelt", "Chicago", "Damian", "Laramie", "Jackson", "Island", "Pulaski"};

        ArrayList<String> forGreenline = new ArrayList<>(Arrays.asList(namesGreen));
        ArrayList<String> forRedline = new ArrayList<>(Arrays.asList(namesRed));
        SubwayMap map = new SubwayMap(dummyData);
        Train greenline = new Train(forGreenline);
        Train redline = new Train(forRedline);


        Add adding = new Add(map);
        String[] newStation = {"Cermak Chinatown", "0.0", "1.1", "Elevated", "True", "Red", "Green"};
        adding.newStation(newStation, greenline);
        adding.newStation(newStation, redline, 3);


        assertEquals(Arrays.asList("Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Cermak Chinatown"),
                greenline.getAllStations());
        assertEquals(Arrays.asList("Roosevelt", "Chicago", "Damian", "Cermak Chinatown", "Laramie", "Jackson", "Island", "Pulaski"),
                redline.getAllStations());
        assertEquals(new Station(newStation).toString(), map.getStationData("Cermak Chinatown").toString());
    }
}