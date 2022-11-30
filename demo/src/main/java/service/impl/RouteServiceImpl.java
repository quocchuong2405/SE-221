package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.RouteDto;
import entity.Route;
import repository.RouteRepository;
import service.RouteService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public List<RouteDto> findAll() {
		List<RouteDto> dtos = new ArrayList<RouteDto>();
		
		List<Route> routes = routeRepository.findAll();
		
		for (Route Route : routes) {
			dtos.add(new RouteDto(Route.getId(), Route.getName(), Route.getLength()));
		}
		return dtos;
	}
	
	@Override
	public RouteDto findById(int id) {
		Route Route = routeRepository.findById(id).get();
		return new RouteDto(Route.getId(), Route.getName(), Route.getLength());
	}

	@Override
	public void add(RouteDto dto) {
		Route Route = new Route();
		Route.setName(dto.getName());
		Route.setLength(dto.getLength());
		
		routeRepository.save(Route);
	}

	@Override
	public void update(RouteDto dto) {
		Route Route = routeRepository.findById(dto.getId()).get();
		Route.setName(dto.getName());
		Route.setLength(dto.getLength());
	}

	@Override
	public void delete(int id) {
		routeRepository.deleteById(id);
	}

	@Override
	public List<RouteDto> search(String keyword) {
		List<RouteDto> dtos = new ArrayList<RouteDto>();
		List<Route> routes = routeRepository.search(keyword);
		for (Route Route : routes) {
			dtos.add(new RouteDto(Route.getId(), Route.getName(), Route.getLength()));
		}		
			return dtos;
	}
}
