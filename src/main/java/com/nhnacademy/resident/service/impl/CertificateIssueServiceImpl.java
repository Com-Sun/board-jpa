package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.entity.CertificateIssue;
import com.nhnacademy.resident.repository.certificateissue.CertificateIssueRepository;
import com.nhnacademy.resident.service.CertificateIssueService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CertificateIssueServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository certificateIssueRepository;

    public CertificateIssueServiceImpl(
        CertificateIssueRepository certificateIssueRepository) {
        this.certificateIssueRepository = certificateIssueRepository;
    }

    @Override
    public List<CertificateIssue> getCertificateListByResidentSerialNum(Long residentSerialNumber) {
        List<CertificateIssue> certifications =
            certificateIssueRepository.findAllByResident_ResidentSerialNumber(residentSerialNumber);
        return certificateIssueRepository.findAllByResident_ResidentSerialNumber(residentSerialNumber);
    }

    @Override
    public CertificateIssue getFamilyRelationshipCertification(
        List<CertificateIssue> certifications, String typeCode) {
        return certifications.stream()
            .filter(code -> code.getCertificateTypeCode().equals(typeCode))
            .collect(Collectors.toList()).get(0);
    }
}
