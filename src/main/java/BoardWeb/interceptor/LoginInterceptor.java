package BoardWeb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //dispatcher-servlet.xml에 인터셉터 설정은 모든 URL(/**)로 설정
        //요청되는 URL에 "/login", "/signup"이 포함되어 있는 경우 통과
        String requestUrl = request.getRequestURL().toString();
        if(requestUrl.contains("/login")||requestUrl.contains("/signup"))
            return true;

        HttpSession session = request.getSession();
        Long userID = (Long)session.getAttribute("userID");

        if(userID == null){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }



}
