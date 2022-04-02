package ru.fedusiv.repositories.people;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface TemplateRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);
    Iterable<T> findAll();
    <S extends T> S save(S entity);

}
