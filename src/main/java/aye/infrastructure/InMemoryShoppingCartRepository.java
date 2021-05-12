package aye.infrastructure;

import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.shoppingCart.ShoppingCartRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    private List<ShoppingCart> carts;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type TYPE = new TypeToken<List<ShoppingCart>>(){}.getType();
    private final String LOCAL_FILE_DATA = "shoppingCarts.json";

    public InMemoryShoppingCartRepository() {
        readDataFromJson();
    }

    private void readDataFromJson() {
        try {
            JsonReader reader = new JsonReader(new FileReader(LOCAL_FILE_DATA));
            this.carts = gson.fromJson(reader, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDataToJson() {
        try {
            Writer writer = new FileWriter(LOCAL_FILE_DATA);
            gson.toJson(carts, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ShoppingCart getShoppingCartByUserEmail(String email) {
        readDataFromJson();
        return carts.stream()
                .filter(cart -> cart.getUserEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createShoppingCart(ShoppingCart cart) {
        carts.add(cart);
        writeDataToJson();
    }

    @Override
    public void updateShoppingCart(ShoppingCart cart) {
        int index = findExistingCartIndex(cart);
        if (index != -1) {
            carts.remove(index);
            carts.add(cart);
            writeDataToJson();
        }
    }

    @Override
    public void deleteShoppingCart(String email) {
        int index = findExistingCartIndex(email);
        carts.remove(index);
        writeDataToJson();
    }

    private int findExistingCartIndex(ShoppingCart cart) {
        int index = -1;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserEmail().equals(cart.getUserEmail())) {
                index = i;
            }
        }
        return index;
    }

    private int findExistingCartIndex(String email) {
        int index = -1;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserEmail().equals(email)) {
                index = i;
            }
        }
        return index;
    }
}
