package com.nhnacademy.resident.repository.certificateissue;

import com.nhnacademy.resident.entity.CertificateIssue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long> {
    List<CertificateIssue> findAllByResident_ResidentSerialNumber(Long residentSerialNumber);
}
