package cn.zzzzbw.pi.helper.service;

import cn.zzzzbw.pi.helper.entity.Command;
import cn.zzzzbw.pi.helper.entity.enums.CommandStatusEnum;
import cn.zzzzbw.pi.helper.repository.CommandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/30 13:57
 */
@Slf4j
@Service
public class CommandService {

    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }


    public void create(String command) {
        Command order = new Command();
        order.setContent(command);
        order.setStatus(CommandStatusEnum.UN_READ);
        commandRepository.save(order);
    }


    public void delete(long id) {
        commandRepository.deleteById(id);
    }

    public Page<Command> page(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return commandRepository.findAll(pageable);
    }


    public String push() {
        Optional<Command> optionalOrder = commandRepository.findTopByStatusOrderById(CommandStatusEnum.UN_READ);
        if (!optionalOrder.isPresent()) {
            return "";
        }
        Command command = optionalOrder.get();
        command.setStatus(CommandStatusEnum.ACCEPT);
        commandRepository.save(command);

        return command.getId() + ":" + command.getContent();
    }

    public void executed(long id) {
        Optional<Command> optionalCommand = commandRepository.findById(id);
        if (!optionalCommand.isPresent()) {
            log.error("Command not exist! id:{}", id);
            return;
        }
        Command command = optionalCommand.get();
        command.setStatus(CommandStatusEnum.EXECUTED);
        commandRepository.save(command);
    }
}
