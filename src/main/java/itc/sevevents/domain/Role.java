package itc.sevevents.domain;

import javax.persistence.*;

@Entity
@Table
public class Role {
    Role() {
    }
    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }


}
