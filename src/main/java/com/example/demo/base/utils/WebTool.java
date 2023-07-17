package com.example.demo.base.utils;

import cn.hutool.core.util.StrUtil;
import com.example.demo.entity.SysUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 16:00
 */
public class WebTool {
    private static ThreadLocal<SysUser> userLocal = new ThreadLocal<SysUser>();

    private static ThreadLocal<String> tokenLocal = new ThreadLocal<String>();

    /**
     * 设置当前登录用户
     *
     * @param user
     */
    public static void setCurrentUser(SysUser user) {
        userLocal.set(user);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static SysUser getCurrentUser() {
        SysUser user = (SysUser) userLocal.get();
        return user;
    }

    /**
     * 删除线程中的用户
     */
    public static void removeCurrentUser() {
        userLocal.remove();
    }

    /**
     * 设置当前token
     *
     * @param token
     */
    public static void setCurrentToken(String token) {
        tokenLocal.set(token);
    }

    /**
     * 获取当前token
     *
     * @return
     */
    public static String getCurrentToken() {
        String token = (String) tokenLocal.get();
        return token;
    }

    /**
     * 删除线程中的token
     */
    public static void removeCurrentToken() {
        tokenLocal.remove();
    }


    /**  =========================Session方式============================= */

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest() == null ? null : getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        return getRequestAttributes() == null ? null : getRequestAttributes().getRequest();
    }

    /**
     * 获取登录地址ip
     *
     * @return
     */
    public static final String getRemoteAddr() {
        String addr = getRequest().getHeader("RealRemoteAddr");
        if (StrUtil.isNotEmpty(addr)) {
            return addr;
        }
        addr = getRequest().getHeader("x-forwarded-for");
        if (StrUtil.isNotEmpty(addr)) {
            return addr.split(",")[0];
        }
        return getRequest().getRemoteAddr();
    }
}
