package aye.infrastructure;

import aye.domain.user.User;
import aye.domain.user.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type TYPE = new TypeToken<List<User>>(){}.getType();
    private final String LOCAL_FILE_DATA = "users.json";

    public InMemoryUserRepository() {
        readDataFromJson();
    }

    private void readDataFromJson() {
        try {
            JsonReader reader = new JsonReader(new FileReader(LOCAL_FILE_DATA));
            this.users = gson.fromJson(reader, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDataToJson() {
        try {
            Writer writer = new FileWriter(LOCAL_FILE_DATA);
            gson.toJson(users, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        readDataFromJson();
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void addNewUser(User user) {
        users.add(user);
        writeDataToJson();
    }
}
