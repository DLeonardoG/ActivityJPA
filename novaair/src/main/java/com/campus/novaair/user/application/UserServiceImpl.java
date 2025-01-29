package com.campus.novaair.user.application;

import com.campus.novaair.user.domain.User;
import com.campus.novaair.user.domain.UserDTO;
import com.campus.novaair.user.domain.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(user);

    }

    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(),
                user.getEmail(),
                user.getPassword());
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getEmail(),
                userDTO.getPassword());
        return user;
    }
}
