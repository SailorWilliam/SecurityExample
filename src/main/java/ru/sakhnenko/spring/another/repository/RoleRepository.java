package ru.sakhnenko.spring.another.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.another.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
    Role findByName(String name);
}
