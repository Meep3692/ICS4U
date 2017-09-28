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
public interface Operation {
    /**
     * Get the textual representation of this operator
     * @return The text that will be input to perform this operation
     */
    String getTextualRepresentation();
    /**
     * Get the number of operands required by this function
     * @return Number of operands
     */
    int getOperandCount();
    /**
     * Perform the operation
     * @param operands Operands to perform the calculation on. Should have a size equal to the result of getOperandCount()
     * @return The result of the operation
     */
    double calculate(double[] operands);
}
