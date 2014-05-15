package admin.security;

import admin.model.Aspnetusers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Authenticator
{
    private static final Map<String, String> USERS = new HashMap<String, String>();
    
    public static void putUser(String userName, String password)
    {
        USERS.put(userName, password);
    }
    
    public static boolean validate(String user, String password)
    {
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}