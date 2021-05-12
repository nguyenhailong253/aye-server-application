package aye.domain.catalogue;

import java.util.UUID;

public class Product {
    private String name;
    private UUID id;
    private int price;
    private boolean hasEnoughStock;

    public Product(String name) {
        this.id = UUID.randomUUID();
        this.hasEnoughStock = true;
        this.name = name;
    }

    public Product() {}

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean getHasEnoughStock() {
        return hasEnoughStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHasEnoughStock(boolean hasEnoughStock) {
        this.hasEnoughStock = hasEnoughStock;
    }
}
