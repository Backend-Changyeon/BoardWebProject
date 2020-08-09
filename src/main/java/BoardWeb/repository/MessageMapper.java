package BoardWeb.repository;

import BoardWeb.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Select(value = "SELECT * FROM message WHERE to_user_id=#{to_user_id}")
    List<Message> getMyMessage(@Param("to_user_id") Long to_user_id);

    @Insert(value = "INSERT INTO message(from_user_id, to_user_id, content) VALUES(#{from_user_id}, #{to_user_id}, #{content})")
    void sendMessage(@Param("from_user_id") Long from_user_id, @Param("to_user_id") Long to_user_id, @Param("content") String content);
}
