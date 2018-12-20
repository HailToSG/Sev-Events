package itc.sevevents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule_item")
@ToString(of = {"id", ""})
@EqualsAndHashCode(of = {"id"})
public class ScheduleItem {

    ScheduleItem(Event event) {
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_generator")
    @SequenceGenerator(
            name = "schedule_generator",
            sequenceName = "schedule_seq",
            initialValue = 1200000,
            allocationSize = 1)
    @Column(name = "schedule_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemTime;

    private String itemName;

    private String itemDescription;

    public LocalDateTime getItemTime() {
        return itemTime;
    }

    public void setItemTime(LocalDateTime itemTime) {
        this.itemTime = itemTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
