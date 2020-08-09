package BoardWeb.service;

import BoardWeb.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoardList();
    public void write(Board board);
    public List<Board> view(Long id, Long user_id);
    public List<Board> view(Long id);
    public boolean delete(Long id, Long user);
    public void modify(Board board);
    public boolean checkSame(Long id, Long user);
}
