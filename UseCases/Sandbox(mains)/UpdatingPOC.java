import java.util.ArrayList;
import java.util.Arrays;

public class UpdatingPOC {

    public static void main(String[] args) {
        // ------------------------------Dummy Data------------------------------------------
        String[][] forMap= {{"Harlem", "0.0", "1.1", "Elevated", "True", "Green0"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green1"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green2"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green3"},
                {"Central", "0.0", "1.1", "Elevated", "True", "Green4", "Red6"},
                {"Laramie", "0.0", "1.1", "Elevated", "False", "Green5", "Pink4", "Blue19"}};

        String[] names = {"Harlem", "Oak Park", "Ridgeland", "Austin", "Central", "Laramie"};
        ArrayList<String> forTrain = new ArrayList<>(Arrays.asList(names));
        // -----------------------------------------------------------------------------------

        // setup
        CTAMap cta = new CTAMap(forMap);
        Train greenLine = new Train(forTrain, names.length);

        //Updating
        String[] userInput = new String[]{"Cicero", "0.0", "1.1", "Elevated", "False", "Green1"};
        Add add = new Add(userInput);
        add.newStation(greenLine, cta, 1);

        System.out.println(greenLine.getAllStations());
        System.out.println(cta.getStationData("Oak Park").get(0).availableOn.get(0).getPosition());
        System.out.println(cta.getStationData("Ridgeland").get(0).availableOn.get(0).getPosition());
        System.out.println(cta.getStationData("Austin").get(0).availableOn.get(0).getPosition());
        System.out.println(cta.getStationData("Central").get(0).availableOn.get(0).getPosition());
        System.out.println(cta.getStationData("Laramie").get(0).availableOn.get(0).getPosition());


    }

}
