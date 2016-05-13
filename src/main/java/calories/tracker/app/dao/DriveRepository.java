package calories.tracker.app.dao;

import calories.tracker.app.model.Drive;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 15.30.12.
 */
@Repository
public class DriveRepository {
    private static final Logger LOGGER = Logger.getLogger(DriveRepository.class);

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Drive save(Drive drive) {
        return em.merge(drive);
    }

    @Transactional
    public void delete(Long deletedDriveId) {
        Drive delete = em.find(Drive.class, deletedDriveId);
        em.remove(delete);
    }

    public List<Drive> findDrives(){
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Drive> searchQuery = cb.createQuery(Drive.class);
        Root<Drive> searchRoot = searchQuery.from(Drive.class);
        searchQuery.select(searchRoot);
        TypedQuery<Drive> filterQuery = em.createQuery(searchQuery);
        return filterQuery.getResultList();
    }

    public List<Drive> findDrives(String from, String to){
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Drive> searchQuery = cb.createQuery(Drive.class);
        Root<Drive> searchRoot = searchQuery.from(Drive.class);
        searchQuery.select(searchRoot);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(searchRoot.<String>get("driveFrom"), from));
        predicates.add(cb.equal(searchRoot.<String>get("driveTo"), to));

        searchQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Drive> filterQuery = em.createQuery(searchQuery);
        return filterQuery.getResultList();
    }

    public Drive findDriveById(Long id) {
        return em.find(Drive.class, id);
    }
}
