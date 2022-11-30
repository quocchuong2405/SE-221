package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.MCP;

@Repository
public interface McpRepository extends JpaRepository<MCP, Integer> {
	@Query("SELECT m FROM MCP a WHERE a.id =:keyword")
	public List<MCP> search(@Param("keyword") String keyword);
	
}
