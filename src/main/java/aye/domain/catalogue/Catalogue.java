package aye.domain.catalogue;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<Product> products;

    public Catalogue() {
        products = new ArrayList<>();
    }

    public Catalogue(List<Product> products) {
        this.products = products;
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(prod -> prod.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return products;
    }
}
