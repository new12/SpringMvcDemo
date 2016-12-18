package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kylong on 2016/11/9.
 */
public class User {
    private int id;
    @JsonIgnore
    private String name;
    private String password;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @JsonProperty("getAddr")
    public String getAddress() {
        return address;
    }
    @JsonProperty("addr")
    public void setAddress(String address) {
        this.address = address;
    }
}
