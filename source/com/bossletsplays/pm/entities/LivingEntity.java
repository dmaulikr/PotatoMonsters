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

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> LivingEntity.java [Class]
 * 
 * <p>
 * This class contains the api for living entities
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public abstract class LivingEntity extends Entity {
    
    /** The health. */
    protected int health;
    
    /** The alive. */
    protected boolean alive;
    
    /** The dx and dy values, sometimes refered to as delta or velocities. */
    protected float dx, dy;

    /**
     * Instantiates a new living entity.
     *
     * @param x The x
     * @param y The y
     * @param health The health
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public LivingEntity(float x, float y, int health) {
        super(x, y);
        this.health = health;
    }
    
    /**
     * Move.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public abstract void move();
    
    /**
     * Attack.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public abstract void attack();
    
    @Override
    public void tick() {
        move();
    }
    
    /**
     * On destroyed.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void onDestroyed() {
        alive = false;
    }
    
    /**
     * Checks if <code>this</code> is alive.
     *
     * @return true, if <code>this</code> is alive
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public boolean isAlive(){
        return alive;
    }
    
    /**
     * Gets the health.
     *
     * @return The health
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public int getHealth() {
        return health;
    }

}
