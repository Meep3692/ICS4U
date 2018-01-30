/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.diefenbaker;

import julyfight.gamestate.Game;
import julyfight.player.Input;
import julyfight.player.Player;
import julyfight.player.move.Move;
import julyfight.ui.Effect;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Awoo
 */
public class Nato extends Move {

    public Nato(Game game, Player player) {
        super(game, player);
        this.inputs = new Input[]{Input.LK, Input.MP, Input.HK};
    }

    @Override
    public void execute() {
        Missle missle;
        if(player.getPlayerNumber() == 1){
            missle = new Missle((int) game.player2.getPosition().getX(), game, player);
        }else{
            missle = new Missle((int) game.player1.getPosition().getX(), game, player);
        }
        game.addGameObject(missle);
        Effect effect = new Effect(game.hitFont, "NATO!", (int)player.getPosition().getX() - game.hitFont.getWidth("NATO!") / 2, (int)player.getPosition().getY() - 100, 1);
        game.addEffect(effect);
    }

    @Override
    public void hold() {}

    @Override
    public void init(GameContainer gc) {
        
    }
    
}
