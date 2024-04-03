package com.company.controller;


import com.company.dao.inter.UserRepository;
import com.company.dto.UserDTO;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//! @Controller
public class UserRestContoller {


    @Autowired
    private UserRepository userRepo;
//    public UserRestContoller(@Qualifier("userRepository") UserRepository userRepository) {
//        this.userRepo = userRepository;
//    }


//    @GetMapping("/usersOld") //! Evveller bele yazilirdi
//    public @ResponseBody
//    String getUsersOld() {
//        return "usersOld - 2,3";
//    }


//    @GetMapping("/usersOther")
//    public String getUsersOther() {
//        return new ResponseEntity<String>("usersOther", HttpStatus.OK).getBody();
//    }


    @GetMapping("/users")
    public ResponseEntity getUsers() {
        List<User> users = userRepo.getAll(null, null, null);

        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

//      return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
//      return ResponseEntity.badRequest().body(userDTOS);
//      return ResponseEntity.ok().body(userDTOS);
        return ResponseEntity.ok(userDTOS);

    }


}
