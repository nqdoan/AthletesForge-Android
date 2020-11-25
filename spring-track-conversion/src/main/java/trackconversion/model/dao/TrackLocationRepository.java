package trackconversion.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trackconversion.model.dto.TrackLocation;

import java.util.List;

@Repository
public interface TrackLocationRepository extends JpaRepository<TrackLocation, Long> {

    public List<TrackLocation> getAllTracks();

}