package cn.zzzzbw.pi.helper.controller;

import cn.zzzzbw.pi.helper.entity.Order;
import cn.zzzzbw.pi.helper.service.PiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 20:58
 */
@RestController
@RequestMapping("pi")
public class PiController {

    @Autowired
    private PiService piService;

    @GetMapping("order")
    public Order getOrder() {
        return piService.getOrder();
    }

    @GetMapping("shutdown")
    public void toShutdown() {
        piService.toShutdown();
    }

    @GetMapping("reboot")
    public void toReboot() {
        piService.toReboot();
    }
}
