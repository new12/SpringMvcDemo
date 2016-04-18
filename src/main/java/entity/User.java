package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kylong on 2016/4/18.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(
            name="user_role_relation",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name="role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
