public class Add {

    SubwayMap map;

    Add(SubwayMap m)
    {
        this.map = m;
    }

    public void newStation(String[] newStation, Train line, int pos) {
        line.addStation(newStation[0], pos);

        if (this.map.getStationData(newStation[0]) == null) {
            this.map.addStation(newStation);
        }
    }

    public void newStation(String[] newStation, Train line) {
        line.addStation(newStation[0]);

        if (this.map.getStationData(newStation[0]) == null) {
            this.map.addStation(newStation);
        }
    }

}