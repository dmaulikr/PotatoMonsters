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
package com.bossletsplays.pm.entities;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> Player.java [Class]
 * 
 * <p>
 * The player class.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public class Player extends LivingEntity {

    /**
     * Instantiates a new player.
     *
     * @param x The x
     * @param y The y
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public Player(float x, float y) {
        super(x, y, 100);

    }

    @Override
    public void move() {}

    @Override
    public void attack() {}

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int) x, (int) y, 64, 64);
    }

}
