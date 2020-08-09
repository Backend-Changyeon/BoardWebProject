package BoardWeb.controller;

import BoardWeb.domain.Reply;
import BoardWeb.repository.BoardMapper;
import BoardWeb.repository.ReplyMapper;
import BoardWeb.service.ReplyService;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    @Autowired
    ReplyMapper replyMapper;

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public String writeReply (Reply reply)
    {
        replyService.writeReply(reply);
        return "redirect:/board/"+ reply.getBoard_id();
    }

    @RequestMapping(value = "/reply/delete/{id}", method = RequestMethod.GET)
    public String deleteReply(@PathVariable("id") Long id)
    {
        return "redirect:/board/"+replyService.deleteReply(id, userService.getUserID());
    }

    @RequestMapping(value = "/reply/modify/{id}", method = RequestMethod.GET)
    public String ModifyReply(@PathVariable("id") Long id, Model model)
    {
        if(replyService.checkSame(id, userService.getUserID())) {
            model.addAttribute("reply", replyService.getReply(id));
            return "replymodify";
        }
        return "redirect:/board/"+replyMapper.getBoard_id(id);
    }

    @RequestMapping(value = "/reply/modify", method = RequestMethod.POST)
    public String ModifyReply(Reply reply)
    {
        return "redirect:/board/"+replyService.modifyReply(reply);
    }


}
