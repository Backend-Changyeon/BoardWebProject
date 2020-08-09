package BoardWeb.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select(value = "SELECT id FROM users WHERE account = #{account}")
    Long getUserId(@Param("account") String account);

    @Select(value = "SELECT id FROM users WHERE nick_name = #{nick_name}")
    Long getUserIdFromNickName(@Param("nick_name") String nick_name);

    @Select(value = "SELECT nick_name FROM users WHERE id = #{id}")
    String getUserNickNameFromId(@Param("id") Long id);

    @Select(value = "SELECT password FROM users WHERE account = #{account}")
    String getPassword(@Param("account") String account);

    @Select(value = "SELECT account FROM users WHERE nick_name = #{nick_name}")
    String getAccount(@Param("nick_name") String nick_name);

    @Select(value = "SELECT nick_name FROM users WHERE account = #{account}")
    String getNick_name(@Param("account") String account);

    @Select(value = "SELECT id FROM users WHERE nick_name = #{nick_name}")
    Long checkNick_name(@Param("nick_name") String nick_name);

    @Insert(value = "INSERT INTO users(account, password, nick_name) VALUES(#{account}, #{password}, #{nick_name}) ")
    void insertUser(@Param("account") String account, @Param("password") String password, @Param("nick_name") String nick_name);


}

