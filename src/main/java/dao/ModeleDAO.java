package dao;

import entity.Modele;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class ModeleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void createModele(Modele modele) {
        entityManager.persist(modele);
    }

    public Modele getModele(UUID id) {
        return entityManager.find(Modele.class, id);
    }

    public List<Modele> getAllModeles() {
        return entityManager.createQuery("SELECT m FROM Modele  m", Modele.class).getResultList();
    }

    public Modele updateModele(Modele modele) {
        return entityManager.merge(modele);
    }

    public void deleteModele(UUID id) {
        Modele modele = entityManager.find(Modele.class, id);
        if (modele != null) {
            entityManager.remove(modele);
        }
    }
}
