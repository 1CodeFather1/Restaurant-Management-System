package Logical_Class;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PersonClass {

    private String username;
    private String password;

    /*--------Constructors--------*/
    public PersonClass(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public PersonClass(String username) {
        this.username = username;
    }

    public PersonClass() {
    }

    /*--------Getter & Setter--------*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*To Check If The Account exists in Our System */
    public static boolean validateAccount(String username, String password, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2) {
                    String fileUsername = credentials[0].trim();
                    String filePassword = credentials[1].trim();
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException _) {
        }
        return false;
    }

    /*To Check if the New Account Data already exists (In Create A new Account Operation*/
    public static void createAccount(String username, String password, String path) {
        try {
            File file = new File(path);
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                if (line == null || line.trim().isEmpty())
                    continue;
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(username)) {
                    Logical_Class.DialogMSG.AccountExists();
                    return;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(username + "," + password);
                writer.newLine();
                writer.flush();
                Logical_Class.DialogMSG.CreateAccountMessage();
            }
        } catch (IOException _) {
        }
    }

}