package ru.sakhnenko.spring.another.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.another.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
