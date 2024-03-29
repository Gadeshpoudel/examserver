package com.exam.examserver.ripo;

import com.exam.examserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

    public  User findByUsername(String username);
}
