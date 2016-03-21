package org.webim.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @ClassName AuthorizationHandle
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-3 下午9:24:17
 * @version 1.0.0
 */
public class AuthorizationHandler extends HandlerInterceptorAdapter{

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex)
            throws Exception {
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    /* (非 Javadoc)
     * Description:
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter
     * #preHandle(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        PrintWriter out = null;
        try {
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                String[] authSuite = auth.split(" ");
                String decodeAuth
                = new String(Base64.decode(authSuite[1].getBytes("UTF-8")));
                String[] decodeToken = decodeAuth.split(":");
                if (decodeToken.length == 3) {
                    String userToken
                    = (String) request.getSession().getAttribute("userToken");
                    if (userToken != null
                            && userToken.equals(decodeToken[2])
                            && userToken.equals(LoginManager.getMark(decodeToken[0]))) {
                        return true;
                    }
                }
            }
            String result = "{status:0,data:null,message:'授权认证失败'}";
            response.setContentType("application/json;charset=UTF-8");

            out = response.getWriter();
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
            String result = "{status:-1,data:null,message:'授权认证异常'}";
            response.setContentType("application/json;charset=UTF-8");
            out = response.getWriter();
            out.write(result);
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return false;
    }
}
