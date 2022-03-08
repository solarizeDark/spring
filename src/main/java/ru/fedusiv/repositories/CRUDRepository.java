package ru.fedusiv.repositories;

public interface CRUDRepository <T, ID> {

    T save(T entity);
    T findById(ID id);
    // long - amount of updated/deleted rows
    Long update(T entity);
    Long delete(T entity);

}
