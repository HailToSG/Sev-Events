package itc.sevevents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.time.LocalDateTime.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "usr")
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class User {
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_generator")
    @SequenceGenerator(
            name = "usr_generator",
            sequenceName = "usr_seq",
            initialValue = 1300000,
            allocationSize = 1)
    @Column(name = "usr_id", updatable = false, nullable = false)
    private String id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated = now();

    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;
    private LocalDateTime lastVisit;
    private String password;
    private boolean isActive;

    @ManyToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "usr_role",
            joinColumns = {@JoinColumn(name = "usr_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = EAGER)
    private Set<Comment> comments = new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Favor> getLikes() {
        return likes;
    }

    public void setLikes(Set<Favor> likes) {
        this.likes = likes;
    }

    @OneToMany(mappedBy = "user", fetch = EAGER)
    private Set<Favor> likes = new HashSet<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserpic() {
        return userpic;
    }
    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public LocalDateTime getLastVisit() {
        return lastVisit;
    }
    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return name;
    }
    public void setUsername(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
