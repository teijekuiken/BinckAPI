package BinckMap.BinckAPI.DAO;

import BinckMap.BinckAPI.Entity.Story;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
}
