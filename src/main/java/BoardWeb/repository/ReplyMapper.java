package BoardWeb.repository;

import BoardWeb.domain.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMapper {
    @Select(value = "SELECT * from reply WHERE board_id=#{board_id} AND deleted=0")
    List<Reply> viewReply(@Param("board_id") Long board_id);

    @Select(value = "SELECT board_id from reply WHERE id=#{id}")
    Long getBoard_id(@Param("id") Long id);

    @Select(value = "SELECT * from reply WHERE id=#{id}")
    List<Reply> getReply(@Param("id") Long id);

    @Insert(value = "INSERT INTO reply(board_id, user_id, nick_name, content) values(#{board_id}, #{user_id}, #{nick_name}, #{content})")
    void writeReply(Reply reply);

    @Update(value = "UPDATE reply SET deleted=1 WHERE id=#{id}")
    void deleteReply(@Param("id") Long id);

    @Update(value = "UPDATE reply SET content=#{content} WHERE id=#{id}")
    void modifyReply(Reply reply);

    @Select(value = "SELECT user_id FROM reply WHERE id=#{id}")
    Long getUserId(@Param("id") Long id);
}
