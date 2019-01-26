package com.example.power2peer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.power2peer.models.Meter;
import com.example.power2peer.repositories.MeterRepository;

@RestController
public class MeterService {
	@Autowired
	MeterRepository meterRepository;
	@GetMapping("/api/meters")
	public List<Meter> findAllMeters() {
		return meterRepository.findAllMeters();
	}
	@GetMapping("/api/meters/{id}")
	public Meter findMeterById(@PathVariable("id") Integer id) {
		return meterRepository.findMeterById(id);
	}
	@PostMapping("/api/meters")
	public Meter createMeter(@RequestBody Meter meter) {
		return meterRepository.save(meter);
	}
	@DeleteMapping("/api/meters/{id}")
	public void deleteMeterById(@PathVariable("id") Integer id) {
		meterRepository.deleteById(id);
	}
	@PutMapping("/api/meters/{id}")
	public Meter updateMeter(@PathVariable("id") Integer id, @RequestBody Meter meterUpdates) {
		Meter meter = meterRepository.findMeterById(id);
		meter.setTitle(meterUpdates.getTitle());
		return meterRepository.save(meter);
	}
}
