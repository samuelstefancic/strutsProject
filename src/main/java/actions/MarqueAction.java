package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Marque;
import lombok.Getter;
import lombok.Setter;
import service.MarqueService;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class MarqueAction extends ActionSupport {

    @Inject
    private MarqueService marqueService;

    private Marque marque;

    private List<Marque> marques;
    private UUID id;

    public String createMarque() {
        marqueService.createMarque(marque);
        return SUCCESS;
    }

    public String getMarque() {
        marque = marqueService.getMarque(id);
        if (marque == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getAllMarques() {
        marques = marqueService.getAllMarques();
        return SUCCESS;
    }

    public String updateMarque() {
        marque = marqueService.updateMarque(marque);
        return SUCCESS;
    }

    public String deleteMarque() {
        marqueService.deleteLocation(id);
        return SUCCESS;
    }

}
