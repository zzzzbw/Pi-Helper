package cn.zzzzbw.pi.helper.repository;

import cn.zzzzbw.pi.helper.entity.Command;
import cn.zzzzbw.pi.helper.entity.enums.CommandStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/30 13:52
 */
public interface CommandRepository extends JpaRepository<Command, Long> {

    Optional<Command> findTopByStatusOrderById(CommandStatusEnum status);

}
