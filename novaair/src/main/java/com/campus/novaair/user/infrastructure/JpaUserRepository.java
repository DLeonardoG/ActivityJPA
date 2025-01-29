package com.campus.novaair.user.infrastructure;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerRepository;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.user.domain.User;
import com.campus.novaair.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository{
    
}
