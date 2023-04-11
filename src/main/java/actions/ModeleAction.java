package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Modele;
import lombok.Getter;
import lombok.Setter;
import service.ModeleService;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ModeleAction extends ActionSupport {

    @Inject
    private ModeleService modeleService;

    private Modele modele;

    private List<Modele> modeles;
    private UUID id;

    public String createModele() {
        modeleService.createModele(modele);
        return SUCCESS;
    }

    public String getModele() {
        modele = modeleService.getModele(id);
        if (modele == null) {
            return ERROR;
        }
        return SUCCESS;
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
}
