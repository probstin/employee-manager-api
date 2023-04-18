package com.probstin.employeemanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StsConstants {

    @Value("${spring.security.oauth2.resourceserver.opaque-token.introspection-uri:https://identity/oauth2/introspect}")
    private String introspectUri;

    @Value("${spring.security.oauth2.resourceserver.opaque-token.user-info-uri:https://identity/oauth2/userinfo}")
    private String userInfoUri;

    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-id:setme}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque-token.client-secret:setme}")
    private String clientSecret;

    public String getIntrospectUri() {
        return introspectUri;
    }

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

}
