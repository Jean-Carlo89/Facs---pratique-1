import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 14, 30);
        LocalDateTime date2 = LocalDateTime.of(2025, 3, 15, 14, 30);

        Event event1 = new Event("Teste", "Teste addr", EventType.Festas, date1,
                "Teste desc");
        manager.addEvent(event1);

    }
}