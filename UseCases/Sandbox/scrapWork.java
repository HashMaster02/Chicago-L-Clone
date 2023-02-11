public class scrapWork {

    public static void main(String[] args) {
        String[][] dummyData = {
                {"Harlem", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Oak Park", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Ridgeland", "0.0", "1.1", "Elevated", "True", "Green"},
                {"Austin", "0.0", "1.1", "Elevated", "True", "Green"}};
        SubwayMap cta = new SubwayMap(dummyData);
        System.out.println(cta.getStationData("Pulaski"));
    }
}
