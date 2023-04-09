package service;

import com.opensymphony.xwork2.inject.Inject;
import dao.MarqueDAO;
import entity.Marque;

import java.util.List;
import java.util.UUID;

public class MarqueService {

    @Inject
    private MarqueDAO marqueDAO;

    public void createMarque(Marque marque) {
        if (marque == null || marque.getId() == null) {
            throw new IllegalArgumentException("The marque object is null");
        }
        marqueDAO.createMarque(marque);
    }

    public Marque getLocation(UUID id) { return marqueDAO.getMarque(id);}

    public List<Marque> getAllMarques() {
        return marqueDAO.getAllMarques();
    }

    public Marque updateMarque(Marque marque) {
        if (marque == null || marque.getId() == null) {
            throw new IllegalArgumentException("Illegal marque object for update");
        }
        Marque existMarque = marqueDAO.getMarque(marque.getId());
        if (existMarque == null) {
            throw new IllegalArgumentException("Marque not found for update");
        }
        return marqueDAO.updateMarque(marque);
    }

    public void deleteLocation(UUID id) {
        marqueDAO.deleteMarque(id);
    }
}
