package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kylong on 2016/4/18.
 */
@Entity
@Table(name = "privilege")
public class Privilege implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String value;
    @ManyToOne
    @JoinColumn(name = "domain_id",nullable = false)
    private Domain domain;
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles = new HashSet<Role>();

    @Override
    public String getAuthority() {
        return domain.getName()+"_"+value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Privilege)) return  false;
        Privilege other = (Privilege) obj;
        return id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Integer getId(){
        return  id;
    }
}
