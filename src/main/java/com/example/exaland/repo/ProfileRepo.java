package com.example.exaland.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exaland.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long>{

}
