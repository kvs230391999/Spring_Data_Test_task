package org.example.app.controller;

import org.example.app.entity.user.User;
import org.example.app.network.ResponseData;
import org.example.app.network.ResponseMessage;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public ResponseData save(@RequestBody User user) {
        Optional<User> optional = service.save(user);
        return optional.map(value ->
                        new ResponseData(HttpStatus.CREATED.toString(),
                                true, value))
                .orElseGet(() ->
                        new ResponseData(HttpStatus.NO_CONTENT.toString(),
                                false,
                                ResponseMessage.SMTH_WRONG.getResMsg()));
    }

    @GetMapping("/users")
    public ResponseData getAll() {
        Optional<List<User>> optional = service.getAll();
        return optional.map(users ->
                new ResponseData(HttpStatus.OK.toString(),
                        true, users))
                .orElseGet(() ->
                        new ResponseData(HttpStatus.NOT_FOUND.toString(),
                                false,
                                ResponseMessage.SMTH_WRONG.getResMsg()));
    }

    @GetMapping("/users/{id}")
    public ResponseData getById(@PathVariable Long id) {
        User user = service.getById(id);
        if (user != null)
            return new ResponseData(HttpStatus.OK.toString(),
                    true, user);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @PutMapping("/users/{id}")
    public ResponseData update(@PathVariable Long id,
                               @RequestBody User user) {
        User userUpdated = service.update(id, user);
        if (userUpdated != null)
            return new ResponseData(HttpStatus.OK.toString(),
                    true, userUpdated);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @DeleteMapping("/users/{id}")
    public ResponseData delete(@PathVariable Long id){
        if (service.delete(id))
            return new ResponseData(HttpStatus.OK.toString(),
                    true, ResponseMessage.DELETED.getResMsg());
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @GetMapping("/users/username/{username}")
    public ResponseData getByUserName(@PathVariable String username) {
        List<User> list = service.getByUserName(username);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }

    @GetMapping("/users/comment/{comment}")
    public ResponseData getByComment(@PathVariable String comment) {
        List<User> list = service.getByComment(comment);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }
}
