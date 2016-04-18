package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kylong on 2016/4/18.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private Set<Role> Role = new HashSet<entity.Role>();
}
