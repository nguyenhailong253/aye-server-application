package aye.domain.catalogue;

public interface CatalogueRepository {
    Product getProductByName(String productName);
}
