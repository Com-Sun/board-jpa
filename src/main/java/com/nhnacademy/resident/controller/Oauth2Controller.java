package com.nhnacademy.resident.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nhnacademy.resident.domain.SecurityUser;
import com.nhnacademy.resident.oauth2.GithubProfile;
import com.nhnacademy.resident.oauth2.OAuthToken;
import com.nhnacademy.resident.service.Oauth2Service;
import com.nhnacademy.resident.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Oauth2Controller {
    private final Oauth2Service oauth2Service;
    private final ResidentService residentService;

    public Oauth2Controller(Oauth2Service oauth2Service,
                            ResidentService residentService) {
        this.oauth2Service = oauth2Service;
        this.residentService = residentService;
    }

    @GetMapping("/login/oauth2/code/github")
    public String githubLogin(String code) throws JsonProcessingException {
        OAuthToken oAuthToken = oauth2Service.getOAuthToken(code);
        GithubProfile githubProfile = oauth2Service.getGithubProfile(oAuthToken);

        SecurityUser securityUser = residentService.checkExistEmail(githubProfile.getEmail());

        // session에 securityUser를 담아야하나?

        return "redirect:/residents";
    }

}
