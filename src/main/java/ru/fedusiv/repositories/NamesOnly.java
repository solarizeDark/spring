package ru.fedusiv.repositories;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NamesOnly {

    String getName();
    String getSurname();



}
