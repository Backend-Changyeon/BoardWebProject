package BoardWeb.service;

import BoardWeb.domain.Message;
import BoardWeb.repository.MessageMapper;
import BoardWeb.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    //메세지 읽기
    public List<Message> getMyMessage(Long to_user_id) {
        return messageMapper.getMyMessage(to_user_id);
    }

    @Override
    //메세지 쓰기
    public void sendMessage(Long from_user_id, Long to_user_id, String content) {
        messageMapper.sendMessage(from_user_id,to_user_id,content);
    }
}
