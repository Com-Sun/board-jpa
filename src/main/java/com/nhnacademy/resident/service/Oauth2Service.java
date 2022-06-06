package com.nhnacademy.resident.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nhnacademy.resident.oauth2.GithubProfile;
import com.nhnacademy.resident.oauth2.OAuthToken;

public interface Oauth2Service {
    GithubProfile getGithubProfile(OAuthToken oAuthToken) throws JsonProcessingException;

    OAuthToken getOAuthToken(String code) throws JsonProcessingException;
}
