package com.example.power2peer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.power2peer.models.Meter;

public interface MeterRepository extends CrudRepository<Meter, Integer> {
	@Query(value="SELECT meter FROM Meter meter")
	public List<Meter> findAllMeters();
	@Query(value="SELECT meter FROM Meter meter WHERE meter.id=:id")
	public Meter findMeterById(@Param("id") Integer id);
	@Query(value="DELETE FROM Meter meter WHERE meter.id=:id")
	public void deleteMeterById(@Param("id") Integer id);
}
