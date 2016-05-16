package test;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by kylong on 2016/5/16.
 */
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Type {

    TYPE1(1,"Type A"),TYPE2(2,"Type B");

    private Integer id;
    private String name;
    private Type(final  Integer id, final String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
