package cn.zzzzbw.pi.helper.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/06/17 21:24
 */
@Slf4j
@Service
public class PanelService {

    @Autowired
    private StorageService storageService;
}
