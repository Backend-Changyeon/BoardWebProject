package BoardWeb.domain;

import BoardWeb.repository.UserMapper;
import BoardWeb.service.UserService;

import java.sql.Timestamp;

public class Message {
    protected Long id;
    protected Long from_user_id;
    protected Long to_user_id;
    protected String content;
    protected Timestamp sent_at;
    protected String to_user_nick_name;

    UserMapper userMapper;

    public void setTo_user_nick_name()
    {
        this.to_user_nick_name=userMapper.getUserNickNameFromId(getTo_user_id());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(Long from_user_id) {
        this.from_user_id = from_user_id;
    }

    public Long getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(Long to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSent_at() {
        return sent_at;
    }

    public void setSent_at(Timestamp sent_at) {
        this.sent_at = sent_at;
    }
}