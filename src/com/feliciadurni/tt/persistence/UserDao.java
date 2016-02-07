package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.User;
import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public interface UserDao {
    /**
     * Return a list of all users
     * @return all users
     */
    public List<User> getAllUsers();

    /**
     * Update a user
     * @param user to be updated
     */
    public void updateUser(User user);

    /**
     * Delete a user
     *
     *  @param user to be deleted
     */
    public void deleteUser(User user);

    /**
     * Add a user
     *
     * @param user to be added
     * @return id of the inserted user
     */
    public int addUser(User user);

}
