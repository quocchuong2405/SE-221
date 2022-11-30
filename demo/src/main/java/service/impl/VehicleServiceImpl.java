package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.VehicleDto;
import entity.Vehicle;
import repository.VehicleRepository;
import service.VehicleService;


@Service
@Transactional(rollbackOn = Exception.class)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleDto> findAll() {
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		for (Vehicle Vehicle : vehicles) {
			dtos.add(new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel()));
		}
		return dtos;
	}
	
	@Override
	public VehicleDto findById(int id) {
		Vehicle Vehicle = vehicleRepository.findById(id).get();
		return new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel());
	}

	@Override
	public void add(VehicleDto dto) {
		Vehicle Vehicle = new Vehicle();
		Vehicle.setCurrent_fuel(dto.getCurrent_fuel());
		
		vehicleRepository.save(Vehicle);
	}

	@Override
	public void update(VehicleDto dto) {
		Vehicle Vehicle = vehicleRepository.findById(dto.getId()).get();
		Vehicle.setCurrent_fuel(dto.getCurrent_fuel());
	}

	@Override
	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	public List<VehicleDto> search(String keyword) {
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		List<Vehicle> vehicles = vehicleRepository.search(keyword);
		for (Vehicle Vehicle : vehicles) {
			dtos.add(new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel()));
		}		
			return dtos;
	}
}
