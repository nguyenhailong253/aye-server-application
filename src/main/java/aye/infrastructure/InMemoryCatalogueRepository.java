package aye.infrastructure;

import aye.domain.catalogue.Catalogue;
import aye.domain.catalogue.CatalogueRepository;
import aye.domain.catalogue.Product;
import aye.infrastructure.utils.InMemoryCatalogue;

import java.util.List;

public class InMemoryCatalogueRepository implements CatalogueRepository {
    private Catalogue catalogue;

    public InMemoryCatalogueRepository() {
        this.catalogue = InMemoryCatalogue.generateCatalogue();
    }

    @Override
    public Product getProductByName(String productName) {
        return catalogue.getProductByName(productName);
    }
}
