package com.main.reposrtingsystem.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.main.reposrtingsystem.entities.Report;
import com.main.reposrtingsystem.repositories.ReportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public Report saveReport(Report report){
        report.setStatus("pending");
        report.setTimeStamp(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public List<Report> getReportByUser(Long userId){
        return reportRepository.findByUserId(userId);
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public void updateStatus(Long reportId, String status){
        Report r = reportRepository.findById(reportId)
                      .orElseThrow(() -> new RuntimeException("Report Not Found"));
        r.setStatus(status);
        reportRepository.save(r);
    }

}
