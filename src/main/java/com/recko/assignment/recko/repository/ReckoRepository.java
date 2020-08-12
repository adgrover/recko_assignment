package com.recko.assignment.recko.repository;

import com.recko.assignment.recko.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReckoRepository extends JpaRepository<User, String>{

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE id = :id")
    public User findUser(@Param("id") String userId);

}
