package aye.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static List<SimplifiedCart> getItems(Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<SimplifiedCart> itemList = mapper
                .convertValue(body.get("cart"),
                        new TypeReference<ArrayList<SimplifiedCart>>() {});
        return itemList;
    }
}
