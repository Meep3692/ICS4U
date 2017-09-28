/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a6_mathmethods.operations;

import u1a6_mathmethods.Operation;

/**
 *
 * @author awoo
 */
public class Pi implements Operation {

    @Override
    public String getTextualRepresentation() {
        return "pi";
    }

    @Override
    public int getOperandCount() {
        return 0;
    }

    @Override
    public double calculate(double[] operands) {
        return Math.PI;
    }
    
}
