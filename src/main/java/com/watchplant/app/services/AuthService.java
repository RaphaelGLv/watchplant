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
    private final PasswordEncryptService passwordEncoder;
    private final AddressRepository addressRepository;
    private final JwtService jwtService;

    AuthService(UserRepository userRepository, UserAccountRepository userAccountRepository, PasswordEncryptService passwordEncoder, AddressRepository addressRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.jwtService = jwtService;
    }

    public JwtTokenResponseDTO createUser(CreateUserRequestDTO body) throws ApplicationException {
        CreateUserAccountRequestDTO accountBody = body.getAccount();
        CreateAddressRequestDto addressBody = body.getAddress();

        boolean userAccountExists = userAccountRepository.existsById(accountBody.getEmail());
        if (userAccountExists) throw new ApplicationException("O email já foi utilizado", HttpStatus.CONFLICT);

        User newUser = new User(body.getName(), accountBody.getEmail(), body.getPhone());

        Address newAddress = new Address(addressBody.getZipCode(), addressBody.getStreet(), addressBody.getNumber(), addressBody.getNeighborhood(), newUser);
        newUser.setAddress(newAddress);

        UserAccount newUserAccount = new UserAccount(passwordEncoder.encrypt(accountBody.getPassword()), newUser);
        newUser.setAccount(newUserAccount);

        userRepository.save(newUser);

        return new JwtTokenResponseDTO(jwtService.generateToken(newUserAccount.getEmail()));
    }

    public JwtTokenResponseDTO login(LoginRequestDTO body) throws ApplicationException {
        try {
            UserAccount userAccount = userAccountRepository.findById(body.getEmail()).orElseThrow(() ->
                            new ApplicationException("Email ou senha estão incorretos.", HttpStatus.UNAUTHORIZED)
                    );

            if (userAccount.isBlocked())
                throw new ApplicationException("Conta bloqueada por excesso de tentativas.", HttpStatus.UNAUTHORIZED);

            if (!passwordEncoder.matches(body.getPassword(), userAccount.getPassword())) {
                this.incrementLoginTries(userAccount);
                throw new ApplicationException("Email ou senha estão incorretos.", HttpStatus.UNAUTHORIZED);
            }


            return new JwtTokenResponseDTO(jwtService.generateToken(userAccount.getEmail()));
        } catch (ApplicationException e) {
            throw new ApplicationException("Email ou senha estão incorretos.", HttpStatus.UNAUTHORIZED);
        }
    }

    private void incrementLoginTries(UserAccount userAccount) {
        userAccount.incrementLoginTries();
        userAccountRepository.save(userAccount);
    }
}
