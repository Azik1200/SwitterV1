package com.example.switterv1.repos;

import com.example.switterv1.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    Iterable<Message> findByTag(String filter);
}
