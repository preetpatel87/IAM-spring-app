package com.iam.forum.config.security;

import com.iam.forum.model.dao.RBAC;
import com.iam.forum.model.dao.User;
import com.iam.forum.model.repository.RBACRepository;
import com.iam.forum.model.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class ForumServiceInterceptor implements HandlerInterceptor {

    private RBACRepository rbacRepository;
    private UserRepository userRepository;

    public ForumServiceInterceptor(RBACRepository rbacRepository, UserRepository userRepository) {
        this.rbacRepository = rbacRepository;
        this.userRepository = userRepository;
    }

    Logger logger = LoggerFactory.getLogger(ForumServiceInterceptor.class);
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String targetHandler = handler.toString().substring(handler.toString().lastIndexOf("#")+ 1, handler.toString().indexOf("("));
        
        if (targetHandler.equals("loginValidation") || targetHandler.equals("registerUser")){
            return true;
        }
        
        String username = request.getHeader("username");
        String password = request.getHeader("password");

        if (username == null || password == null) {
            logger.info("Username or password is Null");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        Optional<User> userResponse = userRepository.findById(username);

        if (userResponse.isEmpty()){
            logger.info("No user found!");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        if (!userResponse.get().getPassword().equals(password)){
            logger.info("Incorrect Password");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }


        List<String> roles = userResponse.get().getRole();
        logger.info("Roles: {}", roles.toString());
        if (roles.contains("Admin")){
            Optional<RBAC> rbac = rbacRepository.findById("Admin");
            if (rbac.isPresent()) {
                List<String> APIPermissions = rbac.get().getAPIPermissions();
                if (APIPermissions.contains(targetHandler)) {
                    return true;
                }
            }
        }
        else if (roles.contains("Moderator")){
            Optional<RBAC> rbac = rbacRepository.findById("Moderator");
            if (rbac.isPresent()) {
                List<String> APIPermissions = rbac.get().getAPIPermissions();
                if (APIPermissions.contains(targetHandler)) {
                    return true;
                }
            }
        }
        else if (roles.contains("Creator")){
            Optional<RBAC> rbac = rbacRepository.findById("Creator");
            if (rbac.isPresent()) {
                List<String> APIPermissions = rbac.get().getAPIPermissions();
                if (APIPermissions.contains(targetHandler)) {
                    return true;
                }
            }
        }
        else if (roles.contains("Viewer")) {
            Optional<RBAC> rbac = rbacRepository.findById("Viewer");
            if (rbac.isPresent()) {
                List<String> APIPermissions = rbac.get().getAPIPermissions();
                if (APIPermissions.contains(targetHandler)) {
                    return true;
                }
            }
        }

        logger.info("Missing Permission");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {}
}
