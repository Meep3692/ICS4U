/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a6_mathmethods;

import u1a6_mathmethods.operations.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Class for handling reverse-polish operations
 * @author awoo
 */
public class RPC {
    //Stack to hold data
    private final Stack stack;
    private final HashMap<String, Operation> operations;
    
    public RPC(){
        stack = new Stack();
        operations = new HashMap<>();
        //Start populating the operations
        addOp(Add.class);
        addOp(Subtract.class);
        addOp(Multiply.class);
        addOp(Divide.class);
        addOp(Power.class);
        addOp(Sine.class);
        addOp(Cosine.class);
        addOp(Tangent.class);
        addOp(Pi.class);
    }    
    
    public void stackString(String input){
        String[] parts = input.split(" ");
        for(String part : parts){
            stack.push(part);
        }
    }
    
    public double parseString(String input) throws InvalidOperationException{
        stack.clear();
        stackString(input);
        return calculateNext();
    }
    
    private double calculateNext() throws InvalidOperationException{
        String nextOp = (String)stack.pop();
        try{
            //Is it a number?
            double output = Double.parseDouble(nextOp);
            return output;
        }catch(NumberFormatException e){
            //It's an operation
            Operation op = operations.get(nextOp);
            //Make sure it's valid
            if(op == null){
                //We're going to have a problem here
                throw new InvalidOperationException(nextOp);
            }else{
                double[] operands = getOperands(op.getOperandCount());
                //Perform calculation
                return op.calculate(operands);
            }
        }
    }
    
    private double[] getOperands(int count) throws InvalidOperationException{
        double[] operands = new double[count];
        //This loop is backwards so the operands are in order
        for(int i = count - 1; i >= 0; i--){
            operands[i] = calculateNext();
        }
        return operands;
    }
    
    //Add operation to operations
    private void addOp(Class op){
        try {
            //Create a new instance and add it to the list
            Operation operation = (Operation)op.newInstance();
            operations.put(operation.getTextualRepresentation(), operation);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
