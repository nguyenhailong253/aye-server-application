package aye.presentation;

import aye.application.CatalogueApplicationService;
import aye.domain.catalogue.Catalogue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalogue")
public class CatalogueAPI {
    private CatalogueApplicationService service;

    public CatalogueAPI() {
        service = new CatalogueApplicationService();
    }

    @GetMapping("")
    public Catalogue getCatalogue() {
        return service.getCatalogue();
    }

    @PostMapping("")
    public void updateCatalogue(@RequestBody Catalogue catalogue) {
        service.updateCatalogue(catalogue);
    }
}
