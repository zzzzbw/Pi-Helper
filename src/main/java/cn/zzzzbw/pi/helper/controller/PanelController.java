package cn.zzzzbw.pi.helper.controller;

import cn.zzzzbw.pi.helper.entity.Command;
import cn.zzzzbw.pi.helper.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/30 15:12
 */
@RestController
@RequestMapping("panel")
public class PanelController {


    private final CommandService commandService;

    public PanelController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("command")
    public void commandCreate(String command) {
        commandService.create(command);
    }

    @DeleteMapping("command/{id}")
    public void commandDelete(@PathVariable long id) {
        commandService.delete(id);
    }

    @GetMapping("command")
    public Page<Command> commandPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return commandService.page(page, size);
    }
}
