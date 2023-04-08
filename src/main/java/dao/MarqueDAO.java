package dao;

import entity.Marque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class MarqueDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void createMarque(Marque marque) {
        entityManager.persist(marque);
    }

    public Marque getMarque(UUID id) {
        return entityManager.find(Marque.class, id);
    }

    public List<Marque> getAllMarques() {
        return entityManager.createQuery("SELECT c FROM Marque c", Marque.class).getResultList();
    }

    public Marque updateMarque(Marque marque) {
        return entityManager.merge(marque);
    }

    public void deleteMarque(UUID id) {
        Marque marque = entityManager.find(Marque.class, id);
        if (marque != null) {
            entityManager.remove(marque);
        }
    }
}
