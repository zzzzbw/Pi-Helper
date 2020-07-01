package cn.zzzzbw.pi.helper.entity;

import cn.zzzzbw.pi.helper.entity.enums.CommandStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 21:10
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Command extends BaseEntity {

    public Command() {
    }

    public Command(String content) {
        this.content = content;
        this.status = CommandStatusEnum.UN_READ;
    }

    private String content;
    private CommandStatusEnum status;
}
