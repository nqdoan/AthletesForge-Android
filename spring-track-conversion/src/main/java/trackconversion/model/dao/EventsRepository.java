package trackconversion.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trackconversion.model.dto.Events;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    public List<Events> getAllEvents();

}