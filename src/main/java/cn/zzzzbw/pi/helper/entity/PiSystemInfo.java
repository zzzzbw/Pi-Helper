package cn.zzzzbw.pi.helper.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 20:45
 */
@Data
public class PiSystemInfo {

    private boolean shutdown = false;

    private boolean reboot = false;

    private Date lastReceiveTime;
}
