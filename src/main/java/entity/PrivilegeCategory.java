package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kylong on 2016/4/18.
 */
@Entity
@Table(name = "privilege_category")
public class PrivilegeCategory {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @OneToMany(mappedBy = "privilegeCategory")
    private Set<Privilege> privileges = new HashSet<Privilege>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
