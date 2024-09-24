package com.aril.transactionalplayground.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createLog(String message) {
        log.info("Creating log with message: {}", message);
    }
}
