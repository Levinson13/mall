package com.cn.mall;

import com.cn.mall.consts.MallConsts;
import com.cn.mall.exception.UserLoginException;
import com.cn.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * true 继续流程，false表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConsts.CURRENT_USER);
        if (user == null) {
            log.info("user=null");
            throw new UserLoginException();
//            return false;
        }
        return true;
    }
}
