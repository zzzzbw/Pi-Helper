package cn.zzzzbw.pi.helper.controller;

import cn.zzzzbw.pi.helper.service.CommandService;
import org.springframework.web.bind.annotation.*;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/30 15:11
 */
@RestController
@RequestMapping("pi")
public class PiController {

    private final CommandService commandService;

    public PiController(CommandService commandService) {
        this.commandService = commandService;
    }


    @GetMapping("/command/push")
    public String commandPush() {
        return commandService.push();
    }

    @PutMapping("command/executed/{id}")
    public void commandExecuted(@PathVariable long id){
        commandService.executed(id);
    }
}
