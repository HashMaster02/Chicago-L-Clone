import java.util.ArrayList;

public class Add {

    String[] input;

    Add(String[] userInput) {
        this.input = userInput;
    }

    public void newStation(Train line, CTAMap map, int pos) {
        line.addStation(pos, this.input[0]);
        map.addStation(this.input);
        Update update = new Update();
        update.indices(line, map, pos+1, line.totalStations, 1);
    }

    public void newStation(Train line, CTAMap map) {
        line.addStation(this.input[0]);
        map.addStation(this.input);
    }

}
