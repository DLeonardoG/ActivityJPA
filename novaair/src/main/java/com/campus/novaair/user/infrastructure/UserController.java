package com.campus.novaair.user.infrastructure;

import com.campus.novaair.user.application.UserServiceImpl;
import com.campus.novaair.user.domain.User;
import com.campus.novaair.user.domain.UserDTO;
import com.campus.novaair.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired

    private UserServiceImpl userServiceImpl;
    @Autowired

    private UserRepository userRepository;
    @Autowired

    private PasswordEncoder passwordEncoder;

    // Registro de usuario (cifrado de contraseña)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email is already taken.", HttpStatus.BAD_REQUEST);
        }

        // Hashing la contraseña antes de guardarla
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return userServiceImpl.findAll();
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<UserDTO> user = userServiceImpl.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userServiceImpl.save(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userServiceImpl.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if (userServiceImpl.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userDTO.setId(id);
        UserDTO updatedUser = userServiceImpl.save(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
