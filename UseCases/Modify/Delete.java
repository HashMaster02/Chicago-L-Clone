public class Delete
{

    private SubwayMap map;

    Delete(SubwayMap m)
    {
        this.map = m;
    }

    public void station(String name, Train line)
    {
        line.deleteStation(name);

        if (this.map.getStationData(name) != null)
        {
            this.map.deleteStation(name);
        }
    }

}
