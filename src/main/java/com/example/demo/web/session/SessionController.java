package com.example.demo.web.session;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihui
 * @date: 2020-08-18
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    private final static String USER_SESSION_NAME = "user";

    @GetMapping("/set")
    public boolean login(@RequestParam("name") String name, HttpSession httpSession) {
        Object attribute = httpSession.getAttribute(USER_SESSION_NAME);
        httpSession.setAttribute("user", name);
        return true;
    }

    @GetMapping("/get")
    public Object getSession(HttpSession httpSession) {
        Object object = httpSession.getAttribute(USER_SESSION_NAME);
        return object == null ? "null" : object;
    }
}
