public class LookUp {

    SubwayMap map;

    LookUp(SubwayMap m) {
        this.map = m;
    }

    public String lookFor(String name) {
        if (this.map.getStationData(name) != null) {
            return map.getStationData(name).toString();
        }
        else {
            return "This station was not found.";
        }
    }

}
