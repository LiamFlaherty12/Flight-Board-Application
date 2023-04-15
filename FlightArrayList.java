import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.lang.String;
public class FlightArrayList {


    enum EngineType {Jet, Rocket, Electric, TurboProp, Piston};
    static class AircraftType {
        String manufacturer;
        String model;
        String typeDesignator;
        FlightArrayList.EngineType engineType;
        int engineNumber;

        public AircraftType(String manufacturer, String model, String typeDesignator, FlightArrayList.EngineType engineType, int engineNumber) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.typeDesignator = typeDesignator;
            this.engineType = engineType;
            this.engineNumber = engineNumber;
        }
        public String toString(){
            return  "A/C " + manufacturer +
                    " " + model +
                    " " + typeDesignator +
                    " " + engineType +
                    " " + engineNumber;
        }
    }

    static class Flight {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        private String airline;
        private String flightNumber;
        private String origin;
        private FlightArrayList.AircraftType aircraftType;
        private String destination;
        private Date scheduledDeparture;
        private Date scheduledArrival;
        private String gate;

        public Flight (String airline,String flightNumber, String origin,  String destination,
                       FlightArrayList.AircraftType aircraftType, Date scheduledDeparture, Date scheduledArrival, String gate){

            this.airline = airline;
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.scheduledDeparture = scheduledDeparture;
            this.scheduledArrival = scheduledArrival;
            this.aircraftType = aircraftType;
            this.gate = gate;

        }
        public String toString(){
            return airline + " " + flightNumber + " " + origin + "/" + destination + " Departs: " + sdf.format(scheduledDeparture) +
                    " Arrives: " + sdf.format(scheduledArrival) + " " + aircraftType.toString() + " Gate: " + gate;

        }

    }
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        ArrayList<Flight> flight = new ArrayList<>();
        ArrayList<AircraftType> airType = new ArrayList<>();

        airType.add(new AircraftType("Boeing","737-600","B736", EngineType.Jet, 2));
        flight.add(new Flight("UA", "101", "PHL", "LA", airType.get(0), sdf.parse("1-28-2021 06:00"), sdf.parse("1-28-2021 18:30"), "B20"));

        airType.add(new AircraftType("Airbus", "A320", "A320", EngineType.TurboProp, 2));
        airType.add(new AircraftType("Boeing", "777-300", "B77W", EngineType.Jet, 2));

        flight.add(new Flight("AA", "202", "LAX", "NYC", airType.get(0), sdf.parse("1-29-2021 08:00"), sdf.parse("1-29-2021 16:00"), "C10"));
        flight.add(new Flight("DL", "305", "ATL", "MIA", airType.get(1), sdf.parse("1-30-2021 12:00"), sdf.parse("1-30-2021 15:00"), "A4"));

        airType.add(new AircraftType("Embraer", "E175", "E175", EngineType.TurboProp, 2));
        airType.add(new AircraftType("Airbus", "A330", "A330", EngineType.Jet, 4));

        flight.add(new Flight("BA", "245", "LHR", "HKG", airType.get(2), sdf.parse("1-31-2021 14:30"), sdf.parse("2-1-2021 05:30"), "D5"));
        flight.add(new Flight("JAL", "21", "NRT", "LAX", airType.get(3), sdf.parse("2-1-2021 11:00"), sdf.parse("2-1-2021 08:00"), "G9"));



        for (Flight f : flight) {
            System.out.println(f);
        }


    }
}
