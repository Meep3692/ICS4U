/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.physics;

/**
 *
 * @author Darian
 */
public class RectangleCollider {

    private Vector2 topLeft;
    private Vector2 size;
    //74 200
    /**
     * Create a new RectangleCollider
     * @param left x position of left side of collider
     * @param top y position of top of collider
     * @param width width of collider
     * @param height height of collider
     */
    public RectangleCollider(double left, double top, double width, double height){
        topLeft = new Vector2(left, top);
        size = new Vector2(width, height);
    }
    
    public double getLeft(){
        return topLeft.getX();
    }
    
    public double getRight(){
        return topLeft.getX() + size.getX();
    }
    
    public double getTop(){
        return topLeft.getY();
    }
    
    public double getBottom(){
        return topLeft.getY() + size.getY();
    }
    
    public void moveTo(Vector2 position){
        topLeft = position.clone();
    }
    
    /**
     * Check if this rectangle intersects another
     * @param other Other rectangle to test against
     * @return True if they intersect, otherwise false
     */
    public boolean intersects(RectangleCollider other){
        return !(getBottom() < other.getTop() || //Completely above other
                getTop() > other.getBottom() || //Completely below other
                getLeft() > other.getRight() || //Completely right of other
                getRight() < other.getLeft());//Completely left of other
    }
    
}
