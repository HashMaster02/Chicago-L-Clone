import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoutingTest {

    @Test
    void findRoute_Forward() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Red", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Pulaski", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Conservatory-Central Park Drive", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Roosevelt", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Chicago", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Damian", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Jackson", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Island", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Pulaski", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Cermak Chinatown", "0.0", "1.1", "Elevated", "True", "Red"}
        };

        SubwayMap map = new SubwayMap(dummyData);
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Harlem", "Oak Park","Ridgeland","Austin", "Central", "Laramie",
                "Cicero","Pulaski", "Conservatory-Central Park Drive", "Roosevelt", "Chicago", "Damian", "Laramie", "Jackson"));
        Train myservice = new Train(names);
        Train[] allServices = {myservice};

        Routing gps = new Routing(map, allServices);

        ArrayList<String> finalRoute = gps.findRoute("Oak Park", "Roosevelt");

        String[] actual = {"Oak Park","Ridgeland","Austin", "Central", "Laramie",
                "Cicero","Pulaski", "Conservatory-Central Park Drive", "Roosevelt"};
        ArrayList<String> finalRouteActual = new ArrayList<>(Arrays.asList(actual));

        assertEquals(finalRouteActual, finalRoute);

    }

    @Test
    void findRoute_Backward() {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Red", "Green"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Red", "Green", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Cicero", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Pulaski", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Conservatory-Central Park Drive", "0.0", "1.1", "Elevated", "False", "Red", "Green", "Pink", "Blue"},
                {"Roosevelt", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Chicago", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Damian", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Laramie", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Jackson", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Island", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Pulaski", "0.0", "1.1", "Elevated", "True", "Red"},
                {"Cermak Chinatown", "0.0", "1.1", "Elevated", "True", "Red"}
        };

        SubwayMap map = new SubwayMap(dummyData);
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Harlem", "Oak Park","Ridgeland","Austin", "Central", "Laramie",
                "Cicero","Pulaski", "Conservatory-Central Park Drive", "Roosevelt", "Chicago", "Damian", "Laramie", "Jackson"));
        Train myservice = new Train(names);
        Train[] allServices = {myservice};

        Routing gps = new Routing(map, allServices);

        ArrayList<String> finalRoute = gps.findRoute("Jackson", "Pulaski");

        String[] actual = {"Jackson", "Laramie", "Damian", "Chicago", "Roosevelt", "Conservatory-Central Park Drive", "Pulaski"};
        ArrayList<String> finalRouteActual = new ArrayList<>(Arrays.asList(actual));

        assertEquals(finalRouteActual, finalRoute);

    }
}