package cn.edu.chzu.collegetalent.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityHandlerInterceptor implements HandlerInterceptor {

    /**
     *  拦截所有请求，进行登录校验
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");

        if(admin!=null){
            return true;
        } else {
            String url = "/login";
            response.sendRedirect(url);
            return false;
        }
    }

}
