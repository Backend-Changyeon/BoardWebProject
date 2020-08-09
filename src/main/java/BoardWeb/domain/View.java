package BoardWeb.domain;

import java.sql.Timestamp;

public class View {
    protected Long id;
    protected Long board_id;
    protected Long user_id;
    protected Timestamp viewed_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Timestamp getViewed_at() {
        return viewed_at;
    }

    public void setViewed_at(Timestamp viewed_at) {
        this.viewed_at = viewed_at;
    }
}
