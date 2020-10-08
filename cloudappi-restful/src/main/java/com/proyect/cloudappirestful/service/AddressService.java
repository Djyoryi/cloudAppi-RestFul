package com.proyect.cloudappirestful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.cloudappirestful.entity.User;

public interface AddressService extends JpaRepository<User, Integer>{

}
