package service;

import java.util.List;

import dto.AnnouncementDto;

public interface AnnouncementService {
	List<AnnouncementDto> findAll();
	AnnouncementDto findById(int id);
	void add(AnnouncementDto dto);
	void update(AnnouncementDto dto);
	void delete(int id);
	public List<AnnouncementDto> search(String keyword);
}
