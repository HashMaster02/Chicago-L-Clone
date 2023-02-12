public class Add {

    Train trainLine;
    SubwayMap map;

    Add(Train l, SubwayMap m)
    {
        this.trainLine = l;
        this.map = m;
    }

    public void newStation(String[] newStation, int pos) {
        this.trainLine.addStation(newStation[0], pos);
        map.addStation(newStation);
    }

    public void newStation(String[] newStation) {
        this.trainLine.addStation(newStation[0]);
        this.map.addStation(newStation);
    }

}