package com.aril.transactionalplayground.service;

import com.aril.transactionalplayground.exception.NoRollbackException;
import com.aril.transactionalplayground.exception.RollbackException;
import com.aril.transactionalplayground.model.Report;
import com.aril.transactionalplayground.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final ReportRepository reportRepository;
    private final LogService logService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createReport(String status) {
        log.info("Creating report with status: {}", status);
        logService.createLog("Report created");
        Report entity = new Report();
        entity.setStatus(status);
        entity.setTimestamp(Instant.now().getEpochSecond());
        reportRepository.save(entity);
        log.info("Report created");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 4)
    public void timeoutDontEffectOrderService() {
        reportRepository.sleep(6000);
    }

    @Transactional(timeout = 8)
    public void timeoutEffectOrderService() {
        reportRepository.sleep(6000);
    }

    @Transactional
    public void throwExceptionDontRollback() {
        try {
            throw new NoRollbackException("no rollback");
        } catch (NoRollbackException e) {
            log.error("Error", e);
        }
    }

    @Transactional
    public void throwExceptionRollback() {
        throw new RollbackException("rollback");
    }
}
