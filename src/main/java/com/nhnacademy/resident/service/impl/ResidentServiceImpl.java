package com.nhnacademy.resident.service.impl;

import com.nhnacademy.resident.domain.dto.request.ResidentLoginRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRegisterRequest;
import com.nhnacademy.resident.domain.dto.request.ResidentRequest;
import com.nhnacademy.resident.domain.dto.response.ResidentRegisterResponse;
import com.nhnacademy.resident.entity.Resident;
import com.nhnacademy.resident.repository.ResidentRepository;
import com.nhnacademy.resident.service.ResidentService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public Resident createResident(ResidentRequest residentRequest) {

        return residentRepository.save(Resident.builder()
            .residentSerialNumber(residentRequest.getSerialNumber())
            .name(residentRequest.getName())
            .residentRegistrationNumber(residentRequest.getRegistrationNumber())
            .genderCode(residentRequest.getGender())
            .birthDate(residentRequest.getBirthDate())
            .birthPlaceCode(residentRequest.getBirthPlace())
            .registrationBaseAddress(residentRequest.getBaseAddress())
            .build());
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
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(simpleGrantedAuthority);
//
//
//        UserDetails
//            userDetails = new SecurityUser(user.getBody().getLogin(),user.getBody().getId(),simpleGrantedAuthority.getAuthority());
//        Authentication
//            authentication = new UsernamePasswordAuthenticationToken(userDetails, "USER_PASSWORD", authorities);
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        securityContext.setAuthentication(authentication);
    }

    @Transactional
    @Override
    public ResidentRegisterResponse registerResident(Long serialNum,
                                                     ResidentRegisterRequest request) {
        Resident resident = residentRepository.findById(serialNum).get();
        resident.setUserId(request.getUserId());
        resident.setPwd(request.getPwd());
        resident.setEmail(request.getEmail());

        residentRepository.save(resident);

        return residentRepository.getByResidentSerialNumber(serialNum);
    }


}
