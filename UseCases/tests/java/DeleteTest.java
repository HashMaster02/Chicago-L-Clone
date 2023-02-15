import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTest {

    @Test
    void station()
    {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList("Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie", "Cicero"));
        SubwayMap map = new SubwayMap(dummyData);
        Train train = new Train(forTrain);

        Delete delete = new Delete(map);
        delete.station("Central", train);

        assertNull(map.getStationData("Central"));
        assertEquals(new ArrayList<>(Arrays.asList("Harlem", "Oak Park", "Ridgeland", "Austin", "Laramie", "Cicero")), train.getAllStations());

    }

    @Test
    void stationFromMultipleLines()
    {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Green", "Pink", "Blue"}};
        ArrayList<String> forGreenTrain = new ArrayList<>(Arrays.asList("Harlem", "Oak Park", "Laramie", "Ridgeland"));
        ArrayList<String> forRedTrain = new ArrayList<>(Arrays.asList("Austin", "Central", "Laramie", "Cicero"));
        SubwayMap map = new SubwayMap(dummyData);
        Train greenline = new Train(forGreenTrain);
        Train redline = new Train(forRedTrain);

        Delete delete = new Delete(map);
        delete.station("Laramie", greenline);
        delete.station("Laramie", redline);

        assertNull(map.getStationData("Laramie"));
        assertEquals(new ArrayList<>(Arrays.asList("Harlem", "Oak Park", "Ridgeland")), greenline.getAllStations());
        assertEquals(new ArrayList<>(Arrays.asList("Austin", "Central", "Cicero")), redline.getAllStations());

    }

}