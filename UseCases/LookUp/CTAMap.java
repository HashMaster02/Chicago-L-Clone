import java.util.ArrayList;
import java.util.HashMap;

public class CTAMap {

    private HashMap<String, ArrayList<Station>> stationInfo;

    CTAMap(String[][] allStations) {
        stationInfo = new HashMap<>();
        for (String[] data: allStations) {
            addStation(data);
        }
    }

    public void addStation(String[] stationData) {
        Station station = new Station(stationData);
        if (this.stationInfo.containsKey(station.name))
            this.stationInfo.get(station.name).add(station);
        else {
            this.stationInfo.put(station.name, new ArrayList<>());
            this.stationInfo.get(station.name).add(station);
        }
    }

    public ArrayList<Station> getStationData(String name) {
        return this.stationInfo.get(name);
    }

}
