package ru.fedusiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.fedusiv.UserForm;
import ru.fedusiv.repositories.UsersRepository;

public interface SignUpService {

    void save(UserForm form);

}
