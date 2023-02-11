import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void isAccessible() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        String[] data2 = {"Cicero", "0.0", "1.1", "Elevated", "False", "Green"};
        Station station1 = new Station(data1);
        Station station2 = new Station(data2);

        assertEquals("Wheelchair-Accessible", station1.isAccessible());
        assertEquals("Not Wheelchair-Accessible", station2.isAccessible());
    }

    @Test
    void setName() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station station1 = new Station(data1);

        station1.setName("Cicero");
        assertEquals("Cicero", station1.name);
    }

    @Test
    void setLatitude() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station station1 = new Station(data1);

        station1.setLatitude(1.2f);
        assertEquals(1.2f, station1.latitude);
    }

    @Test
    void setLongitude() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station station1 = new Station(data1);

        station1.setLongitude(1.2f);
        assertEquals(1.2f, station1.longitude);
    }

    @Test
    void setElevation() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station station1 = new Station(data1);

        station1.setElevation("Subway");
        assertEquals("Subway", station1.elevation);
    }

    @Test
    void setAccessibility() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"};
        Station station1 = new Station(data1);

        station1.setAccessibility(false);
        assertFalse(station1.accessibility);
    }

    @Test
    void checkLines() {
        String[] data1 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Green", "Pink"};
        Station station1 = new Station(data1);
        ArrayList<TrainLines> expected1 = new ArrayList<>();
        expected1.add(TrainLines.GREEN);
        expected1.add(TrainLines.PINK);

        String[] data2 = {"Harlem", "0.0", "1.1", "Elevated", "True", "Brown", "Purple", "Red"};
        Station station2 = new Station(data2);
        ArrayList<TrainLines> expected2 = new ArrayList<>();
        expected2.add(TrainLines.BROWN);
        expected2.add(TrainLines.PURPLE);
        expected2.add(TrainLines.RED);

        assertEquals(expected1, station1.availableOn);
        assertEquals(expected2, station2.availableOn);
    }
}