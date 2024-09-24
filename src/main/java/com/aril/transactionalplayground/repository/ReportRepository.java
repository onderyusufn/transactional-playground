package com.aril.transactionalplayground.repository;

import com.aril.transactionalplayground.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReportRepository extends JpaRepository<Report, Long> {

    // this sleep method is used to simulate a long-running query for transactional timeout testing
    @Query(value = "SELECT sleep(:milliSeconds)")
    void sleep(int milliSeconds);
}
