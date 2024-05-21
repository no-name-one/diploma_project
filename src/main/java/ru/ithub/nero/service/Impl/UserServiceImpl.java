package ru.ithub.nero.service.Impl;

import ru.ithub.nero.model.User;
import jakarta.inject.Singleton;
import ru.ithub.nero.model.dto.CreateUserDto;
import ru.ithub.nero.model.dto.UserDto;
import ru.ithub.nero.model.exception.CustomException;
import ru.ithub.nero.model.exception.ExceptionMessage;
import ru.ithub.nero.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class UserServiceImpl implements UserService {

    private final List<UserDto> storage = new ArrayList<>();
    {
        storage.add(new UserDto(UUID.randomUUID(), "Ball", 12, "ball@gmail.com"));
        storage.add(new UserDto(UUID.randomUUID(), "Green", 14, "green@gmail.com"));
        storage.add(new UserDto(UUID.randomUUID(), "Carry", 20, "carry@gmail.com"));
        storage.add(new UserDto(UUID.randomUUID(), "Moon", 10, "moon@gmail.com"));
    }

    @Override
    public List<UserDto> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public UserDto getById(UUID uuid) {
        for (UserDto userDto : storage) {
            if (userDto.getUuid().equals(uuid)) {
                return userDto;
            }
        }
        throw new CustomException(ExceptionMessage.NOT_FOUND_WITH_ID);
    }

    private boolean existByName(String name) {
        for (UserDto userDto : storage) {
            if (userDto.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean existByEmail(String email) {
        for(UserDto userDto : storage) {
            if (userDto.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CreateUserDto create(CreateUserDto createUserDto) {
        if (existByName(createUserDto.getName())) {
            throw new CustomException(ExceptionMessage.ALREADY_EXIST_WITH_USERNAME);
        }
        UserDto userDto = new UserDto(UUID.randomUUID(), createUserDto.getName(), createUserDto.getAge(), createUserDto.getEmail());
        storage.add(userDto);

        return createUserDto;
    }

    @Override
    public UserDto update(UserDto userDto) {
        for (UserDto existing : storage) {
            if (existing.getUuid().equals(userDto.getUuid())) {
                if (!existByName(userDto.getName())) {
                    existing.setName(userDto.getName());
                } else {
                    throw new CustomException(ExceptionMessage.ALREADY_EXIST_WITH_USERNAME);
                }

                if (userDto.getAge() > 0 && userDto.getAge() < 200) {
                    existing.setAge(userDto.getAge());
                }

                if (!existing.getEmail().equals(userDto.getEmail())) {
                    existing.setEmail(userDto.getEmail());
                }
                break;
            }
            throw new CustomException(ExceptionMessage.NOT_FOUND_WITH_ID);
        }
        return userDto;
    }

    @Override
    public void deleteById(UUID uuid) {
        boolean isDeleted = false;
        for (UserDto userDto : storage) {
            if (userDto.getUuid().equals(uuid)) {
                storage.remove(userDto);
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            throw new CustomException(ExceptionMessage.NOT_FOUND_WITH_ID);
        }
    }
}

