//package com.campus.novaair.passangers.infrastructure;
//
//
//import com.campus.novaair.passangers.application.UserServiceImpl;
//import com.campus.novaair.passangers.domain.User;
//import com.campus.novaair.passangers.domain.UserDTO;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    
//    private final UserServiceImpl userServiceImpl;
//    
//    @Autowired
//    public UserController(UserServiceImpl userServiceImpl){
//        this.userServiceImpl = userServiceImpl;
//    }
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        // Hashing la contraseña antes de guardarla
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return "User registered successfully!";
//    }
//    
//    @GetMapping
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public List<UserDTO> getAllUser(){
//        return userServiceImpl.findAll();
//    }
//    
//    @GetMapping("/{id}")
//    public Optional findById(@PathVariable Long id){
//        return userServiceImpl.findById(id);
//    }
//    
//    
//    @PostMapping
//    public UserDTO createUser(@RequestBody UserDTO passangerDTO){
//        return userServiceImpl.save(passangerDTO);
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
//        userServiceImpl.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//    @PutMapping("/{id}")
//    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO passangerDTO){
//        passangerDTO.setId(id);
//        return userServiceImpl.save(passangerDTO);
//    }
//    
//    
//}
