/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import java.util.ArrayList;
import java.util.List;
import julyfight.player.Input;
import julyfight.player.Player;

/**
 *
 * @author Darian
 */
public class MoveHandler {
    private final List<Move> moves;
    private final List<MoveTracker> currentMoves;
    private final Player player;
    
    public MoveHandler(Player player){
        moves = new ArrayList<>();
        currentMoves = new ArrayList<>();
        this.player = player;
    }
    
    public void input(Input input){
        for(Move move : moves){
            if(move.getInput(0) == input){
                MoveTracker newTracker = new MoveTracker(move);
                currentMoves.add(newTracker);
            }
        }
        for(MoveTracker tracker : currentMoves){
            AttemptResult result = tracker.input(input);
            switch(result){
                case MOVE:
                    tracker.move.execute();
            }
        }
    }
}
