package ru.ithub.nero.controller;

import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.server.cors.CrossOrigin;
import io.micronaut.http.server.types.files.StreamedFile;
import io.micronaut.views.ModelAndView;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import ru.ithub.nero.model.User;
import ru.ithub.nero.model.dto.CreateUserDto;
import ru.ithub.nero.model.dto.UserDto;
import ru.ithub.nero.service.Impl.UserServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.views.View;
import ru.ithub.nero.service.UserService;

import java.util.List;
import java.util.UUID;

@Controller("/api")
@CrossOrigin("http://localhost:8081")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @Get("/users")
    public HttpResponse<List<UserDto>> getUsers() {
        return HttpResponse.ok(service.findAll());
    }
//
//    @Get("/view")
//    @View("home.html")
//    public HttpResponse<?> index() {
//        return HttpResponse.ok();
//    }

    @Get("/{uuid}")
    public HttpResponse<UserDto> getUserById(@PathVariable UUID uuid) {
        return HttpResponse.ok(service.getById(uuid));
    }

    @Post
    public HttpResponse<CreateUserDto> createUser(@Valid @Body CreateUserDto createUserDto) {
        return HttpResponse.created(service.create(createUserDto));
    }

    @Put
    public HttpResponse<UserDto> updateUser(@Body UserDto userDto) {
        return HttpResponse.ok(service.update(userDto));
    }

    @Delete("/{uuid}")
    public void deleteUser(@PathVariable UUID uuid) {
        service.deleteById(uuid);
    }
}