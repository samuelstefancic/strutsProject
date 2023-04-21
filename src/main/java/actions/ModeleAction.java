package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Marque;
import entity.Modele;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import service.MarqueService;
import service.ModeleService;

import java.util.List;
import java.util.UUID;
@Action
@Getter
@Setter
public class ModeleAction extends ActionSupport {

    //Services
    @Inject
    private ModeleService modeleService;
    @Inject
    private MarqueService marqueService;

    private Modele modele;

    //List

    private List<Modele> modeles;
    private List<Marque> marques;

    //UUID
    private UUID id;
    private UUID marqueId;

    public String createModele() {
        try {
            modeleService.createModele(modele);
            return SUCCESS;
        } catch(Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getModele() {
        try {
            modele = modeleService.getModele(id);
            if (modele == null) {
                return ERROR;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getAllModeles() {
        modeles = modeleService.getAllModeles();
        return SUCCESS;
    }

    public String updateModele() {
        modele = modeleService.updateModele(modele);
        return SUCCESS;
    }

    public String deleteModele() {
        modeleService.deleteModele(id);
        return SUCCESS;
    }

    public String showCreateModeleForm() {
        return SUCCESS;
    }
}
