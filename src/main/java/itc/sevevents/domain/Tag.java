package itc.sevevents.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class Tag {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_generator")
    @SequenceGenerator(
            name="tag_generator",
            sequenceName = "tag_seq",
            initialValue = 1700000,
            allocationSize = 1)
    @Column(name = "tag_id", updatable = false, nullable = false)
    Long id;

    private String fullDescription;
    private String shortDescription;

    @ManyToMany(mappedBy = "tags")
    private Set<Event> events = new HashSet<>();
}
