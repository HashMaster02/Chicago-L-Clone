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

    public void addStation(int i, String name) {
        this.stations.add(i, name);
        this.totalStations++;
    }

    public void movePosition(String n, int oldIdx, int newIdx) {
        this.stations.remove(oldIdx);
        this.stations.add(newIdx, n);
    }

    public void deleteStation(int i) {
        this.stations.remove(i);
        this.totalStations--;
    }

    public String getStation(int i) {
        return this.stations.get(i);
    }

    public ArrayList<String> getStationsFrom(int start, int end) {
        ArrayList<String> slice = new ArrayList<>();

        for (int i=start; i < end; i++) {
            slice.add(this.stations.get(i));
        }

        return slice;
    }

    public ArrayList<String> getAllStations() {
        return this.stations;
    }

    public String toString() {
        return this.stations.toString();
    }

}
