package com.xzl.framework.web.springboot.common.controller;

import com.xzl.framework.web.springboot.common.exception.BusinessException;
import com.xzl.framework.web.springboot.common.result.JsonResult;
import com.xzl.framework.web.springboot.common.utils.ExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Xuezl on 2018/1/25.
 */
public class BaseController {

    private static final Logger logger = Logger.getLogger(BaseController.class);

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @ExceptionHandler
    @ResponseBody
    public JsonResult exp(HttpServletRequest request, Exception ex) {

        logger.debug(ExceptionUtil.getMessage(ex));
        return new JsonResult(600,ex.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public JsonResult exp(HttpServletRequest request, BusinessException ex) {
        logger.debug(ExceptionUtil.getMessage(ex));
        return new JsonResult(500,ex.getMessage());
    }

    protected String getRealIp(){
        String ip = request.getHeader("X-Real-IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
