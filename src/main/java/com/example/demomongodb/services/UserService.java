package com.example.demomongodb.services;

import com.example.demomongodb.domain.User;
import com.example.demomongodb.dto.UserDTO;
import com.example.demomongodb.exception.ObjectNotFoudException;
import com.example.demomongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by loliveira on 25/12/18.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> byId = repository.findById(id);
        return byId.orElseThrow(() -> new ObjectNotFoudException("Value did not find"));
    }

    public User insert (User obj){
        return repository.save(obj);
    }

    public User update(User user) {
        Optional<User> obj = repository.findById(user.getId());
        updateData(obj.orElse(null), user);
        obj.ifPresent(f  -> repository.save(f));
        return obj.orElse(null);
    }

    private void updateData(User obj, User user) {
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
