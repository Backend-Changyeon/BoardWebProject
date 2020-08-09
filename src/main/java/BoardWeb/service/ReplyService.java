package BoardWeb.service;

import BoardWeb.domain.Reply;

import java.util.List;

public interface ReplyService {

    public List<Reply> getReplyList(Long board_id);
    public void writeReply(Reply reply);
    public Long deleteReply(Long id, Long user);
    public List<Reply> getReply(Long id);
    public Long modifyReply(Reply reply);
    public boolean checkSame(Long id, Long user);
}
