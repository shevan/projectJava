package admin.model;

import java.util.HashMap;
import java.util.Map;

// dit moet denk ik weg en vervangen worden met een admins/begeleider/student/??
public class User
{
    private static final Map<String, User> USERS = new HashMap<String, User>();
    private String id;
        
    private User(String id)
    {
        this.id = id;
    }
    
    public static User of(String id)
    {
        User user = USERS.get(id);
        if (user == null)
        {
            user = new User(id);
            USERS.put(id, user);
        }
        return user;
    }
}
