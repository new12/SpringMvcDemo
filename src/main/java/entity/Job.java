package entity;

import javax.persistence.*;

/**
 * Created by kylong on 2016/4/24.
 */
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Job() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
