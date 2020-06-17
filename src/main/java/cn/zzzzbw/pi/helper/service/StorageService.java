package cn.zzzzbw.pi.helper.service;

import cn.zzzzbw.pi.helper.entity.Order;
import cn.zzzzbw.pi.helper.entity.PiSystemInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 20:50
 */
@Slf4j
@Service
public class StorageService {

    private PiSystemInfo piSystemInfo;

    private volatile static boolean init = false;

    @PostConstruct
    public void init() {
        if (init) {
            return;
        }
        log.info("Init PiSystemInfo!");
        piSystemInfo = new PiSystemInfo();
        init = true;
    }


    public Order getOrder() {
        Order order = new Order();
        order.setReboot(piSystemInfo.isReboot());
        order.setShutdown(piSystemInfo.isShutdown());
        return order;
    }


    public void resetShutdown() {
        piSystemInfo.setShutdown(false);
    }


    public void resetReboot() {
        piSystemInfo.setReboot(false);
    }

    public void refreshReceiveTime() {
        piSystemInfo.setLastReceiveTime(new Date());
    }
}
