/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 * A rectangle
 * Remember that x points right and y points down
 * @author Darian
 */
public class Rect {
    //Top left and botton right corners respectivly
    private Vector2 tl, br;
    
    /**
     * Create a new rectangle from corner vectors
     * @param topLeft The top left point of the rectangle
     * @param bottomRight The bottom right point of the rectangle
     */
    public Rect(Vector2 topLeft, Vector2 bottomRight){
        tl = topLeft;
        br = bottomRight;
    }
    
    /**
     * Create a new rectangle from outer bounds
     * @param left Leftmost bound
     * @param right Rightmost bound
     * @param top Topmost bound
     * @param bottom Bottommost bound
     */
    public Rect(double left, double right, double top, double bottom){
        //Create vectors and call other constructor
        this(new Vector2(left, top), new Vector2(right, bottom));
    }
    
    /**
     * Get position of top left corner
     * @return Safe vector of top left corner
     */
    public Vector2 getTopLeft(){
        return tl.clone();//Clone the vector so other classes can't modify it
    }
    
    /**
     * Get position of top right corner
     * @return Safe vector of top right corner
     */
    public Vector2 getTopRight(){
        return new Vector2(br.getx(), tl.gety());//Combine top and right of 2 vectors
    }
    
    /**
     * Get position of bottom left corner
     * @return Safe vector of bottom left corner
     */
    public Vector2 getBottomLeft(){
        return new Vector2(tl.getx(), br.gety());
    }
    
    /**
     * Get position of bottom right corner
     * @return Safe vector of bottom right corner
     */
    public Vector2 getBottomRight(){
        return br.clone();
    }
    
    /**
     * Get the y position of the top edge of the rectangle
     * @return Top edge y position
     */
    public double getTop(){
        return tl.gety();
    }
    
    /**
     * Get the y position of the bottom edge of the rectangle
     * @return Bottom edge y position
     */
    public double getBottom(){
        return br.gety();
    }
    
    /**
     * Get the x position of the left edge of the rectangle
     * @return Left edge x position
     */
    public double getLeft(){
        return tl.getx();
    }
    
    /**
     * Get the x position of the right edge of the rectangle
     * @return Right edge x position
     */
    public double getRight(){
        return br.getx();
    }
    
    /**
     * Check if this rectangle intersects another one
     * @param other The other rectangle to check against this one
     * @return True if they are intersecting, false if they are not
     */
    public boolean isIntersecting(Rect other){
        //This was originally in an if statement where it would return true else return false
        //Netbeans told me it was reduntant and did this
        return //This all checks that we have some of our rectangle in the other one
                ((getTop() > other.getTop() && getTop() < other.getBottom()) ||         //If our top is within their y area
                (getBottom() < other.getBottom() && getBottom() > other.getTop())) &&   //Or if our bottom is within their y area
                ((getLeft() > other.getLeft() && getLeft() < other.getRight()) ||       //And if our left is within their x area
                (getRight() < other.getRight() && getRight() > other.getLeft()));       //Or if our right is within their x area
                                                                                        //Them some part of us is in them
    }
}
