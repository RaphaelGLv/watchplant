package com.watchplant.app.services;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.entities.User;
import com.watchplant.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserResponseDTO> getAll() {
        List<User> userList = this.userRepository.findAll();
        List<GetUserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : userList) {
            userResponseDTOList.add(new GetUserResponseDTO(user));
        }

        return userResponseDTOList;
    }

    public GetUserResponseDTO getById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new GetUserResponseDTO(user);
    }

    public UpdateUserResponseDTO updateUser(UUID id, UpdateUserRequestDTO dto) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        dto.getName().ifPresent(user::setName);
        dto.getEmail().ifPresent(user::setEmail);
        userRepository.save(user);
        return new UpdateUserResponseDTO(user);
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }

}
