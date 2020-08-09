package BoardWeb.controller;

import BoardWeb.domain.Board;
import BoardWeb.domain.Reply;
import BoardWeb.service.BoardService;
import BoardWeb.service.ReplyService;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    //게시판 (view)
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String getBoardList(Model model) throws Exception {
        List<Board> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "list";
    }

    /*
    //페이지 네이션
    @RequestMapping(value = "/board/listPage", method = RequestMethod.GET)
    public String listPage(@ModelAttribute("cri") CriteriaDTO cri, Model model) throws Exception {
        model.addAttribute("list", boardService.getBoardList());
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCri(cri);
        pageDTO.setTotalCount(boardService.getTotalBoard());
        model.addAttribute("pageMaker", pageDTO);

        return "pagelist";
    }
    */

    //게시글 작성 (get)
    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String getWrite(Model model) throws Exception {
        //세션에 있는 정보를 이용해 계정과 닉네임을 뷰로 넘겨줌.
        return "write";
    }

    //게시글 작성 (post)
    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String writeBoard(Board board) throws Exception {
        boardService.write(board);
        return "redirect:/board";
    }

    //게시글 보기
    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public String viewBoard(@PathVariable("id") Long id, Model model) {
        //게시글, 댓글 리스트 view로 전달
        model.addAttribute("view", (List<Board>) boardService.view(id, userService.getUserID()));
        model.addAttribute("reply", (List<Reply>) replyService.getReplyList(id));
        return "view";
    }

    //게시글 삭제
    @RequestMapping(value = "/board/delete/{id}", method = RequestMethod.GET)
    public String deleteBoard(@PathVariable("id") Long id) {
        if(boardService.delete(id, userService.getUserID()))
            return "redirect:/board";
        else return "redirect:/board/"+id;
    }

    //게시글 수정 (get)
    @RequestMapping(value = "/board/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable("id") Long id, Model model) {
        model.addAttribute("modify", (List<Board>)boardService.view(id));
        if(boardService.checkSame(id, userService.getUserID()))
            return "modify";
        else
            return "redirect:/board/"+id;
    }

    //게시물 수정 (post)
    @RequestMapping(value = "/board/modify", method = RequestMethod.POST)
    public String modify(Board board) {
        boardService.modify(board);
        return "redirect:/board/"+ board.getId();
    }

}
