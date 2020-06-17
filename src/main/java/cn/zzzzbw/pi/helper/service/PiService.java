package cn.zzzzbw.pi.helper.service;

import cn.zzzzbw.pi.helper.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 20:59
 */
@Slf4j
@Service
public class PiService {

    @Autowired
    private StorageService storageService;

    public Order getOrder() {
        storageService.refreshReceiveTime();
        return storageService.getOrder();
    }

    public void toShutdown() {
        storageService.refreshReceiveTime();
        storageService.resetShutdown();
    }

    public void toReboot() {
        storageService.refreshReceiveTime();
        storageService.resetReboot();
    }
}
