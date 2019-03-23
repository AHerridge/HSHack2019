package com.fidohealth.fido;

import java.util.Arrays;
import java.util.List;

public class UserDao {
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final List<User> users = Arrays.asList(
            new User("Steve", "steve@gmail.com", "12345", "Depression"),
            new User("Alex", "@", "", "Depression")
    );

    public static User getById(String id) {
        for (User user : users)
            if (user.name.equals(id))
                return user;

        return null;
    }

    public static User getByEmail(String email) {
        for (User user : users)
            if (user.email.equals(email))
                return user;

        return null;
    }
}
