package ru.ithub.nero.service;

import ru.ithub.nero.model.User;
import ru.ithub.nero.model.dto.CreateUserDto;
import ru.ithub.nero.model.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> findAll();
    UserDto getById(UUID uuid);
    CreateUserDto create(CreateUserDto createUserDto);
    UserDto update(UserDto userDto);
    void deleteById(UUID uuid);
}
