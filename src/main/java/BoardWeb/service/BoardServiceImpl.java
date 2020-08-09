package BoardWeb.service;

import BoardWeb.domain.Board;
import BoardWeb.repository.BoardMapper;
import BoardWeb.repository.UserMapper;
import BoardWeb.repository.ViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ViewMapper viewMapper;

    @Override
    //게시글 리스트
    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    //게시글 쓰기
    public void write(Board board) {
        boardMapper.writeBoard(board);
    }

    @Override
    //게시글 읽기
    public List<Board> view(Long id, Long user_id) {

        Timestamp viewed_at = viewMapper.getViewed_at(id, user_id);
        if(viewed_at==null) {
            viewMapper.insertViewed_at(id, user_id);
            boardMapper.upViewCount(id);
        }

        else {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            long diff = now.getTime() - viewed_at.getTime();
            long diff_minute = (diff / 1000) / 60;
            if(diff_minute>=30) {
                viewMapper.setViewed_at(id, user_id);
                boardMapper.upViewCount(id);
            }
        }

        return boardMapper.viewBoard(id);
    }

    @Override
    public List<Board> view(Long id) {
        return boardMapper.viewBoard(id);
    }

    @Override
    //게식ㄹ 삭제
    public boolean delete(Long id, Long user) {
        //게시물 작성자 정보와 세션에 있는 유저 정보를 비교하여 일치하면 delete 매퍼 호출
        if(boardMapper.getUserId(id) == user)
        {
            boardMapper.deleteBoard(id);
            return true;
        }
        return false;
    }

    @Override
    //게시글 수정
    public void modify(Board board) {
        boardMapper.modifyBoard(board.getTitle(), board.getContent(), board.getId());
    }

    @Override
    public boolean checkSame(Long id, Long user) {
        return (boardMapper.getUserId(id) == user);
    }
}
