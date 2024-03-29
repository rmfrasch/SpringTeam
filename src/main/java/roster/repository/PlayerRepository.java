package roster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roster.beans.Player;

	@Repository
	public interface PlayerRepository extends JpaRepository<Player, Long> {

	}
	
	
