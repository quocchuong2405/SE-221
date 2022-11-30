package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.MCPDto;
import entity.MCP;
import repository.McpRepository;
import service.MCPService;

@Service
@Transactional(rollbackOn = Exception.class)
public class MCPServiceImpl implements MCPService{
	@Autowired
	private McpRepository MCPRepository;
	
	@Override
	public List<MCPDto> findAll() {
		List<MCPDto> dtos = new ArrayList<MCPDto>();
		
		List<MCP> MCPs = MCPRepository.findAll();
		
		for (MCP MCP : MCPs) {
			dtos.add(new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getAltitude()));
		}
		return dtos;
	}
	
	@Override
	public MCPDto findById(int id) {
		MCP MCP = MCPRepository.findById(id).get();
		return new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getAltitude());
	}

	@Override
	public void add(MCPDto dto) {
		MCP MCP = new MCP();
		MCP.setFullness(dto.getFullness());
		MCP.setAltitude(dto.getAltitude());
		
		MCPRepository.save(MCP);
	}

	@Override
	public void update(MCPDto dto) {
		MCP MCP = MCPRepository.findById(dto.getId()).get();
		MCP.setFullness(dto.getFullness());
		MCP.setAltitude(dto.getAltitude());
	}

	@Override
	public void delete(int id) {
		MCPRepository.deleteById(id);
	}

	@Override
	public List<MCPDto> search(String keyword) {
		List<MCPDto> dtos = new ArrayList<MCPDto>();
		List<MCP> MCPs = MCPRepository.search(keyword);
		for (MCP MCP : MCPs) {
			dtos.add(new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getAltitude()));
		}		
			return dtos;
	}
}

