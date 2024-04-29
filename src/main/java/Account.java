import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public abstract class Account implements AccountManagement{
    private String username;
    private String password;
    private UUID accountID;

    public Account(String username, String password) {
        this.username = username;
        this.password = setHash(password);
        this.accountID = UUID.randomUUID();
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        return this.password.equals(setHash(enteredPassword));
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = setHash(newPassword);
    }

    private String setHash(String password) {  // creat hash of a password
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();

            for (byte i : hashedPassword) {
                stringBuilder.append(String.format("%02x", i));
            }

            return stringBuilder.toString();
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public abstract void dosplayChoiceMenu();
}