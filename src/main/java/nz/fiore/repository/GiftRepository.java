package nz.fiore.repository;

import nz.fiore.model.Gift;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Traced
public class GiftRepository {

    private static final Logger logger = LoggerFactory.getLogger(GiftRepository.class);

    @Inject
    EntityManager em;

    @Transactional
    public Gift persist(Gift gift) {
        em.persist(gift);
        return gift;
    }

    @Transactional
    public Gift update(Gift gift) {
        em.merge(gift);
        return gift;
    }

    @Transactional
    public void delete(Long id) {
        em.remove(id);
    }

    @Transactional
    public Gift find(Long id) {
        return em.find(Gift.class, id);
    }

    @Transactional
    public List<Gift> list() {
        List<Gift> list = new ArrayList<>();
        try {
            list = em.createQuery("select g from " + Gift.class.getName() + " g ")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
