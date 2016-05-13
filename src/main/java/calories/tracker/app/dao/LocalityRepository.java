package calories.tracker.app.dao;

import calories.tracker.app.model.Locality;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

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
 * Created by alex on 16.10.5.
 */
@Repository
public class LocalityRepository {
    private static final Logger LOGGER = Logger.getLogger(LocalityRepository.class);

    @PersistenceContext
    EntityManager em;

    public List<Locality> findLocalities(String predicate){
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Locality> searchQuery = cb.createQuery(Locality.class);
        Root<Locality> searchRoot = searchQuery.from(Locality.class);
        searchQuery.select(searchRoot);

        List<Predicate> predicates = new ArrayList<Predicate>();
//        if(from) {
            predicates.add(cb.equal(searchRoot.<String>get("title"), predicate));
//        }else{
//            predicates.add(cb.like(searchRoot.<String>get("driveTo"), predicate));
//        }

        searchQuery.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Locality> filterQuery = em.createQuery(searchQuery);
        return filterQuery.getResultList();
    }
}
