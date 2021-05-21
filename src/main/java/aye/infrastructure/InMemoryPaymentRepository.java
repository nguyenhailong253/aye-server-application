package aye.infrastructure;

import aye.domain.payment.PaymentRepository;
import aye.domain.payment.Receipt;
import aye.domain.shoppingCart.CartItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InMemoryPaymentRepository implements PaymentRepository {
    private List<Receipt> receipts;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type TYPE = new TypeToken<List<Receipt>>(){}.getType();
    private final String LOCAL_FILE_NAME = "receipts.json";

    public InMemoryPaymentRepository() {
        readDataFromJson();
    }

    private void readDataFromJson() {
        try {
            JsonReader reader = new JsonReader(new FileReader(LOCAL_FILE_NAME));
            this.receipts = gson.fromJson(reader, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDataToJson() {
        try {
            Writer writer = new FileWriter(LOCAL_FILE_NAME);
            gson.toJson(receipts, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeReceipt(Receipt receipt) {
        receipts.add(receipt);
        writeDataToJson();
    }

    @Override
    public List<Receipt> getReceiptsContainProductName(String productName, String period) {
        List<Receipt> results = new ArrayList<>();

        for (Receipt receipt: receipts) {
            for (CartItem item: receipt.getItemsPurchased()) {
                if (item.getProduct().getName().equals(productName)) {
                    results.add(receipt);
                    break;
                }
            }
        }
        return results;
    }
}
