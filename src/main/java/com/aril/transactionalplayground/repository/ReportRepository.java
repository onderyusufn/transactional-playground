package com.aril.transactionalplayground.repository;

import com.aril.transactionalplayground.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "SELECT sleep(:milliSeconds)")
    void sleep(int milliSeconds);
}
