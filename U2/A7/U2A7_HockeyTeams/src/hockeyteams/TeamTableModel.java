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
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Darian
 */
public class TeamTableModel implements TableModel {

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
            if(gradeFilter[player.getGrade() - 9] &&//Test if grade should be shown
                    teamFilter.get(player.getTeam()) &&//And test if team should be shown
                    positionFilter.get(player.getPosition())){//And test if position should be shown
                displayList.add(player);//Add player to display list
            }
        }
    }
    
    public void setGradeFilter(int grade, boolean show){
        //Subtract 9 to get index in array from grade
        //(9 -> 0, 10 -> 1,...)
        gradeFilter[grade - 9] = show;
    }
    
    public void setTeamFilter(Team team, boolean show){
        //Just set the value in the map to the one specified
        teamFilter.put(team, show);
    }
    
    public void setPositionFilter(Position position, boolean show){
        //Same as team filter
        positionFilter.put(position, show);
    }
    
    public void addPlayer(HockeyPlayer player){
        players.add(player);
        refreshDisplay();
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
        return String.class;//For now, they're all strings. Will probably change this
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;//don't allow editing for now. Will change this with column classes
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
                return displayList.get(rowIndex).getNumberPreference(0);
            case 6:
                return displayList.get(rowIndex).getNicknames().get(0);
            default://This is for columns that can't exist in this table
                return "This shouldn't happen";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
