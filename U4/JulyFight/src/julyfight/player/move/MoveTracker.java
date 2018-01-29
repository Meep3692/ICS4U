/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import java.util.EnumSet;
import julyfight.player.Input;

/**
 *
 * @author Darian
 */
public class MoveTracker {
    public final Move move;
    private int progress;

    /**
     * Create a new MoveTracker
     * @param move Move to track
     */
    public MoveTracker(Move move) {
        this.move = move;
        progress = 0;
    }
    
    /**
     * Check the next input against the move
     * @param input Next input pressed
     * @return Result of the next input
     */
    public AttemptResult input(EnumSet<Input> input){
        Input nextInput = move.getInput(progress);//Get next input
        if(!input.contains(nextInput))//If wrong button pressed
            return AttemptResult.FAIL;//Fail
        progress++;//Increment progress
        if(progress == move.getLength())//If last input
            return AttemptResult.MOVE;//Successful move
        return AttemptResult.PROGRESS;//Otherwise, progressed
    }
    
    /**
     * Check if move is held
     * @param input Current inputs
     * @return FAIL if move ends, MOVE if move holds
     */
    public AttemptResult holdInput(EnumSet<Input> input){
        Input lastInput = move.getInput(move.getLength() - 1);
        if(!input.contains(lastInput))
            return AttemptResult.FAIL;
        return AttemptResult.MOVE;
    }
    
}
