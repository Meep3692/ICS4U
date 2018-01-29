/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

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
    public AttemptResult input(Input input){
        Input nextInput = move.getInput(progress);//Get next input
        if(nextInput != input)//If wrong button pressed
            return AttemptResult.FAIL;//Fail
        progress++;//Increment progress
        if(progress == move.getLength())//If last input
            return AttemptResult.MOVE;//Successful move
        return AttemptResult.PROGRESS;//Otherwise, progressed
    }
    
}
