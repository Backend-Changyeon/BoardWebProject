package BoardWeb.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ViewMapper {
    @Select(value = "SELECT viewed_at FROM view_record WHERE board_id = #{board_id} AND user_id = #{user_id}")
    public Timestamp getViewed_at(@Param("board_id") Long board_id, @Param("user_id") Long user_id);

    @Insert(value = "INSERT INTO view_record(board_id, user_id) VALUES(#{board_id}, #{user_id})")
    public void insertViewed_at(@Param("board_id") Long board_id, @Param("user_id") Long user_id);

    @Update(value = "UPDATE view_record SET viewed_at=now() WHERE board_id = #{board_id} AND user_id = #{user_id}")
    public void setViewed_at(@Param("board_id") Long board_id, @Param("user_id") Long user_id);
}
