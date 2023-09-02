package com.suin.zzang.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyScheduler {

    @Scheduled(fixedDelay = 3000)
    public void hate() {
        log.debug("미웡");

    }

    @Scheduled(cron = "10 37 * * * *")
    public void hat2() {
        log.debug("37분 10초에 밉당");
    }
}
