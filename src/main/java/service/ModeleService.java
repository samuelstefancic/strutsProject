package service;

import com.opensymphony.xwork2.inject.Inject;
import dao.ModeleDAO;
import entity.Modele;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ModeleService {

    @Inject
    private ModeleDAO modeleDAO;

    public void createModele(Modele modele) {
        if (modele == null || modele.getId() == null ) {
            throw new IllegalArgumentException("The modele is not valid");
        }
        modeleDAO.createModele(modele);
    }

    public Modele getModele(UUID id) {return modeleDAO.getModele(id);}

    public List<Modele> getAllModeles() {return modeleDAO.getAllModeles();}

    public Modele updateModele(Modele modele) {
        if (modele == null || modele.getId() == null) {
            throw new IllegalArgumentException("Invalid modele object for update");
        }
            Modele existModel = modeleDAO.getModele(modele.getId());
            if (existModel == null) {
                throw new IllegalArgumentException("Model not found for the update");
            }
            return modeleDAO.updateModele(modele);
    }
    public void deleteModele(UUID id) {modeleDAO.deleteModele(id);}
}
