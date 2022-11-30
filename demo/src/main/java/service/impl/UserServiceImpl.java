package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import dto.UserDto;
import entity.User;
import repository.UserRepository;
import service.UserService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void add(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());	
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
	//	user.setPassword(dto.getPassword());
		user.setPhone_number(dto.getPhone_number());
		user.setBirthday(dto.getBirthday());
		
		userRepository.save(user);
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		List<User> users = userRepository.findAll();
		for (User user : users) {
			dtos.add(new UserDto(user.getId(), user.getUsername(), 
					user.getEmail(),user.getPhone_number() , 
					user.getIsAvailable(),user.getPassword() , 
					user.getBirthday(), user.getRegisdate()));
		}
		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		User user = userRepository.findById(id).get();
		return new UserDto(user.getId(), user.getUsername(), 
				user.getEmail(),user.getPhone_number() , 
				user.getIsAvailable(),user.getPassword() , 
				user.getBirthday(), user.getRegisdate());
	}

	@Override
	public void update(UserDto dto) {
		User user = userRepository.findById(dto.getId()).get();
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setIsAvailable(dto.getIsAvailable());
		user.setPhone_number(dto.getPhone_number());
		user.setBirthday(dto.getBirthday());
		user.setRegisdate(dto.getRegisdate());
		userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);	
	}

	@Override
	public List<UserDto> search(String keyword) {
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userRepository.search(keyword);
		for (User user : users) {
			dtos.add(new UserDto(user.getId(), user.getUsername(), 
					user.getEmail(),user.getPhone_number() , 
					user.getIsAvailable(),user.getPassword() , 
					user.getBirthday(), user.getRegisdate()));
		}
		
		return dtos;
	}

}
