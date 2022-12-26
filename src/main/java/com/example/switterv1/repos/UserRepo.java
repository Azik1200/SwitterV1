package com.example.switterv1.repos;

import com.example.switterv1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
    @Query("select u from User u where u.email like CONCAT('%', :email, '%')")
    List<User> findUserCustom(String email);
}
