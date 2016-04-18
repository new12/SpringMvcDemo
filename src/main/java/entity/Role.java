package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kylong on 2016/4/18.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(
            name="role_privilege_relation",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns ={@JoinColumn(name="privilege_id")}
    )
    private Set<Privilege> privileges= new HashSet<Privilege>();
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
