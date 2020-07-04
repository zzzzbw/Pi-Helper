package cn.zzzzbw.pi.helper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/07/02 11:22
 */
@Data
@ConfigurationProperties("pi")
public class PropertiesConfig {

    private String securityKey;
}
