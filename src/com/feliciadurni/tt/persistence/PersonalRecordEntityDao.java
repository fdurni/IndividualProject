package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.PersonalrecordEntity;
import java.util.List;

/**
 * Created by felic on 3/29/2016.
 */
public interface PersonalRecordEntityDao {

    /**
     * Return a list of all personalRecords
     * @return all personalRecords
     */
    public List<PersonalrecordEntity> getAllPersonalRecords();

    /**
     * Get a personalRecord by id
     * @param id to get
     */
    public PersonalrecordEntity getPersonalRecord(Integer id);

    /**
     * Update a personalRecord
     * @param personalRecord to be updated
     */
    public void updatePersonalRecord(PersonalrecordEntity personalRecord);

    /**
     * Delete a personalRecord
     *
     * @param personalRecord to be deleted
     */
    public Boolean deletePersonalRecord(PersonalrecordEntity personalRecord);

    /**
     * Add a personalRecord
     *
     * @param personalRecord to be added
     * @return id of the inserted personalRecord
     */
    public int addPersonalRecord(PersonalrecordEntity personalRecord);
}
