package com.appu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appu.beans.UserDetails;


@Repository
public interface UserRepository extends  JpaRepository<UserDetails, Long>{

}
