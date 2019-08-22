package com.example.springbootweb.controller;

import com.example.springbootweb.domain.User;
import com.example.springbootweb.domain.enums.SocialType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/{facebook/google/kakao}/complate")
    public String loginComplate(HttpSession session) {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> map = (Map<String, String>) authentication.getUserAuthentication().getDetails();
        session.setAttribute("user", User.builder()
        .name(map.get("name"))
        .email(map.get("email"))
        .principal(map.get("principal"))
        .socialType(SocialType.FACEBOOK)
        .createdDate(LocalDateTime.now())
        .build());
        return "redirect:/board/list";
    }
}
