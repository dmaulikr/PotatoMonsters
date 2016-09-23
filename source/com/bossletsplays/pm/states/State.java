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

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> State.java [Interface]
 * 
 * <p>
 * This interface serves as the base for the game states
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public interface State {
    
    /**
     * Inits the state.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void init();
    
    /**
     * What should happen when the state is entered.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void enter();
    
    /**
     * logical calculations.
     *
     * @param stateManager The state manager
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void tick(StateManager stateManager);
    
    /**
     * Renders the graphics.
     *
     * @param g The g
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void render(Graphics2D g);
    
    /**
     * What should happen when the game leaves the state.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void exit();
    
    /**
     * Gets the name of the state.
     *
     * @return The name
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public String getName();

}
