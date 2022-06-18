package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.SecurityUser;
import com.nhnacademy.resident.domain.dto.request.ResidentLoginRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRegisterRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRequest;
import com.nhnacademy.resident.domain.dto.response.ResidentResponse;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.service.ResidentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;
    private final PasswordEncoder passwordEncoder;

    public ResidentServiceImpl(ResidentRepository residentRepository,
                               PasswordEncoder passwordEncoder) {
        this.residentRepository = residentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public ResidentResponse createResident(ResidentRequest residentRequest) {
        residentRepository.save(Resident.builder()
            .residentSerialNumber(residentRequest.getSerialNumber())
            .name(residentRequest.getName())
            .residentRegistrationNumber(residentRequest.getRegistrationNumber())
            .genderCode(residentRequest.getGender())
            .birthDate(residentRequest.getBirthDate())
            .birthPlaceCode(residentRequest.getBirthPlace())
            .registrationBaseAddress(residentRequest.getBaseAddress())
            .build());

        return residentRepository.getByResidentSerialNumber(residentRequest.getSerialNumber());
    }

    @Override
    public Resident getResident(String name, String residentRegistrationNumber) {
        return residentRepository.findByNameAndResidentRegistrationNumber(name,
            residentRegistrationNumber);
    }


    @Transactional
    @Override
    public Resident modifyResident(Resident resident) {
        return residentRepository.save(resident);
    }

    @Override
    public List<Resident> getResidentList() {
        return residentRepository.findAll();
    }

    @Override
    public Resident getResidentBySerialNumber(Long serialNumber) {
        return residentRepository.findById(serialNumber).get();
    }

    @Override
    public void doLogin(ResidentLoginRequest residentLoginRequest) {

    }

    @Transactional
    @Override
    public ResidentResponse registerResident(Long serialNum,
                                             ResidentRegisterRequest request) {
        Resident resident = residentRepository.findById(serialNum).get();
        resident.setUserId(request.getUserId());
        resident.setPwd(passwordEncoder.encode(request.getPwd()));
        resident.setEmail(request.getEmail());

        residentRepository.save(resident);

        return residentRepository.getByResidentSerialNumber(serialNum);
    }

    @Override
    public SecurityUser checkExistEmail(String email) {
        Resident resident = residentRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("해당 이메일을 가진 주민이 존재하지 않습니다."));

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        SecurityUser securityUser = new SecurityUser(resident.getUserId(), resident.getPwd(),
            authorities, resident.getEmail(), resident.getResidentSerialNumber());

        Authentication
            authentication = new UsernamePasswordAuthenticationToken(securityUser, "USER_PASSWORD", authorities);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        return securityUser;

    }

}
