/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darian
 */
public class HockeyPlayer {
    
    private String lastName;
    private String firstName;
    private Team team;
    private int grade;
    private Position position;
    private int[] numberPreference;
    private List<String> nicknames;

    public HockeyPlayer(String lastName, String firstName, Team team, int grade, Position position, int[] numberPreference) {
        //Sanity check on last name, cannot be blank
        if(lastName.equals(""))
            throw new IllegalArgumentException("Last name can not be blank!");
        this.lastName = lastName;
        
        //Sanity check on first name, cannot be blank
        if(firstName.equals(""))
            throw new IllegalArgumentException("First name can not be blank!");
        this.firstName = firstName;
        
        this.team = team;
        
        //Sanity check on grade
        if(grade < 9 || grade > 13)
            throw new IllegalArgumentException("Grade must be between 9 and 13 inclusive!");
        this.grade = grade;
        
        this.position = position;
        
        //Sanity checks on preferences
        if(numberPreference.length > 3)
            throw new IllegalArgumentException("Players must only have 3 number preferences");
        for(int preference : numberPreference){
            if(preference < 0 || preference > 99)
                throw new IllegalArgumentException("Number preferences must be between 0 and 99 inclusive!");
        }
        this.numberPreference = numberPreference;
        
        nicknames = new ArrayList<>();
    }

    /**
     * Get player's last name
     * @return Player's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set player's last name
     * @param lastName New last name
     */
    public void setLastName(String lastName) {
        //Sanity check on last name, cannot be blank
        if(lastName.equals(""))
            throw new IllegalArgumentException("Last name can not be blank!");
        this.lastName = lastName;
    }

    /**
     * Get player's first name
     * @return Player's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set player's first name
     * @param firstName New first name
     */
    public void setFirstName(String firstName) {
        //Sanity check on first name, cannot be blank
        if(firstName.equals(""))
            throw new IllegalArgumentException("First name can not be blank!");
        this.firstName = firstName;
    }

    /**
     * Get player's team (boys or girls)
     * @return Player's team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Set player's team
     * @param team Player's new team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Get player grade
     * @return Player grade (American version [9-12] not year of high school)
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Set player grade
     * @param grade Player's new grade (American version [9-12] not year of high school)
     */
    public void setGrade(int grade) {
        if(grade < 9 || grade > 13)
            throw new IllegalArgumentException("Grade must be between 9 and 13 inclusive!");
        this.grade = grade;
    }

    /**
     * Get player position
     * @return Player position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set player position
     * @param position Player's new position
     */
    public void setPosition(Position position) {
        this.position = position;
    }
    
    /**
     * Get player number preference
     * @param preference Number ranking (0, 1, or 2)
     * @return Player's preferred number at that ranking
     */
    public int getNumberPreference(int preference){
        return numberPreference[preference];
    }
    
    /**
     * Get number preferences
     * @return Array of preference, ordered from most to least preferred
     */
    public int[] getNumberPreferences(){
        return numberPreference;
    }
    
    /**
     * Set player number preference
     * @param preference Number ranking (0, 1, or 2)
     * @param value New number for that ranking
     */
    public void setNumberPreference(int preference, int value){
        if(value < 0 || value > 99)
                throw new IllegalArgumentException("Number preferences must be between 0 and 99 inclusive!");
        if (preference < 0 || preference > 2)
            throw new IllegalArgumentException("Players must only have 3 number preferences");
        numberPreference[preference] = value;
    }
    
    /**
     * Set number preferences
     * @param preferences Array of preference, ordered from most to least preferred
     */
    public void setNumberPreferences(int[] preferences){
        if(preferences.length > 3)
            throw new IllegalArgumentException("Players must only have 3 number preferences");
        for(int preference : preferences){
            if(preference < 0 || preference > 99)
                throw new IllegalArgumentException("Number preferences must be between 0 and 99 inclusive!");
        }
        numberPreference = preferences;
    }
    
    /**
     * Get list of nicknames
     * @return List containing all nicknames for this player
     */
    public List<String> getNicknames(){
        return nicknames;
    }
    
    /**
     * Set list of nicknames
     * @param nicknames List containing all nicknames for this player
     */
    public void setNicknames(List<String> nicknames){
        this.nicknames = nicknames;
    }
    
}
