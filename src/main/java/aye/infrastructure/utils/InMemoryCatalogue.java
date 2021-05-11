package aye.infrastructure.utils;

import aye.domain.catalogue.Catalogue;
import aye.domain.catalogue.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCatalogue {
    public static Catalogue generateCatalogue() {
        List<Product> products = new ArrayList<>();
        Product phone = new Product("iphone");
        phone.setPrice(100);

        Product laptop = new Product("macbook");
        laptop.setPrice(10000);

        products.add(phone);
        products.add(laptop);

        return new Catalogue(products);
    }
}
