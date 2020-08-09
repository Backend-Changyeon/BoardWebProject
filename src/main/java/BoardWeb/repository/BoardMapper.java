package BoardWeb.repository;

import BoardWeb.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    @Select(value = "SELECT * FROM board WHERE deleted=0 ORDER BY id DESC")
    List<Board> getBoardList();

    @Select(value = "SELECT COUNT(*) FROM board")
    int getTotalBoard();

    @Select(value = "SELECT * FROM board WHERE id=#{id}")
    List<Board> viewBoard(@Param("id") Long id);

    @Select(value = "SELECT user_id FROM board WHERE id=#{id}")
    Long getUserId(@Param("id") Long id);

    @Update(value = "UPDATE board SET deleted = 1 WHERE id=#{id}")
    void deleteBoard(@Param("id") Long id);

    @Update(value = "UPDATE board SET title=#{title}, content=#{content} WHERE id=#{id}")
    void modifyBoard(@Param("title") String title, @Param("content") String content, @Param("id") Long id);

    @Update(value = "UPDATE board SET view_count=view_count+1 WHERE id=#{id}")
    void upViewCount(@Param("id") Long id);

    @Insert(value = "INSERT INTO board(user_id, nick_name, title, content) VALUES(#{user_id}, #{nick_name}, #{title}, #{content}) ")
    void writeBoard(Board board);
}
