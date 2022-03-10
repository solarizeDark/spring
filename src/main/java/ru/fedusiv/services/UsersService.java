package ru.fedusiv.services;

import org.springframework.stereotype.Service;
import ru.fedusiv.entities.User;

@Service
public interface UsersService {

    User findByUsername(String username);

}
