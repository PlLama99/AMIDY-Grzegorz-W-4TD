package org.example;

import java.io.*;

public class StorageManager {
    private static final String FILE_NAME = "profile.json";

    public static void save(org.example.UserProfile profile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            String json = "{\n" +
                    "  \"firstName\": \"" + profile.getFirstName() + "\",\n" +
                    "  \"lastName\": \"" + profile.getLastName() + "\",\n" +
                    "  \"email\": \"" + profile.getEmail() + "\"\n" +
                    "}";
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static org.example.UserProfile load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }
            String json = jsonBuilder.toString();
            return new org.example.UserProfile(
                    extract(json, "firstName"),
                    extract(json, "lastName"),
                    extract(json, "email")
            );
        } catch (Exception e) {
            return null;
        }
    }

    private static String extract(String json, String key) {
        String pattern = "\"" + key + "\":\"";
        int start = json.indexOf(pattern) + pattern.length();
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}