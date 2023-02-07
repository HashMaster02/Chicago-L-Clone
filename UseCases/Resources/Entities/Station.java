import java.util.ArrayList;
import java.util.Arrays;

public class Station {

    String name;
    float latitude;
    float longitude;
    String elevation;
    boolean accessibility;
    ArrayList<LineIndexPair> availableOn = new ArrayList<>();

    Station(String[] data)
    {
        this.name = data[0];
        this.latitude = Float.parseFloat(data[1]);
        this.longitude = Float.parseFloat(data[2]);
        this.elevation = data[3];
        this.accessibility = Boolean.parseBoolean(data[4]);
        setAvailableOn(getLinesFromData(data));
    }

    private void setAvailableOn(String[] lines) {

        for (String line: lines) {
            String color = line.replaceAll("\\d", "");
            Integer i = Integer.parseInt(line.replaceAll("[^0-9]", ""));
            switch (color) {
                case "Red": this.availableOn.add(new LineIndexPair(TrainLines.RED, i)); break;
                case "Green": this.availableOn.add(new LineIndexPair(TrainLines.GREEN, i)); break;
                case "Blue": this.availableOn.add(new LineIndexPair(TrainLines.BLUE, i)); break;
                case "Brown": this.availableOn.add(new LineIndexPair(TrainLines.BROWN, i)); break;
                case "Purple": this.availableOn.add(new LineIndexPair(TrainLines.PURPLE, i)); break;
                case "Pink": this.availableOn.add(new LineIndexPair(TrainLines.PINK, i)); break;
                case "Orange": this.availableOn.add(new LineIndexPair(TrainLines.ORANGE, i)); break;
            }
        }
    }

    private String[] getLinesFromData(String[] allData) {
        String[] slice = new String[allData.length - 5];
        System.arraycopy(allData, 5, slice, 0, slice.length);
        return slice;
    }

    public String toString() {

        return "Name: " + this.name + "\n" +
                "Longitude: " + this.longitude + "\n" +
                "Latitude: " + this.latitude + "\n" +
                "Elevation: " + this.elevation + "\n" +
                "Accessibility: " + isAccessible() + "\n" +
                "Available on: " + getAvailableOn();
    }

    private String isAccessible() {
        return (this.accessibility) ? ("Wheelchair-Accessible") : ("Not Wheelchair-Accessible");
    }

    private String getAvailableOn() {
        int size = this.availableOn.size();
        String[] l = new String[size];
        for (int i=0; i<size; i++) {
            l[i] = this.availableOn.get(i).getLine().name();
        }
        return Arrays.toString(l);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLatitude(int newLat) {
        this.latitude = newLat;
    }

    public void setLongitude(int newLong) {
        this.longitude = newLong;
    }

    public void setElevation(String newElevation) {
        this.elevation = newElevation;
    }

    public void thisAccessibility(boolean newAccess) {
        this.accessibility = newAccess;
    }

}
