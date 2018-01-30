/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Darian
 */
public abstract class GameObject {
    public abstract void init(GameContainer gc);
    public abstract void update(GameContainer gc, int delta);
    public abstract void render(GameContainer gc, Graphics g);
}
