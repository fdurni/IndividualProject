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

    public Program() {}

    public Program(Integer programId, String programName, String programDescription, String programType) {
        this.programId = programId;
        this.programName = programName;
        this.programDescription = programDescription;
        this.programType = programType;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public Integer getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(Integer numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    public Integer getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(Integer currentWeek) {
        this.currentWeek = currentWeek;
    }

    public Integer getRemainingWeeks() {
        return remainingWeeks;
    }

    public void setRemainingWeeks(Integer remainingWeeks) {
        this.remainingWeeks = remainingWeeks;
    }

    public Set<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(Set<Routine> routines) {
        this.routines = routines;
    }

    public void addRoutine(Routine routine) {
        this.routines.add(routine);
    }

    @Transient
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getNumberOfRoutines() {
        return numberOfRoutines;
    }

    public void setNumberOfRoutines(Integer numberOfRoutines) {
        this.numberOfRoutines = numberOfRoutines;
    }
}
