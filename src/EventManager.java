import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;

public class EventManager {

        ArrayList<Event> events = new ArrayList<>(); // this will store the Events so the program don't forget the previous events.

    public void addEvent(Event event) {
        events.add(event);


    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public String viewEvents(){
        String result = " ";
        for (Event event : events){
            result = result + event + "\n\n";
        }
        return result;
    }

    public void deleteEvent(Event event) {
        events.remove(event);
    }

    public void saveEvents(){
        try{
            FileWriter writer = new FileWriter("Events.txt");

            for (Event event : events){
                writer.write(
                        event.getEventName() + "|" +
                        event.getLocation() + "|" +
                        event.getEventDate() + "|" +
                        event.getFamilyMemberNumber()
            );
                writer.write("\n");

            }

            writer.close();
            System.out.println("Events saved Writer!");

            }catch (Exception ex) {
            System.out.println("Save failed");
            System.out.println(ex.getMessage());

        }

        }
        public void loadEvents() {
            try {
                FileReader FileReader = new FileReader("Events.txt");
                BufferedReader reader = new BufferedReader(FileReader);
                String line;

                while(( line = reader.readLine()) != null){

                    String[] data = line.split("\\|");

                    String eventName = data[0];
                    String location = data[1];
                    String eventDate = data[2];
                    int familyMemberNumber = Integer.parseInt(data[3]);

                    Event event = new Event(
                            eventName,
                            location,
                            eventDate,
                            familyMemberNumber
                    );
                    events.add(event);

                    System.out.println("Loaded event: " + event);
                    System.out.println("Number of events: " + events.size());
                }
                reader.close();

            }catch (Exception ex){
                System.out.println("File failed");
                System.out.println(ex.getMessage());
            }
        }



    public void searchName (String name){

        for (Event event : events) {

            if (event.getEventName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(
                        null,
                        event.toString(),
                        "Search Result",
                        JOptionPane.PLAIN_MESSAGE
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(
                null,
                "No event found with that name.",
                "Search Result",
                JOptionPane.PLAIN_MESSAGE
        );

        }


    public void searchLocation (String location){
    for (Event event : events) {

        if (event.getLocation().equalsIgnoreCase(location)) {
        JOptionPane.showMessageDialog(
                        null,
                        event.toString(),
                        "Search Result",
                JOptionPane.PLAIN_MESSAGE
                );
                        return;
                        }
                        }
                        JOptionPane.showMessageDialog(
                null,
                        "No event found with that location.",
                        "Search Result",
                JOptionPane.PLAIN_MESSAGE
                );

        }


      public void searchDate (String date) {


          for (Event event : events) {
              if (event.getEventDate().equalsIgnoreCase(date)) {

                  JOptionPane.showMessageDialog(
                          null,
                          event.toString(),
                          "Search Result",
                          JOptionPane.PLAIN_MESSAGE
                  );


              }
          }
          JOptionPane.showMessageDialog(
                  null,
                  "No event found with that date.",
                  "Search Result",
                  JOptionPane.PLAIN_MESSAGE
          );
      }

}











