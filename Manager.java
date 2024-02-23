import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Event> events;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Manager() {
        this.events = new ArrayList<>();
        loadEvents();
    }

    public void addEvent(Event event) {
        events.add(event);
        saveEvents();
    }

    private void saveEvents() {
        try (PrintWriter out = new PrintWriter(new FileWriter("events.data"))) {
            for (Event event : events) {
                out.println(eventToCsvLine(event));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String eventToCsvLine(Event event) {
        return String.join(",",
                event.getName(),
                event.getAddress(),
                event.getCategory().toString(),
                event.getDateTime().format(formatter),
                event.getDescription());
    }

    private void loadEvents() {
        File file = new File("events.data");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Event event = csvLineToEvent(line);
                    if (event != null) {
                        events.add(event);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Event csvLineToEvent(String line) {
        String[] data = line.split(",");
        if (data.length == 5) {
            String name = data[0];
            String address = data[1];
            EventType category = EventType.valueOf(data[2]);
            LocalDateTime dateTime = LocalDateTime.parse(data[3], formatter);
            String description = data[4];
            return new Event(name, address, category, dateTime, description);
        }
        return null;
    }
}
