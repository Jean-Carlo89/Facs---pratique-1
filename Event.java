import java.time.LocalDateTime;
/* import java.io.Serializable; */

//implements Serializable 
public class Event {
    private String name;
    private String address;
    private EventType category;
    private LocalDateTime dateTime;
    private String description;
    // private static final long serialVersionUID = 1L; /// ** necessari para
    // serializar!!! versao 1 */

    public Event(String name, String address, EventType category, LocalDateTime dateTime, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EventType getCategory() {
        return category;
    }

    public void setCategory(EventType category) {
        this.category = category;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
