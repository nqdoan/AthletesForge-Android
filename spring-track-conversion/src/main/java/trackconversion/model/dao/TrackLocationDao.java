package trackconversion.model.dao;

import org.springframework.stereotype.Repository;
import trackconversion.model.dto.TrackLocation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TrackLocationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<TrackLocation> getInfoBySchoolName(String schoolName){
        try{
            Query query = entityManager.createNamedQuery("TrackLocation.getInfoByName");
            query.setParameter("schoolName", schoolName);
            return (List<TrackLocation>) query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
}
