/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Darian
 */
public class TeamTableModel extends AbstractTableModel implements TableModel {

    //List to store all players
    private List<HockeyPlayer> players;
    //List to store only the players that should be displayed
    private List<HockeyPlayer> displayList;
    
    //Arrays and maps for filters
    private boolean[] gradeFilter;
    private Map<Team, Boolean> teamFilter;
    private Map<Position, Boolean> positionFilter;
    
    public TeamTableModel(){
        //Initialise all the variables
        players = new ArrayList<>();
        displayList = new ArrayList<>();
        gradeFilter = new boolean[5];
        teamFilter = new HashMap<>();
        positionFilter = new HashMap<>();
    }
    
    private void refreshDisplay(){
        displayList.clear();//Empty display list
        for(HockeyPlayer player : players){
            if(gradeFilter[player.getGrade() - 9] ||//Test if grade should be shown
                    teamFilter.get(player.getTeam()) ||//And test if team should be shown
                    positionFilter.get(player.getPosition())){//And test if position should be shown
                displayList.add(player);//Add player to display list
            }
        }
    }
    
    public void setGradeFilter(int grade, boolean show){
        //Subtract 9 to get index in array from grade
        //(9 -> 0, 10 -> 1,...)
        gradeFilter[grade - 9] = show;
        refreshDisplay();
    }
    
    public void setTeamFilter(Team team, boolean show){
        //Just set the value in the map to the one specified
        teamFilter.put(team, show);
        refreshDisplay();
    }
    
    public void setPositionFilter(Position position, boolean show){
        //Same as team filter
        positionFilter.put(position, show);
        refreshDisplay();
    }
    
    public void addPlayer(HockeyPlayer player){
        //Make sure there are no duplicates
        for(HockeyPlayer exsistingPlayer : players){
            if(exsistingPlayer.getFirstName().equals(player.getFirstName()) && exsistingPlayer.getLastName().equals(player.getLastName())){
                JOptionPane.showMessageDialog(new JFrame(), "Player already exists");
                return;
            }
        }
        players.add(player);
        refreshDisplay();
    }
    
    public void removePlayer(HockeyPlayer player){
        players.remove(player);
        refreshDisplay();
    }
    
    public HockeyPlayer getPlayerAtRow(int rowIndex){
        return displayList.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return displayList.size();//1 row for each entry
    }

    @Override
    public int getColumnCount() {
        return 7;//Always have 7 columns
    }

    @Override
    public String getColumnName(int columnIndex) {
        //Column names will be constant
        switch(columnIndex){
            case 0:
                return "Last Name";
            case 1:
                return "First Name";
            case 2:
                return "Team";
            case 3:
                return "Grade";
            case 4:
                return "Position";
            case 5:
                return "Number Preference";
            case 6:
                return "Nicknames";
            default://Only 7 columns, this shouldn't be possible
                return "This shouldn't happen";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
            case 1:
                return String.class;
            case 2:
                return Team.class;
            case 3:
                return Integer.class;
            case 4:
                return Position.class;
            case 5:
                return int[].class;
            case 6:
                return List.class;
            default:
                return String.class;//This shouldn't happen
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;//don't allow editing for now. Will change this with column classes
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return displayList.get(rowIndex).getLastName();
            case 1:
                return displayList.get(rowIndex).getFirstName();
            case 2:
                return displayList.get(rowIndex).getTeam();
            case 3:
                return displayList.get(rowIndex).getGrade();
            case 4:
                return displayList.get(rowIndex).getPosition();
            case 5:
                return displayList.get(rowIndex).getNumberPreferences();
            case 6:
                return displayList.get(rowIndex).getNicknames();
            default://This is for columns that can't exist in this table
                return "This shouldn't happen";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try{
            switch(columnIndex){
                case 0:
                    displayList.get(rowIndex).setLastName((String)aValue);
                    break;
                case 1:
                    displayList.get(rowIndex).setFirstName((String)aValue);
                    break;
                case 2:
                    displayList.get(rowIndex).setTeam((Team)aValue);
                    break;
                case 3:
                    displayList.get(rowIndex).setGrade((int)aValue);
                    break;
                case 4:
                    displayList.get(rowIndex).setPosition((Position)aValue);
                    break;
                case 5:
                    displayList.get(rowIndex).setNumberPreferences((int[])aValue);
                    break;
                case 6:
                    displayList.get(rowIndex).setNicknames((List<String>)aValue);
                    break;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
}
