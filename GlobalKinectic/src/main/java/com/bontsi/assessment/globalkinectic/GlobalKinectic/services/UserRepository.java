package com.bontsi.assessment.globalkinectic.GlobalKinectic.services;

import com.bontsi.assessment.globalkinectic.GlobalKinectic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String Password);
}
