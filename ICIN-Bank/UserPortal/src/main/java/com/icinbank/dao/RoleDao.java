package com.icinbank.dao;

import org.springframework.data.repository.CrudRepository;

import com.icinbank.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
