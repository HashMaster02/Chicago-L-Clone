import java.util.HashMap;

public class SubwayMap {

    private HashMap<String, Station> stationInfo;

    SubwayMap(String[][] allStations) {
        stationInfo = new HashMap<>();
        for (String[] data: allStations) {
            addStation(data);
        }
    }

    public void addStation(String[] stationData) {
        Station station = new Station(stationData);
        this.stationInfo.put(station.name, station);
    }

    public Station getStationData(String name) {
        return this.stationInfo.get(name);
    }

}
