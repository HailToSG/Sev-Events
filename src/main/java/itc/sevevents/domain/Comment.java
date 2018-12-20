package itc.sevevents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "comment")
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
public class Comment {
    public Comment(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commen_generator")
    @SequenceGenerator(
            name = "comment_generator",
            sequenceName = "comment_seq",
            initialValue = 1500000,
            allocationSize = 1)
    @Column(name = "comment_id", updatable = false, nullable = false)
    private Long id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated= now();

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id")
    private User user;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
