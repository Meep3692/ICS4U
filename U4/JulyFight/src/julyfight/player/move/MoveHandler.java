/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import java.util.ArrayList;
import java.util.EnumSet;
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
    private MoveTracker moveHeld;
    private final Player player;
    
    public MoveHandler(Player player){
        moves = new ArrayList<>();
        currentMoves = new ArrayList<>();
        moveHeld = null;
        this.player = player;
    }
    
    public void addMove(Move move){
        moves.add(move);
    }
    
    public void input(EnumSet<Input> input){
        if(moveHeld == null){
            for(Move move : moves){
                if(input.contains(move.getInput(0))){//If input is the start of a move
                    MoveTracker newTracker = new MoveTracker(move);//Create a tracker for that move
                    currentMoves.add(newTracker);//Add it to trackers
                }
            }
            List<MoveTracker> finishedMoves = new ArrayList<>();//Because we can't modify the list in the for each loop
            for(MoveTracker tracker : currentMoves){
                AttemptResult result = tracker.input(input);
                System.out.println(String.format("Move %s result: %s", tracker.move.getClass().getCanonicalName(), result.toString()));
                switch(result){
                    case MOVE://If move successful
                        if(moveHeld == null){//Another move started during this check may be blocking further moves
                            tracker.move.execute();//Execute move
                            if(tracker.move.continuous)
                                moveHeld = tracker;
                        }
                    case FAIL://If failed (also cont of success
                        finishedMoves.add(tracker);//Add to list of moves to remove
                    default:
                        break;
                }
            }
            currentMoves.removeAll(finishedMoves);//Remove finished moves from current moves
        }
    }
    
    /**
     * Hold an input
     * @param input Inputs being held
     */
    public void holdInput(EnumSet<Input> input){
        if(moveHeld != null && moveHeld.holdInput(input) == AttemptResult.MOVE){//If move is still held
            moveHeld.move.hold();//Execute hold on move
        }else{
            moveHeld = null;//Null moveHeld if it is not held
            //Reset modifiers
            player.defenseMod = 1;
            player.speedMod = 1;
        }
    }
    
    public void clear(){
        currentMoves.clear();
    }
}
