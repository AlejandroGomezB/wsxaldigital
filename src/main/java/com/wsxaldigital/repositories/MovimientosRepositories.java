package com.wsxaldigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsxaldigital.entity.MovimientosEntity;

@Repository
public interface MovimientosRepositories extends JpaRepository<MovimientosEntity, Long> {

}
