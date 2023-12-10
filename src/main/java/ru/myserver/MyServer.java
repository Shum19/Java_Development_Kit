package ru.myserver;
import java.sql.Connection;

public class MyServer {
    public static void main(String[] args) {
//        try {
//            Class.forName("org.mariadb.jdbc.Driver").getDeclaredConstructor().newInstance();
//            System.out.println("Connected");
//        }catch (Exception e) {
//            System.out.println("Connection Failed");
//            System.out.println(e);
//        }
        String str = "An aircraft \n" +
                "was maintaining\n" +
                " FL 410 over a thunderstorm when it \n" +
                "experienced\n" +
                " severe turbulence, and the number two engine \n" +
                "flamed out\n" +
                ". The aircraft \n" +
                "began\n" +
                " to descend and the flight crew \n" +
                "decided\n" +
                " to divert to a nearby airport. During the descent, the aircraft \n" +
                "encountered\n" +
                " large hail, heavy rain, severe turbulence and lightning. The number one engine \n" +
                "flamed out\n" +
                " from hail and water ingestion as the aircraft \n" +
                "was descending\n" +
                " through FL 330. Attempts to restart the engines \n" +
                "were\n" +
                " unsuccessful.\n" +
                "The aircraft \n" +
                "made\n" +
                " an emergency landing in a wheat field.\n" +
                "None of the seven passengers on board \n" +
                "were\n" +
                " injured. The two pilots also \n" +
                "escaped\n" +
                " injury. The aircraft \n" +
                "sustained\n" +
                " moderate to severe hail damage.\n" +
                "An investigation \n" +
                "determined\n" +
                " that the flight crew \n" +
                "had not obtained\n" +
                " a weather briefing before the flight, although a convective SIGMET and weather warnings were issued for the route of flight.";
        str = str.replace("\n", " ");
        String [] arr = str.split(" ");
        System.out.println(arr.length);
    }

}
