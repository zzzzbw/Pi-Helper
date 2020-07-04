package cn.zzzzbw.pi.helper.config;

import cn.zzzzbw.pi.helper.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/07/02 11:08
 */
@Configuration
public class SecurityConfig {

    private static final List<String> IGNORE_URIS = Arrays.asList("/", "/login");

    @Autowired
    private SecurityService securityService;

    @Bean("securityInterceptor")
    public HandlerInterceptor securityInterceptor() {
        return new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String url = request.getRequestURI();

                boolean isAuthUrl = IGNORE_URIS.stream()
                        .noneMatch(t -> new AntPathMatcher().match(t, url));
                //登录验证
                if (isAuthUrl && !securityService.checkSecurityKey(request)) {
                    response.sendError(401);
                    return false;
                }
                return true;
            }
        };
    }
}
