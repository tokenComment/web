package com.hqz.demo.controller;

import com.hqz.demo.dao.UserDAO;
import com.hqz.demo.dao.UserDAOComment;
import com.hqz.demo.dao.UserDAORegister;
import com.hqz.demo.model.User;
import com.hqz.demo.model.UserComment;
import com.hqz.demo.model.UserRegister;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private String user = "";
    private Logger logger = LoggerFactory.getLogger(GreetingController.class);
    private Map<String, User> userMap = new HashMap();
    private final UserDAO userDAO;
    private final UserDAORegister userDAORegister;
    private final UserDAOComment userDAOComment;

    @Autowired
    public GreetingController(UserDAO userDAO, UserDAORegister userDAORegister, UserDAOComment userDAOComment) {
        this.userDAO = userDAO;
        this.userDAORegister = userDAORegister;
        this.userDAOComment = userDAOComment;
    }

    @GetMapping({"/greeting"})
    public String greeting(HttpServletRequest request, @RequestParam("comment") String comment) {
        logger.info("comment:{}", comment);
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        String username = (String)request.getSession().getAttribute("uer");
        User user = new User();
        user.setUserName(username);
        user.setContent(comment);
        this.userDAO.insert(user);
        return "<script type=\"text/javascript\">window.location.href = \"http://y-yu.com/userpage.html\";</script>";
    }

    @GetMapping({"/posting"})
    public Object reading() {
        return this.userDAO.selectAll();
    }

    @GetMapping({"/op"})
    public Object sex(HttpServletRequest request, @RequestParam("userName") String userName) {
        return this.userDAORegister.selectony((String)request.getSession().getAttribute("uer"));
    }

    @GetMapping({"/loging"})
    public Map<String, Object> loging(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password) throws ServletException, IOException {
        List<UserRegister> users = this.userDAORegister.selectAll(userName, password);
        if (users.isEmpty()) {
            Map<String, Object> result = new HashMap();
            result.put("code", 11);
            result.put("msg", "密码或用户名错误");
            return result;
        } else {
            UserRegister ur = (UserRegister)users.get(0);
            request.getSession().setAttribute("uer", ur.getnickName());
            Map<String, Object> result = new HashMap();
            result.put("code", 1);
            result.put("data", users.get(0));
            result.put("msg", "登录成功");
            return result;
        }
    }

    @GetMapping({"/re"})
    public Object readingUser(HttpServletRequest request) {
        String username = (String)request.getSession().getAttribute("uer");
        this.logger.info("nicknamerere:{}", username);
        return this.userDAORegister.userIf(username);
    }

    @GetMapping({"/yanz"})
    public String yanzuser(HttpServletRequest request) {
        return request.getSession().getAttribute("uer") == null ? "0" : "1";
    }

    @GetMapping({"/getUserInfo"})
    public Object getUserInfo(HttpSession session) {
        String userName = (String)session.getAttribute("uer");
        this.logger.info("nickname2:{} sessionId: {}", userName, session.getId());
        return this.userDAORegister.selectony(userName);
    }

    @GetMapping({"/register"})
    public String register(HttpServletRequest request, @RequestParam("nickName") String nickName, @RequestParam("sex") String sex, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email, @RequestParam("passwd") String passwd, @RequestParam("age") String age, @RequestParam("dream") String dream) {
        this.logger.info("nickName:{},sex:{}，phoneNumber：{},email:{},passwd:{},age:{},dream:{}", new Object[]{nickName, sex, phoneNumber, email, passwd, age, dream});
        UserRegister userRegister = new UserRegister();
        request.getSession().setAttribute("ue", nickName);
        userRegister.setNickName(nickName);
        userRegister.setAge(age);
        userRegister.setDream(dream);
        userRegister.setEmail(email);
        userRegister.setPasswd(passwd);
        userRegister.setPhoneNumber(phoneNumber);
        userRegister.setSex(sex);
        this.userDAORegister.insert2(userRegister);
        return "<script type=\"text/javascript\">window.location.href = \"http://y-yu.com\";</script>";
    }

    @GetMapping({"/comment"})
    public String comment(HttpServletRequest request, @RequestParam("cmid") String cmid, @RequestParam("comment") String comment, @RequestParam("ame") String busername) {
        int cmidint = Integer.parseInt(cmid.trim());
        String username = (String)request.getSession(true).getAttribute("uer");
        comment = username + " : " + comment;
        UserComment userComment = new UserComment();
        userComment.setCmid(cmidint);
        userComment.setCmusername(username);
        userComment.setComment(comment);
        userComment.setBusername(busername);
        this.userDAOComment.insert(userComment);
        return "1";
    }

    @GetMapping({"/getcomment"})
    public Object getcomment() {
        return this.userDAOComment.selectCmId();
    }
}
