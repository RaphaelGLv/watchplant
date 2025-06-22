package com.watchplant.app.services;

import com.watchplant.app.dtos.address.CreateAddressRequestDto;
import com.watchplant.app.dtos.auth.CreateUserAccountRequestDTO;
import com.watchplant.app.dtos.user.CreateUserRequestDTO;
import com.watchplant.app.dtos.auth.LoginRequestDTO;
import com.watchplant.app.dtos.auth.JwtTokenResponseDTO;
import com.watchplant.app.entities.Address;
import com.watchplant.app.entities.User;
import com.watchplant.app.entities.UserAccount;
import com.watchplant.app.repositories.AddressRepository;
import com.watchplant.app.repositories.UserAccountRepository;
import com.watchplant.app.repositories.UserRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;
    private final AddressRepository addressRepository;
    private final JwtService jwtService;

    AuthService(UserRepository userRepository, UserAccountRepository userAccountRepository, AddressRepository addressRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
        this.addressRepository = addressRepository;
        this.jwtService = jwtService;
    }

    public JwtTokenResponseDTO createUser(CreateUserRequestDTO body) throws ApplicationException {
        CreateUserAccountRequestDTO accountBody = body.getAccount();
        CreateAddressRequestDto addressBody = body.getAddress();

        Address newAddress = new Address(addressBody.getZipCode(), addressBody.getStreet(), addressBody.getNumber(), addressBody.getNeighborhood());

        addressRepository.save(newAddress);

        UserAccount newUserAccount = new UserAccount(accountBody.getEmail(), accountBody.getPassword(), 0);

        UserAccount userAccount = userAccountRepository.findByEmail(accountBody.getEmail());

        if (userAccount != null) throw new ApplicationException("O email já foi utilizado", HttpStatus.CONFLICT);

        User newUser = new User(body.getName(), accountBody.getEmail(), body.getPhone(), newAddress.getId(), newUserAccount);
        userRepository.save(newUser);

        return new JwtTokenResponseDTO(jwtService.generateToken(newUser.getId().toString()));
    }

    public JwtTokenResponseDTO login(LoginRequestDTO body) throws ApplicationException {
        UserAccount userAccount = userAccountRepository.findByEmail(body.getEmail());

        if (
                userAccount == null ||
                !userAccount.getPassword().equals(body.getPassword())
        ) throw new ApplicationException("Email ou senha estão incorretos.", HttpStatus.UNAUTHORIZED);

        User user = userRepository.findByAccount_Id(userAccount.getId());

        return new JwtTokenResponseDTO(jwtService.generateToken(user.getId().toString()));
    }
}
