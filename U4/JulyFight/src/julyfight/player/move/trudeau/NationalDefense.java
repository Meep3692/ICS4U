/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.trudeau;

import julyfight.gamestate.Game;
import julyfight.player.Input;
import julyfight.player.Player;
import julyfight.player.move.Move;
import julyfight.ui.Effect;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Darian
 */
public class NationalDefense extends Move {

    public NationalDefense(Game game, Player player) {
        super(game, player);
        this.inputs = new Input[]{Input.LP, Input.MP, Input.HP};
    }

    @Override
    public void execute() {
        CAF caf = new CAF((int) player.getPosition().getX(), player, game);
        game.addGameObject(caf);
        Effect effect = new Effect(game.hitFont, "Just Watch Me", (int)player.getPosition().getX() - game.hitFont.getWidth("Just Watch Me") / 2, (int)player.getPosition().getY() - 256, 1);
        game.addEffect(effect);
    }

    @Override
    public void hold() {}

    @Override
    public void init(GameContainer gc) {
        
    }
    
}
