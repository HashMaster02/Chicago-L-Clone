import java.util.ArrayList;

public class Train {

    private ArrayList<String> stations;
    public int totalStations;

    Train(ArrayList<String> data, int t) {
        this.stations = data;
        this.totalStations = t;
    }

    public void addStation(String name) {
        this.stations.add(name);
        this.totalStations++;
    }

    public void addStation(String name, int i) {
        this.stations.add(i, name);
        this.totalStations++;
    }

    public void movePosition(String n, int newIdx) {
        this.stations.remove(n);
        this.stations.add(newIdx, n);
    }

    public void deleteStation(String n) {
        this.stations.remove(n);
        this.totalStations--;
    }

    public String getStation(int i) {
        return this.stations.get(i);
    }

    public ArrayList<String> getStationsInRange(int start, int end) {
        ArrayList<String> slice = new ArrayList<>();

        for (int i=start; i < end; i++) {
            slice.add(this.stations.get(i));
        }

        return slice;
    }

    public ArrayList<String> getAllStations() {
        return this.stations;
    }

}
