package BoardWeb.service;

import BoardWeb.domain.User;
import BoardWeb.repository.UserMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpSession httpSession;

    @Override
    //회원가입
    public boolean insertUser(User user) throws Exception {
        if(userMapper.getNick_name(user.getAccount())==null)
        //유저로 등록되어 있지 않다면 매퍼에서 insert문 호출후 컨트롤러에 true반환,
        {
            if(userMapper.checkNick_name(user.getNick_name())==null) {
                //닉네임 중복 확인 성공
                String HashPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
                userMapper.insertUser(user.getAccount(), HashPW, user.getNick_name());
                return true;
            }
        }
        //닉네임 중복 확인 실패
        //이미 등록되어 있다면 컨트롤러에 false반환.
        return false;
    }

    @Override
    //로그인
    public boolean Login(User user) throws Exception {
        //세션에 이미 값이 있다면 제거한다.
        if(httpSession.getAttribute("userID")!=null)
        {
            httpSession.removeAttribute("userID");
        }

        //등록된 유져가 맞다면 세션으로 UserID 넘겨줌
        if(checkPwd(user))
        {
            httpSession.setAttribute("userID", userMapper.getUserId(user.getAccount()));
            httpSession.setAttribute("account", user.getAccount());
            httpSession.setAttribute("nick_name", userMapper.getNick_name(user.getAccount()));
            return true;
        }
        else
            return false;
    }

    @Override
    //로그아웃
    public void Logout() {
        httpSession.invalidate();
    }

    @Override
    //비밀번호 확인
    public boolean checkPwd(User user) throws Exception {
        return (BCrypt.checkpw(user.getPassword()
                , userMapper.getPassword(user.getAccount())));
    }







    /*****************************************
    세션에 들어 있는 id, account, nickname가져오기
     ****************************************/

    @Override
    public Long getUserID() {
        return (Long)httpSession.getAttribute("userID");
    }

    @Override
    public String getUserAccount() {
        return (String)httpSession.getAttribute("account");
    }

    @Override
    public String getUserNickName() {
        return (String)httpSession.getAttribute("nick_name");
    }
}
