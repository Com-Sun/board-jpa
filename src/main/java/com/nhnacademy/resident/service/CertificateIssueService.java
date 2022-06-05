package com.nhnacademy.resident.service;

import com.nhnacademy.resident.entity.CertificateIssue;
import java.util.List;

public interface CertificateIssueService {
    List<CertificateIssue> getCertificateListByResidentSerialNum(Long residentSerialNumber);

    CertificateIssue getFamilyRelationshipCertification(List<CertificateIssue> certifications, String typeCode);
}
