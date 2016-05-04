package com.feliciadurni.tt.entity;

import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Weeks;

/**
 * Created by felic on 3/29/2016.
 */
public class Program {
    private Integer programId;
    private String programName;
    private String programType;
    private String programDescription;
    private Integer numberOfWeeks;
    private Set<Routine> routines;
    private Person person;
    private Date beginDate;
    private Date endDate;
    private Integer currentWeek;
    private Integer remainingWeeks;
    private Integer numberOfRoutines;

    /**
     * Instantiates a new Program.
     */
    public Program() {}

    /**
     * Instantiates a new Program.
     *
     * @param programId          the program id
     * @param programName        the program name
     * @param programDescription the program description
     * @param programType        the program type
     */
    public Program(Integer programId, String programName, String programDescription, String programType) {
        this.programId = programId;
        this.programName = programName;
        this.programDescription = programDescription;
        this.programType = programType;
    }

    /**
     * Gets program id.
     *
     * @return the program id
     */
    public Integer getProgramId() {
        return programId;
    }

    /**
     * Sets program id.
     *
     * @param programId the program id
     */
    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    /**
     * Gets program name.
     *
     * @return the program name
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * Sets program name.
     *
     * @param programName the program name
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * Gets program type.
     *
     * @return the program type
     */
    public String getProgramType() {
        return programType;
    }

    /**
     * Sets program type.
     *
     * @param programType the program type
     */
    public void setProgramType(String programType) {
        this.programType = programType;
    }

    /**
     * Gets program description.
     *
     * @return the program description
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     * Sets program description.
     *
     * @param programDescription the program description
     */
    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    /**
     * Gets number of weeks.
     *
     * @return the number of weeks
     */
    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    /**
     * Sets number of weeks.
     *
     * @param numberOfWeeks the number of weeks
     */
    public void setNumberOfWeeks(Integer numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    /**
     * Gets current week.
     *
     * @return the current week
     */
    public Integer getCurrentWeek() {
        return currentWeek;
    }

    /**
     * Sets current week.
     *
     * @param currentWeek the current week
     */
    public void setCurrentWeek(Integer currentWeek) {
        this.currentWeek = currentWeek;
    }

    /**
     * Gets remaining weeks.
     *
     * @return the remaining weeks
     */
    public Integer getRemainingWeeks() {
        return remainingWeeks;
    }

    /**
     * Sets remaining weeks.
     *
     * @param remainingWeeks the remaining weeks
     */
    public void setRemainingWeeks(Integer remainingWeeks) {
        this.remainingWeeks = remainingWeeks;
    }

    /**
     * Gets routines.
     *
     * @return the routines
     */
    public Set<Routine> getRoutines() {
        return routines;
    }

    /**
     * Sets routines.
     *
     * @param routines the routines
     */
    public void setRoutines(Set<Routine> routines) {
        this.routines = routines;
    }

    /**
     * Add routine.
     *
     * @param routine the routine
     */
    public void addRoutine(Routine routine) {
        this.routines.add(routine);
    }

    /**
     * Gets person.
     *
     * @return the person
     */
    @Transient
    public Person getPerson() {
        return person;
    }

    /**
     * Sets person.
     *
     * @param person the person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets begin date.
     *
     * @return the begin date
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * Sets begin date.
     *
     * @param beginDate the begin date
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets number of routines.
     *
     * @return the number of routines
     */
    public Integer getNumberOfRoutines() {
        return numberOfRoutines;
    }

    /**
     * Sets number of routines.
     *
     * @param numberOfRoutines the number of routines
     */
    public void setNumberOfRoutines(Integer numberOfRoutines) {
        this.numberOfRoutines = numberOfRoutines;
    }
}
