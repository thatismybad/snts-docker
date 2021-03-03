package dev.thatismybad.dockerapi.base;

import java.util.List;

public interface BaseCrudService<T> {
    T create(T t);

    T read(long id);

    List<T> readAll();

    T update(T t);

    void delete(long id);
}
