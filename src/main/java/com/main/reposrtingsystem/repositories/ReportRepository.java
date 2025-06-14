package com.main.reposrtingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.reposrtingsystem.entities.Report;
import java.util.List;


public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByUserId(Long userId);
}
