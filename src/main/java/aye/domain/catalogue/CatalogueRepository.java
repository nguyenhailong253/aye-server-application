package aye.domain.catalogue;

public interface CatalogueRepository {
    Product getProductByName(String productName);
    Catalogue getCatalogue();
    void updateCatalogue(Catalogue catalogue);
}
