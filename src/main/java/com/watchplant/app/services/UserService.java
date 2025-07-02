package com.watchplant.app.services;

import com.watchplant.app.dtos.user.GetUserResponseDTO;
import com.watchplant.app.dtos.user.UpdateUserRequestDTO;
import com.watchplant.app.dtos.user.UpdateUserResponseDTO;
import com.watchplant.app.entities.Address;
import com.watchplant.app.entities.User;
import com.watchplant.app.repositories.UserRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.UserContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public GetUserResponseDTO getByEmail(String email) {
        User user = userRepository.findById(email)
            .orElseThrow(() -> new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND));
        return new GetUserResponseDTO(user);
    }

    @Transactional
    public UpdateUserResponseDTO updateUser(UpdateUserRequestDTO dto) {
        String email = UserContext.getUserEmail();

        User user = userRepository.findById(email)
            .orElseThrow(() -> new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND));

        dto.getName().ifPresent(user::setName);
        dto.getPhone().ifPresent(user::setPhone);
        
        dto.getAddress().ifPresent(addressDTO -> {
            Address address = user.getAddress();
            if (address == null) {
                address = new Address(
                    addressDTO.getZipCode(),
                    addressDTO.getStreet(),
                    addressDTO.getNumber(),
                    addressDTO.getNeighborhood(),
                    user
                );
                user.setAddress(address);
            } else {
                address.setZipCode(addressDTO.getZipCode());
                address.setStreet(addressDTO.getStreet());
                address.setNumber(addressDTO.getNumber());
                address.setNeighborhood(addressDTO.getNeighborhood());
            }
        });

        userRepository.save(user);
        return new UpdateUserResponseDTO(user);
    }

    public void deleteUser() {
        String email = UserContext.getUserEmail();

        if (!userRepository.existsById(email)) {
            throw new ApplicationException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(email);
    }

}
