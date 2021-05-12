package aye.domain.catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Catalogue {
    private List<Product> products;
    private UUID catalogueId;

    public Catalogue() {
        this.products = new ArrayList<>();
        this.catalogueId = UUID.randomUUID();
    }

    public Catalogue(List<Product> products) {
        this.products = products;
        this.catalogueId = UUID.randomUUID();
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(prod -> prod.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public UUID getCatalogueId() {
        return catalogueId;
    }

    public List<Product> getProducts() {
        return products;
    }
}
