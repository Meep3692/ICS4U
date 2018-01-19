/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.physics;

/**
 *
 * @author Awoo
 */
public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getMagnitude(){
        return Math.sqrt((x * x) + (y * y));
    }
    
    public void setMagnitude(double magnitude){
        double direction = getDirection();
        setX(Math.cos(direction) * magnitude);
        setY(Math.sin(direction) * magnitude);
    }
    
    public void add(Vector2 other){
        x += other.getX();
        y += other.getY();
    }
    
    public void addX(double amount){
        x += amount;
    }
    
    public void addY(double amount){
        y += amount;
    }
    
    public static Vector2 add(Vector2 left, Vector2 right){
        return new Vector2(left.getX() + right.getX(), left.getY() + right.getY());
    }
    
    public void multiply(double factor){
        setMagnitude(getMagnitude() * factor);
    }
    
    public static Vector2 multiply(Vector2 vector, double factor){
        Vector2 output = vector.clone();
        output.multiply(factor);
        return output;
    }
    
    public double getDirection(){
        return Math.atan2(y, x);
    }
    
    public void setDirection(double direction){
        double magnitude = getMagnitude();
        setX(Math.cos(direction) * magnitude);
        setY(Math.sin(direction) * magnitude);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector2 clone(){
        return new Vector2(x, y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2 other = (Vector2) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }
    
}
