package BoardWeb.service;

import BoardWeb.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMyMessage(Long to_user_id);
    void sendMessage(Long from_user_id, Long to_user_id, String content);
}
