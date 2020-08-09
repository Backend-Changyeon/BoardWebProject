package BoardWeb.service;

import BoardWeb.domain.User;

public interface UserService {

    //로그인 시 계정 확인 역할, 세션에 userID를 넣어줌
    public boolean Login(User user) throws Exception;
    public void Logout();
    public boolean insertUser(User user) throws Exception;
    public boolean checkPwd(User user) throws Exception;
    public Long getUserID();
    public String getUserAccount();
    public String getUserNickName();
}
