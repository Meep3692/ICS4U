/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

/**
 *
 * @author Darian
 */
public enum AttemptResult {
    MOVE,//Move was executed
    PROGRESS,//Move was not executed, but a correct input was pressed
    FAIL//Incorrect input was pressed
}
