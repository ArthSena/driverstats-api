package io.github.arthsena.drivestats.infra.security;

import jakarta.ws.rs.core.SecurityContext;

import java.security.Principal;

public class EmptySecurityContext implements SecurityContext {
    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return "";
    }
}
