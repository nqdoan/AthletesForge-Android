package trackconversion.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trackconversion.model.dto.NationalLocation;

import java.util.List;

@Repository
public interface NationalLocationRepository extends JpaRepository<NationalLocation, Long> {

    public List<NationalLocation> getNationalLocation();

}