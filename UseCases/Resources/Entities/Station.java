import java.util.ArrayList;

public class Station {

    String name;
    float latitude;
    float longitude;
    String elevation;
    boolean accessibility;
    ArrayList<TrainLines> availableOn = new ArrayList<>();

    Station(String[] data)
    {
        setName(data[0]);
        setLatitude(Float.parseFloat(data[1]));
        setLongitude(Float.parseFloat(data[2]));
        setElevation(data[3]);
        setAccessibility(Boolean.parseBoolean(data[4]));
        setAvailableOn(getLinesFromData(data));
    }

    private void setAvailableOn(String[] lines) {

        for (String line: lines) {
            switch (line) {
                case "Red": this.availableOn.add(TrainLines.RED); break;
                case "Green": this.availableOn.add(TrainLines.GREEN); break;
                case "Blue": this.availableOn.add(TrainLines.BLUE); break;
                case "Brown": this.availableOn.add(TrainLines.BROWN); break;
                case "Purple": this.availableOn.add(TrainLines.PURPLE); break;
                case "Pink": this.availableOn.add(TrainLines.PINK); break;
                case "Orange": this.availableOn.add(TrainLines.ORANGE); break;
            }
        }
    }

    private String[] getLinesFromData(String[] allData) {
        String[] slice = new String[allData.length - 5];
        System.arraycopy(allData, 5, slice, 0, slice.length);
        return slice;
    }

    public String isAccessible() {
        return (this.accessibility) ? ("Wheelchair-Accessible") : ("Not Wheelchair-Accessible");
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLatitude(float newLat) {
        this.latitude = newLat;
    }

    public void setLongitude(float newLong) {
        this.longitude = newLong;
    }

    public void setElevation(String newElevation) {
        this.elevation = newElevation;
    }

    public void setAccessibility(boolean newAccess) {
        this.accessibility = newAccess;
    }

    public String toString() {

        return "Name: " + this.name + "\n" +
                "Longitude: " + this.longitude + "\n" +
                "Latitude: " + this.latitude + "\n" +
                "Elevation: " + this.elevation + "\n" +
                "Accessibility: " + isAccessible() + "\n" +
                "Available on: " + this.availableOn;
    }

}
