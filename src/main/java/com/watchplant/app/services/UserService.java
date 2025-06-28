package com.watchplant.app.services;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.entities.User;
import com.watchplant.app.repositories.UserRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.UserContext;
import org.springframework.http.HttpStatus;
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

    public GetUserResponseDTO getByEmail(String email) {
        User user = userRepository.findById(email)
            .orElseThrow(() -> new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND));
        return new GetUserResponseDTO(user);
    }

    public UpdateUserResponseDTO updateUser(UpdateUserRequestDTO dto) {
        String email = UserContext.getUserEmail();

        User user = userRepository.findById(email)
            .orElseThrow(() -> new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND));

        dto.getName().ifPresent(user::setName);
        dto.getPhone().ifPresent(user::setPhone);

        userRepository.save(user);
        return new UpdateUserResponseDTO(user);
    }

    public void deleteUser(String email) {
        if (!userRepository.existsById(email)) {
            throw new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(email);
    }

}
