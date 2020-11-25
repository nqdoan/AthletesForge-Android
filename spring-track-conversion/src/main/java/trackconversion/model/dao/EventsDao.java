package trackconversion.model.dao;

import org.springframework.stereotype.Repository;
import trackconversion.model.dto.Events;
import trackconversion.model.dto.TrackLocation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Events> getInfoBySchoolName(String eventName){
        try{
            Query query = entityManager.createNamedQuery("Events.getInfoByEvent");
            query.setParameter("eventName", eventName);
            return (List<Events>) query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
}
