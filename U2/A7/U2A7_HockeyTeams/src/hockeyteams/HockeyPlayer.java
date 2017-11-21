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
        this.lastName = lastName;
        this.firstName = firstName;
        this.team = team;
        this.grade = grade;
        this.position = position;
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
     * Set player number preference
     * @param preference Number ranking (0, 1, or 2)
     * @param value New number for that ranking
     */
    public void setNumberPreference(int preference, int value){
        numberPreference[preference] = value;
    }
    
    /**
     * Get list of nicknames
     * @return List containing all nicknames for this player
     */
    public List<String> getNicknames(){
        return nicknames;
    }
    
}
