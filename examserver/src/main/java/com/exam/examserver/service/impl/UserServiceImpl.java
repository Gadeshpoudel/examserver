package com.exam.examserver.service.impl;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.ripo.RoleRepository;
import com.exam.examserver.ripo.UserRepository;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override


        public User createUser(User user, Set<UserRole> userRoles) throws Exception {
            User local = this.userRepository.findByUsername(user.getUsername());

        if (local != null)
        {
            System.out.println("User ia already exist!!");
            throw new Exception("User already present!!");

        }
        else {
for (UserRole ur:userRoles)
{
    roleRepository.save(ur.getRole());
}

user.getUserRoles().addAll(userRoles);
local = this.userRepository.save(user);



        }
        return local;
    }
}
