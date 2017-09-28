/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a6_mathmethods.operations;

import u1a6_mathmethods.InvalidOperationException;
import u1a6_mathmethods.Operation;
import u1a6_mathmethods.RPC;

/**
 *
 * @author awoo
 */
public class Multiply implements Operation {
    
    @Override
    public String getTextualRepresentation() {
        return "*";
    }

    @Override
    public int getOperandCount() {
        return 2;
    }

    @Override
    public double calculate(double[] operands){
        return operands[0] * operands[1];
    }
    
}
