    package com.bobo.test.config;

    import com.bobo.test.pojo.User;
    import com.bobo.test.service.UserServiceImpl;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.servlet.HandlerInterceptor;
    import org.springframework.web.servlet.ModelAndView;

    import javax.servlet.http.Cookie;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import java.util.Collection;
    import java.util.HashMap;
    import java.util.Map;

    public class LoginHandlerInterceptor implements HandlerInterceptor {

        @Autowired
        UserServiceImpl userService;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            Object Session = request.getSession().getAttribute("user");

            if (Session != null) {
                return true;
            }else {
                request.getRequestDispatcher("/login").forward(request, response);
                return false;
            }
        }
    }
