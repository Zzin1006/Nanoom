package com.nanoom.nanoom.controller.user;

import com.nanoom.nanoom.controller.user.dto.RegisterUserDTO;
import com.nanoom.nanoom.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController("/users")
public class UserController {

    @Autowired
    UserService userService;


    //회원등록
    @PostMapping("")
    public void joinFrom(@RequestBody RegisterUserDTO registerUserDTO) {

        String uid;

            int leftLimit = 97;
            int rightLimit = 122;
            int length = 10;

            Random random = new Random();
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(length)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            uid = generatedString;

        userService.register(uid,registerUserDTO.getNickname());
    }
}


