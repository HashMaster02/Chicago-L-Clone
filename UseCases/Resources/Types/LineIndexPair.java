public class LineIndexPair {

    private TrainLines line;
    private int position;

    LineIndexPair(TrainLines t, int i) {
        this.position = i;
        this.line = t;
    }

    public void setLine(TrainLines t) {
        this.line = t;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public TrainLines getLine() {
        return this.line;
    }

    public int getPosition() {
        return this.position;
    }

}
