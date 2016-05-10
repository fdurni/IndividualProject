package com.feliciadurni.tt.entity;

import java.util.Set;

/**
 * Created by felic on 3/29/2016.
 */
public class Person {
    private Integer personId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Set<Program> programs;
    private Set<PersonRole> roles;

    /**
     * Gets person id.
     *
     * @return the person id
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Sets person id.
     *
     * @param personId the person id
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets programs.
     *
     * @return the programs
     */
    public Set<Program> getPrograms() {
        return programs;
    }

    /**
     * Sets programs.
     *
     * @param programs the programs
     */
    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }

    /**
     * Add program.
     *
     * @param program the program
     */
    public void addProgram(Program program) {
        this.programs.add(program);
    }

    public Set<PersonRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<PersonRole> roles) {
        this.roles = roles;
    }

    public void addRole(PersonRole role) {
        this.roles.add(role);
    }
}
