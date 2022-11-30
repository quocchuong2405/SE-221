package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.TaskDto;
import entity.Task;
import repository.TaskRepository;
import service.TaskService;

@Service
@Transactional(rollbackOn = Exception.class)
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<TaskDto> findAll() {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		
		List<Task> tasks = taskRepository.findAll();
		
		for (Task Task : tasks) {
			dtos.add(new TaskDto(Task.getId(), Task.getStart_date(), Task.getEnd_date(), Task.getIsComplete()));
		}
		return dtos;
	}
	
	@Override
	public TaskDto findById(int id) {
		Task Task = taskRepository.findById(id).get();
		return new TaskDto(Task.getId(), Task.getStart_date(), Task.getEnd_date(), Task.getIsComplete());
	}

	@Override
	public void add(TaskDto dto) {
		Task Task = new Task();
		Task.setStart_date(dto.getStart_date());
		Task.setEnd_date(dto.getEnd_date());
		Task.setIsComplete(dto.getIsComplete());
		
		taskRepository.save(Task);
	}

	@Override
	public void update(TaskDto dto) {
		Task Task = taskRepository.findById(dto.getId()).get();
		Task.setStart_date(dto.getStart_date());
		Task.setEnd_date(dto.getEnd_date());
		Task.setIsComplete(dto.getIsComplete());
	}

	@Override
	public void delete(int id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<TaskDto> search(String keyword) {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		List<Task> tasks = taskRepository.search(keyword);
		for (Task Task : tasks) {
			dtos.add(new TaskDto(Task.getId(), Task.getStart_date(), Task.getEnd_date(), Task.getIsComplete()));
		}		
			return dtos;
	}
}
