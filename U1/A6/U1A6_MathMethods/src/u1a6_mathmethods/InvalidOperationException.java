/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a6_mathmethods;

/**
 *
 * @author awoo
 */
public class InvalidOperationException extends Exception {
    public InvalidOperationException(String op){
        super("Unknown operation: " + op);
    }
}
