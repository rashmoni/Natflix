package com.novare.natflix.Controller;
/*
import com.novare.natflix.Entity.User;
import com.novare.natflix.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public String Signup(@RequestBody User data) {
        User user = User.builder()
                .userName(data.getUserName())
                .password(passwordEncoder.encode(data.getPassword()))
                .roles("ROLE_USER")
                .active(true)
                .build();
        userRepository.save(user);

        return (user.toString());
    }

}
*/