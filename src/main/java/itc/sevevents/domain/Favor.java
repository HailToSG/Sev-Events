package itc.sevevents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.*;

@Entity
@Table(name = "favor")
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class Favor {
    Favor(User user){
        this.user = user;
        this.dateCreated = now();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favor_generator")
    @SequenceGenerator(
            name="favor_generator",
            sequenceName = "favor_seq",
            initialValue = 1600000,
            allocationSize = 1)
    @Column(name = "favor_id", updatable = false, nullable = false)
    private Long id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    final private LocalDateTime dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public User getUser() {
        return user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id")
    final private User user;
}
