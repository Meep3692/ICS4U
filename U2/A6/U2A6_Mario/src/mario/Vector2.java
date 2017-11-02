/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 * Store a vector and do vector maths
 * Remember that x points right and y points down
 * @author Darian
 */
public class Vector2 {
    //x and y components of the vector
    private double x, y;
    
    /**
     * Construct with x and y components
     * @param x The x component
     * @param y The y component
     */
    public Vector2(double x, double y){
        this.x = x;//Set variables
        this.y = y;
    }
    
    /**
     * Create zero vector; all values are zero
     */
    public Vector2(){
        this(0, 0);//Call other constructor with 0s
    }
    
    /**
     * Get the x component
     * @return The x component of this vector
     */
    public double getx(){
        return x;
    }
    
    /**
     * Set the x component
     * @param x New x component for this vector
     */
    public void setx(double x){
        this.x = x;
    }
    
    /**
     * Get the y component
     * @return The y component of this vector
     */
    public double gety(){
        return y;
    }
    
    /**
     * Set the y component
     * @param y New y component for this vector
     */
    public void sety(double y){
        this.y = y;
    }
    
    /**
     * Get the magnitude
     * @return The magnitude of this vector
     */
    public double getMagnitude(){
        return Math.sqrt((x*x) + (y*y));//Calculate magnitude
    }
    
    /**
     * Set the magnitude
     * @param r New magnitude for this vector
     */
    public void setMagnitude(double r){
        double theta = getDirection();//Get direction of vector
        x = Math.cos(theta) * r;//Convert direction and magnitude into x and y
        y = Math.sin(theta) * r;
    }
    
    /**
     * Get the direction
     * @return The direction of this vector
     */
    public double getDirection(){
        return Math.atan(y/x);//Calculate direction
    }
    
    /**
     * Sets the direction
     * @param theta New direction for this vector
     */
    public void setDirection(double theta){
        double r = getDirection();//Get magnitude
        x = Math.cos(theta) * r;//Convert polar to cartesian
        y = Math.sin(theta) * r;
    }
    
    /**
     * Add one vector to another
     * @param first First vector
     * @param second Vector to add to first
     * @return first + second
     */
    public static Vector2 add(Vector2 first, Vector2 second){
        double x = first.getx() + second.getx();//Add x components
        double y = first.gety() + second.gety();//Add y components
        return new Vector2(x, y);//Create vector and return it
    }
    
    /**
     * Subtract one vector from another
     * @param first First vector
     * @param second Vector to subtract from first
     * @return first - second
     */
    public static Vector2 sub(Vector2 first, Vector2 second){
        double x = first.getx() - second.getx();//Subtract x components
        double y = first.gety() - second.gety();//Subtract y components
        return new Vector2(x, y);//Create vector and return it
    }
    
    public static Vector2 mul(Vector2 vector, double scalar){
        Vector2 out = vector.clone();//Clone vector to be safe
        out.setMagnitude(out.getMagnitude() * scalar);
        return out;
    }
    
    /**
     * Create a clone of this vector
     * @return A clone of this vector in a different location in memory
     */
    @Override
    public Vector2 clone(){
        return new Vector2(x, y);
    }
}
