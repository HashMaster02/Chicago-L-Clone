import java.util.ArrayList;

public class LookUp {

    CTAMap map;

    LookUp(CTAMap m) {
        this.map = m;
    }

    public ArrayList<Station> lookFor(String name) {
        return map.getStationData(name);
    }

}
