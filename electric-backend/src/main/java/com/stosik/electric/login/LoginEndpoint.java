package com.stosik.electric.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
class LoginEndpoint
{
    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request)
    {
        log.info(request.getRemoteHost());
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        log.info(remoteHost + ":" + portNumber);
        log.info(request.getRemoteAddr());
        
        return Collections.singletonMap("token", session.getId());
    }
    
    @RequestMapping("/checkSession")
    public ResponseEntity checkSession()
    {
        return new ResponseEntity("Session Active!", HttpStatus.OK);
    }
    
    @PostMapping(value = "/user/logout")
    public ResponseEntity logout()
    {
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Logout Successfully!", HttpStatus.OK);
    }
}
