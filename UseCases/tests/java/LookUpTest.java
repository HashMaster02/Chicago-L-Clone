import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookUpTest {

    @Test
    void lookFor_whenExists() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"}};
        SubwayMap map = new SubwayMap(dummyData);
        LookUp search = new LookUp(map);

        Station expected = new Station(dummyData[0]);

        assertEquals(expected.toString(), search.lookFor("Harlem"));
    }

    @Test
    void lookFor_whenNotExists() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"}};
        SubwayMap map = new SubwayMap(dummyData);
        LookUp search = new LookUp(map);

        assertEquals("This station was not found.", search.lookFor("Cicero"));
    }
}