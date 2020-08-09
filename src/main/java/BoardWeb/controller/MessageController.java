package BoardWeb.controller;

import BoardWeb.domain.Message;
import BoardWeb.repository.UserMapper;
import BoardWeb.service.MessageService;
import BoardWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getMyMessage(Model model)
    {
        model.addAttribute("msg", (List<Message>)messageService.getMyMessage(userService.getUserID()));
        return "viewMessage";
    }

    @RequestMapping(value = "/writeMessage", method = RequestMethod.POST)
    public String writeMessage(String to_user_nick_name, String content)
    {
        messageService.sendMessage(userService.getUserID(), userMapper.getUserIdFromNickName(to_user_nick_name), content);
        return "redirect:/board";
    }

    @RequestMapping(value = "/writeMessage", method = RequestMethod.GET)
    public String writeMessage()
    {
        return "/writeMessage";
    }

    @RequestMapping(value = "/writeMessage/{to_user_nick_name}", method = RequestMethod.GET)
    public String writeMessage(@PathVariable("to_user_nick_name") String to_user_nick_name, Model model)
    {
        model.addAttribute("to_user_nick_name", to_user_nick_name);
        return "/writeMessage";
    }
}
