package BoardWeb.service;

import BoardWeb.domain.Reply;
import BoardWeb.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    UserService userService;

    @Override
    //댓글 리스트
    public List<Reply> getReplyList(Long board_id) {
        return replyMapper.viewReply(board_id);
    }

    @Override
    //댓글 쓰기
    public void writeReply(Reply reply) {
        replyMapper.writeReply(reply);
    }

    @Override
    //댓글 삭제
    public Long deleteReply(Long id, Long user) {
        if(checkSame(id, user)) {
            replyMapper.deleteReply(id);
        }
        return replyMapper.getBoard_id(id);
    }

    @Override
    //댓글 읽기
    public List<Reply> getReply(Long id) {
        return replyMapper.getReply(id);
    }

    @Override
    //댓글 수정
    public Long modifyReply(Reply reply) {
        replyMapper.modifyReply(reply);
        return replyMapper.getBoard_id(reply.getId());
    }

    @Override
    public boolean checkSame(Long id, Long user) {
        return (replyMapper.getUserId(id)==user);
    }

}
