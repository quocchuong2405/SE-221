package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 
	@Query("SELECT u FROM MCP u WHERE u.username =:keyword OR u.email =:keyword")
	public List<User> search(@Param("keyword") String keyword);
}
