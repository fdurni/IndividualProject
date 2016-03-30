package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonrolesEntity;

import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonRolesEntityDao {

    /**
     * Return a list of all personRoles
     * @return all personRoles
     */
    public List<PersonrolesEntity> getAllPersonRoles();

    /**
     * Get a personRole by id
     * @param userName to get
     */
    public PersonrolesEntity getPersonRole(String userName);

    /**
     * Update a personRole
     * @param personRole to be updated
     */
    public void updatePersonRole(PersonrolesEntity personRole);

    /**
     * Delete a personRole
     *
     * @param personRole to be deleted
     */
    public Boolean deletePersonRole(PersonrolesEntity personRole);

    /**
     * Add a personRole
     *
     * @param personRole to be added
     * @return id of the inserted personRole
     */
    public String addPersonRole(PersonrolesEntity personRole);
}
