package com.wsxaldigital.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wsxaldigital.entity.VuelosEntity;

@Repository
public interface VuelosRepositories extends JpaRepository<VuelosEntity, Long> {
	
	@Query("SELECT v FROM VuelosEntity v WHERE YEAR(v.dia) = ?1 GROUP BY v.idAeropuerto ORDER BY COUNT(v.idAeropuerto) DESC ")
	public List<VuelosEntity> findMayorMovimientosAeropuerto(int año);
	
	@Query("SELECT v FROM VuelosEntity v WHERE v.idMovimiento.idMovimiento = 1 AND YEAR(v.dia) = ?1 GROUP BY v.idAerolinea ORDER BY COUNT(v.idAerolinea) DESC ")
	public List<VuelosEntity> findMayorNumeroVuelos(int año);
	
	@Query("SELECT v FROM VuelosEntity v WHERE v.idMovimiento.idMovimiento = 1 GROUP BY v.dia ORDER BY COUNT(v.dia) DESC ")
	public List<VuelosEntity> findMayorVuelosDia();
	
	@Query("SELECT v FROM VuelosEntity v WHERE (v.idMovimiento.idMovimiento = 1 AND v.dia BETWEEN ?1 and ?1) GROUP BY v.dia HAVING COUNT(v.dia)>2 ORDER BY COUNT(v.dia) DESC ")
	public List<VuelosEntity> findAerolineasMasDosVuelos(Date dia);

}
