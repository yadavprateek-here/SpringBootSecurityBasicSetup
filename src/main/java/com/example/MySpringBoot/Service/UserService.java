package com.example.MySpringBoot.Service;

import com.example.MySpringBoot.dto.SignupDto;
import com.example.MySpringBoot.dto.UserDto;
import com.example.MySpringBoot.exception.UserNotFoundException;
import com.example.MySpringBoot.model.User;
import com.example.MySpringBoot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final  UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper mapper;


    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.mapper = new ModelMapper();
    }

    public UserDto createUser(SignupDto user) {

        Optional<User> tmp = userRepository.findByUsername(user.getUsername());
        if(tmp.isPresent()) {
            throw new BadCredentialsException("Username already exists");
        }
        User toBeCreated = mapper.map(user, User.class);
        toBeCreated.setPassword(encoder.encode(user.getPassword()));
        User createdUser =  userRepository.save(toBeCreated);
        return mapper.map(createdUser, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("user Not found"));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user Not found"));
    }




}
