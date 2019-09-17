package com.springsec.app.repositories;

import com.springsec.app.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
     UserDetails findByUsername(String userName);
}
