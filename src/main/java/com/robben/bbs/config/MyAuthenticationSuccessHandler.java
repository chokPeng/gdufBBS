package com.robben.bbs.config;import org.springframework.security.core.Authentication;import org.springframework.security.web.authentication.AuthenticationSuccessHandler;import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;import org.springframework.stereotype.Component;import javax.servlet.ServletException;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;@Componentpublic class MyAuthenticationSuccessHandler implements        AuthenticationSuccessHandler {    /*     * 因为spring security默认的AuthenticationSuccessHandler在认证成功后，自动跳转。     * 所以重写一个AuthenticationSuccessHandler，防止自动跳转     */    @Override    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {    }}