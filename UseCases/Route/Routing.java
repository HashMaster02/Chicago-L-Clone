import java.util.ArrayList;

public class Routing {

    SubwayMap map;
    Train[] trains;

    Routing(SubwayMap m, Train[] t)
    {
        this.map = m;
        this.trains = t;
    }

    public ArrayList<String> findRoute(String start, String end)
    {
        Station origin = this.map.getStationData(start);
        Station destination = this.map.getStationData(end);

        TrainLines service = null;

        for (TrainLines line: origin.availableOn)
        {
            if (destination.availableOn.contains(line))
            {
                service = line;
                break;
            }
        }

        if (service != null) {

            switch (service) {
                case RED:
                    return stationRoute(this.trains[0], origin.name, destination.name);
                case GREEN:
                    return stationRoute(this.trains[1], origin.name, destination.name);
                case BLUE:
                    return stationRoute(this.trains[2], origin.name, destination.name);
                case BROWN:
                    return stationRoute(this.trains[3], origin.name, destination.name);
                case PURPLE:
                    return stationRoute(this.trains[4], origin.name, destination.name);
                case PINK:
                    return stationRoute(this.trains[5], origin.name, destination.name);
                case ORANGE:
                    return stationRoute(this.trains[6], origin.name, destination.name);
            }
        }

        else
        {
            System.out.println("Station on different lines (now returning empty arraylist)");
        }

        return new ArrayList<>();
    }

    private ArrayList<String> stationRoute(Train t, String o, String d)
    {
        return t.getStationsInRange(t.getIndexOf(o), t.getIndexOf(d));
    }

}
