package admin.security;

import admin.model.Aspnetusers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authenticator
{
    private static final Map<String, String> USERS = new HashMap<String, String>();
    
    public static void putUser(String userName, String passwordHash)
    {
        USERS.put(userName, passwordHash);
    }
    
    public static boolean validate(String user, String password)
    {
        String validUserPassword = USERS.get(user);
        System.out.println("ASP  " + USERS.get(user));
        System.out.println("JAVA " + password);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}