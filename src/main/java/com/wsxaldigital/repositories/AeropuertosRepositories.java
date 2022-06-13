package com.wsxaldigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsxaldigital.entity.AeropuertosEntity;

@Repository
public interface AeropuertosRepositories extends JpaRepository<AeropuertosEntity, Long> {

}
