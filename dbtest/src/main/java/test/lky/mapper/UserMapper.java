package test.lky.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.lky.model.User;

/**
 * Created by kylong on 2016/10/6.
 */
public interface UserMapper {
    @Select("SELECT * From user where id=#{userId}")
    User getUser(@Param("userId") Integer userId);
}
