import java.util.ArrayList;

public class Update {

    Station station;

    Update()
    {
        this.station = null;
    }

    Update(Station s) {
        this.station = s;
    }

    public void indices(Train line, CTAMap map, int startIndex, int endIndex, int step) {
        ArrayList<String> stations = line.getStationsFrom(startIndex, endIndex);
        int newPos = startIndex;
        for (String station: stations) {
            Station current = map.getStationData(station).get(0);
            current.availableOn.get(0).setPosition(newPos);
            newPos += step;
        }
    }






}
