package aye.infrastructure;

import aye.domain.catalogue.Catalogue;
import aye.domain.catalogue.CatalogueRepository;
import aye.domain.catalogue.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;

public class InMemoryCatalogueRepository implements CatalogueRepository {
    private Catalogue catalogue;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type TYPE = new TypeToken<Catalogue>(){}.getType();
    private final String LOCAL_FILE_NAME = "catalogue.json";

    public InMemoryCatalogueRepository() {
        readDataFromJson();
    }

    private void readDataFromJson() {
        try {
            JsonReader reader = new JsonReader(new FileReader(LOCAL_FILE_NAME));
            this.catalogue = gson.fromJson(reader, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDataToJson() {
        try {
            Writer writer = new FileWriter(LOCAL_FILE_NAME);
            gson.toJson(catalogue, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductByName(String productName) {
        readDataFromJson();
        return catalogue.getProductByName(productName);
    }

    @Override
    public Catalogue getCatalogue() {
        readDataFromJson();
        return catalogue;
    }

    @Override
    public void updateCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
        writeDataToJson();
    }
}
