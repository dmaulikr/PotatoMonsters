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
import java.util.HashMap;
import java.util.Map;

import com.bossletsplays.pm.utils.Console;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> StateManager.java [Class]
 * 
 * <p>
 * This class contains code to manage the game's states.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public class StateManager {

    /** The map that stores states. */
    private Map<String, State> map;
    
    /** The current state. */
    private State currentState;

    /**
     * Instantiates a new state manager.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public StateManager() {
        map = new HashMap<String, State>();
    }

    /**
     * Adds the state.
     *
     * @param state The state
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void addState(State state) {
        map.put(state.getName().toUpperCase(), state);
        state.init();
        if (currentState == null) {
            state.enter();
            currentState = state;
        }
    }

    /**
     * Sets the state.
     *
     * @param name The new state
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void setState(String name) {
        State state = map.get(name.toUpperCase());
        if (state == null) {
            Console.errorLine("State <" + name + "> does not exist!");
            return;
        }

        currentState.exit();
        state.enter();
        currentState = state;
    }
    
    /**
     * logical calculations.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void tick(){
        currentState.tick(this);
    }
    
    /**
     * Renders the graphics.
     *
     * @param g The g
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void render(Graphics2D g){
        currentState.render(g);
    }

}
