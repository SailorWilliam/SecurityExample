package ru.sakhnenko.spring.another.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.another.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
