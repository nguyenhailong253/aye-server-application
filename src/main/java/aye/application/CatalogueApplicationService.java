package aye.application;

import aye.domain.catalogue.Catalogue;
import aye.domain.catalogue.CatalogueRepository;
import aye.infrastructure.InMemoryCatalogueRepository;

public class CatalogueApplicationService {

    private CatalogueRepository catalogueRepository;

    public CatalogueApplicationService() {
        this.catalogueRepository = new InMemoryCatalogueRepository();
    }

    public Catalogue getCatalogue() {
        return catalogueRepository.getCatalogue();
    }

    public void updateCatalogue(Catalogue catalogue) {
        catalogueRepository.updateCatalogue(catalogue);
    }
}
