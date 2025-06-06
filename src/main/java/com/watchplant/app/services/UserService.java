package com.watchplant.app.services;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.entities.User;
import com.watchplant.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

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

}
