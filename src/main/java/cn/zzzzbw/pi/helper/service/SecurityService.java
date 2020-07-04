package cn.zzzzbw.pi.helper.service;

import cn.zzzzbw.pi.helper.config.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/07/03 16:33
 */
@Slf4j
@Service
public class SecurityService {

    private static String SECURITY_TOKEN = "";

    private final PropertiesConfig propertiesConfig;

    public SecurityService(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
    }

    public boolean checkSecurityKey(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        return checkSecurityKey(authorization);
    }

    public boolean checkSecurityKey(String key) {
        return !StringUtils.isEmpty(key)
                && key.equals(propertiesConfig.getSecurityKey());
    }

    public HttpEntity<String> login(String key) {
        if (StringUtils.isEmpty(key)) {
            return ResponseEntity.badRequest().body("key 值不能为空");
        }
        if (!key.equals(propertiesConfig.getSecurityKey())) {
            return ResponseEntity.badRequest().body("key 值错误");
        }
        String token = createSecurityToken();
        SECURITY_TOKEN = token;
        return ResponseEntity.ok(token);
    }

    public String createSecurityToken() {
        String str = propertiesConfig.getSecurityKey() + System.currentTimeMillis();
        return new String(DigestUtils.md5Digest(str.getBytes()));
    }
}
