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

import java.awt.Graphics2D;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> Entity.java [Class]
 * 
 * <p>
 * This class is the core api for the entity system.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public abstract class Entity {

    /** The x and y positions. */
    protected float x, y;

    /**
     * Instantiates a new entity.
     *
     * @param x The x
     * @param y The y
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    
    /**
     * logical calculations.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public abstract void tick();
    
    /**
     * Renders the graphics.
     *
     * @param g The g
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public abstract void render(Graphics2D g);
    
    /**
     * Gets the x.
     *
     * @return The x
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x.
     *
     * @param x The new x
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y.
     *
     * @return The y
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y.
     *
     * @param y The new y
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void setY(float y) {
        this.y = y;
    }

}
