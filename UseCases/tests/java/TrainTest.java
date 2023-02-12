import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void addStation() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski", "Conservatory-Central Park Drive"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);
        train.addStation("Roosevelt");

        String[] newNames = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski",
                            "Conservatory-Central Park Drive", "Roosevelt"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(newNames));

        assertEquals(expected, train.getAllStations());
        assertEquals(forTrain.size(), train.totalStations);
    }

    @Test
    void addStationAtIndex() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski", "Conservatory-Central Park Drive"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);
        train.addStation("Roosevelt", 4);

        String[] newNames = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Roosevelt", "Central", "Laramie", "Cicero", "Pulaski",
                "Conservatory-Central Park Drive"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(newNames));

        assertEquals(expected, train.getAllStations());
        assertEquals(forTrain.size(), train.totalStations);
    }

    @Test
    void movePosition() {

        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);
        train.movePosition("Harlem", forTrain.size()-1);

        String[] newNames = {"Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski", "Harlem"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(newNames));

        assertEquals(expected, train.getAllStations());
        assertEquals(forTrain.size(), train.totalStations);
    }

    @Test
    void deleteStation() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Roosevelt", "Austin"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);
        train.deleteStation("Ridgeland");

        String[] newNames = {"Harlem", "Oak Park", "Roosevelt", "Austin"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(newNames));

        assertEquals(expected, train.getAllStations());
        assertEquals(forTrain.size(), train.totalStations);
    }

    @Test
    void getStation() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski", "Conservatory-Central Park Drive"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);

        assertEquals("Austin", train.getStation(3));
    }

    @Test
    void getStationsInRange() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);

        ArrayList<String> rtrn = train.getStationsInRange(2, 6);
        String[] newNames = {"Ridgeland", "Austin", "Central", "Laramie"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(newNames));

        assertEquals(rtrn, expected);
    }

    @Test
    void getAllStations() {
        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero", "Pulaski"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));

        Train train = new Train(forTrain);

        assertEquals(train.getAllStations(), forTrain);
    }
}