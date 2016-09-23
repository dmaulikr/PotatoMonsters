/*   Copyright 2016 Matthew Rogers "BossLetsPlays"
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package com.bossletsplays.pm.states;

import java.awt.Graphics2D;

import com.bossletsplays.pm.entities.Player;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> GameState.java [Class]
 * 
 * <p>
 * This state is the actual playable game.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public class GameState implements State {
    
    /** The player. */
    private Player player;

    @Override
    public void init() {
        player = new Player(400, 500);
    }

    @Override
    public void enter() {}

    @Override
    public void tick(StateManager stateManager) {
        player.tick();
    }

    @Override
    public void render(Graphics2D g) {
        player.render(g);
    }

    @Override
    public void exit() {}

    @Override
    public String getName() {
        return "GAME_STATE";
    }

}
