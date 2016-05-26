package calories.tracker.app.dao;

import calories.tracker.app.model.Locality;
import calories.tracker.app.util.CustomizedOrderBy;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Locality> searchQuery = cb.createQuery(Locality.class);
//        Root<Locality> searchRoot = searchQuery.from(Locality.class);
//        searchQuery.select(searchRoot);
//
//        List<Predicate> predicates = new ArrayList<Predicate>();
//        predicates.add(cb.like(cb.upper(searchRoot.<String>get("title")), predicate.toUpperCase() + "%"));
//
//        searchQuery.where(predicates.toArray(new Predicate[]{}));
////        searchQuery.orderBy(cb.desc(searchRoot.get("")));
////        searchQuery.groupBy(searchRoot.<String>get("title"));
//        TypedQuery<Locality> filterQuery = em.createQuery(searchQuery);
//        return filterQuery.getResultList();

//        String hql = "from Locality l " +
//                "where upper(l.title) like '%" + predicate.toUpperCase() + "%' " +
////                "group by l.title " +
//                "ORDER BY LOCATE('" + predicate.toUpperCase() + "', upper(l.title))";
//        Query query = em.createQuery(hql);
//        ProjectionList projList = Projections.projectionList();
//        projList.add(Projections.property("id.state"));
//        projList.add(Projections.property("id.uspsCity"));
//
//
//        List<Locality> results = query.getResultList();
//        return results;

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Locality> criteria = cb.createQuery(Locality.class);
//        Root<Locality> searchRoot = criteria.from(Locality.class);
//        criteria.select(searchRoot);
//
//        List<Predicate> predicates = new ArrayList<Predicate>();
//        predicates.add(cb.like(cb.upper(searchRoot.<String>get("title")), predicate.toUpperCase() + "%"));
//
//        criteria.where(predicates.toArray(new Predicate[]{}));
//        criteria.addO


        Session s = (Session) em.getDelegate();
//        List result = (List<Locality>) s.createSQLQuery(
////        TypedQuery<Locality> result = em.createQuery(
//                "select * from LOCALITY "+
////                        "where upper(title) like :likePredicate " +
//                        "group by title "
////                        "ORDER BY LOCATE(:predicate, upper(title))"
//                ).addEntity(Locality.class)
////                .setParameter("likePredicate", "%" + predicate.toUpperCase() + "%")
//                .list();
////                .setParameter("predicate", predicate);
//        return result;

        Criteria c = s.createCriteria(Locality.class);
        c.add(Restrictions.like("title", "%" + predicate + "%").ignoreCase());

        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.groupProperty("title"), "title");

        c.setProjection(projList);
        c.addOrder(CustomizedOrderBy.sqlFormula("LOCATE('" + predicate.toUpperCase() + "', upper(title))"));
        c.setResultTransformer(Transformers.aliasToBean(Locality.class));
        List<Locality> result = (List<Locality>) c.list();
        return result;
    }
}
