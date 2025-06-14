package com.main.reposrtingsystem.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.reposrtingsystem.Services.ReportService;
import com.main.reposrtingsystem.entities.Report;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/add")
    public ResponseEntity<Report> addReport(@RequestParam("file") MultipartFile file,
    @RequestParam("title") String title,
    @RequestParam("description") String description){
         try {
        // Define upload directory
        String uploadDir = "uploads";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save the file locally
        String originalFileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + "_" + originalFileName;
        Path filePath = uploadPath.resolve(newFileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Create and populate Report object
        Report report = new Report();
        report.setTitle(title);
        report.setDescription(description);
        report.setImagePath(filePath.toString());

        // Save report using service
        Report savedReport = reportService.saveReport(report);
        return ResponseEntity.ok(savedReport);

    } catch (IOException e) {
        e.printStackTrace();
        return ResponseEntity.status(500).build();
    }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Report>> getUserReports(@PathVariable Long userId){
        return ResponseEntity.ok(reportService.getReportByUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<Report>> getAllReports(){
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam String status){
        reportService.updateStatus(id, status);
        return ResponseEntity.ok("Status updated");
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Report> uploadReport(
        @RequestParam("userId") Long userId,
        @RequestParam("description")String description,
        @RequestParam("location") String location,
        @RequestParam("image") MultipartFile imageFile
    ) throws IOException{

        String imageName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        String uploadDir = "uploads/";
        File uploadPath = new File(uploadDir);
        if(!uploadPath.exists()) uploadPath.mkdirs();
        File imagePath = new File(uploadDir + imageName);
        imageFile.transferTo(imagePath);

        Report report = new Report();
        report.setUserId(userId);
        report.setDescription(description);
        report.setImagePath(imagePath.getPath());
        report.setStatus("Pending");
        report.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.ok(reportService.saveReport(report));
    }

}
