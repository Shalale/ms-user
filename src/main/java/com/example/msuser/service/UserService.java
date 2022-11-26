package com.example.msuser.service;

import com.example.msuser.model.constants.Status;
import com.example.msuser.model.dto.UserDto;
import com.example.msuser.model.dto.UserRequest;
import com.example.msuser.dao.entity.User;
import com.example.msuser.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserDto createUser(UserRequest request){
        var user = mapper.map(request, User.class);
        repository.save(user);

        return mapper.map(user, UserDto.class);
    }

    public UserDto getUser(Long id){
        var user = fetchIfExist(id);
        return mapper.map(user, UserDto.class);
    }

    public Long getUserId(String username){
        var user= repository.getUserByUsername(username);

        return user.getId();
    }

    public void deleteUser(Long id){
        var user = fetchIfExist(id);
        user.setStatus(Status.DEACTIVATE);
        repository.save(user);
    }

    private User fetchIfExist(Long id){
        return repository.findById(id).orElseThrow();
    }
}
