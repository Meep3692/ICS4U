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
 * @author Awoo
 */
public interface GameState {
    void init(GameContainer gc);
    void update(GameContainer gc, int delta);
    void render(GameContainer gc, Graphics g);
}
