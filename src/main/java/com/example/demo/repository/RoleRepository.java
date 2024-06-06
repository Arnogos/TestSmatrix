package com.example.demo.repository;

import java.util.Optional;

import Try.ERole;
import com.example.demo.enity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}