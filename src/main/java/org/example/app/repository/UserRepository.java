package org.example.app.repository;

import org.example.app.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// @Repository - варіант @Component, який повідомляє Spring, що це компонент,
// яким має керувати контейнер IoC.
// Зокрема, репозиторії призначені визначення логіки для шару збереження.
//
// CrudRepository забезпечує CRUD методи.
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
//
// CrudRepository приймає клас сутності, а також тип даних ID,
// який він повинен використовувати для запиту.
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<List<User>> findByUserName(String username);
    Optional<List<User>> findByComment(String comment);
}
