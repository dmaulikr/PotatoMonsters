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
package com.bossletsplays.pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.bossletsplays.pm.states.GameState;
import com.bossletsplays.pm.states.StateManager;
import com.bossletsplays.pm.utils.Console;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> Game.java [Class]
 * 
 * <p>
 * This class contains the core game code. Such as the game loop and whatnot.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public class Game extends Canvas implements Runnable {
    
    
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4233025245510081154L;
    
    
    /** The Constant TITLE. */
    public static final String TITLE = "Potato Monsters";
    
    /** The Constant WIDTH. */
    public static final int WIDTH = 1200; // normally id go with 640, but I have a 4k monitor now so I need bigger game
    
    /** The Constant HEIGHT. */
    public static final int HEIGHT = WIDTH / 4 * 3; // 4:3 ratio
    
    /** The Constant DEBUG. */
    public static final boolean DEBUG = true;
    
    /** The running flag. */
    private boolean running;
    
    /** The main thread. */
    private Thread mainThread;
    
    /** The state manager. */
    private StateManager sm;
    
    /** The instance of the game. */
    public static Game INSTANCE;
    

    /**
     * Instantiates a new game.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public Game(){
        //TODO: Construct stuff
        sm = new StateManager();
        sm.addState(new GameState());
        INSTANCE = this;
    }
    
    /**
     * Runs the logical calculations of the game
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    private void tick() {
        sm.tick();
    }
    
    /**
     * Renders the graphics
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            // create a tripple buffer strategy to avoid flickering when doing animations
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        
        // render game
        sm.render(g2d);
        
        g.dispose();
        bs.show();
    }
    
    @Override
    public void run(){
        requestFocus();
        double targetFPS = 60.0; // the fps we wish to limit the game to
        double nsPerTick = 1e9 / targetFPS; // thanks to Flaflo for telling me I could reduce 1000000000 to 1e9
        long lastTime = System.nanoTime(); // the time before the current loop cycle, in nano seconds
        long timer = System.currentTimeMillis(); // we will use this as a timer so we only print the fps every second
        double unprocessed = 0.0; // unprocessed time
        int fps = 0;
        int tps = 0;
        boolean canRender = false;
        
        while(running){
            long now = System.nanoTime(); // the time at the beginning of the current loop cycle
            unprocessed += (now - lastTime) / nsPerTick; // unprocessed time is calculated
            lastTime = now; // the last time needs to take the value of now to be used for the next cycle
            
            // if there is more than 1.0 of unprocessed time, do the logical calculations
            if(unprocessed >= 1.0){
                tick();
                // key and mouse input
                unprocessed--;
                tps++;
                canRender = true; // we can render :)
            } else canRender = false; // we can't render :(
            
            try {
                Thread.sleep(1); // lets put the thread to sleep so the game doesn't get too overloaded
            } catch (InterruptedException ex) {
                Console.catchException(ex);
            }
            
            if(canRender){
                render();
                fps++;
            }
            
            // print fps to the console every second
            if(System.currentTimeMillis() - 1000 > timer){
                timer+=1000;
                Console.getConsoleOut().printf("FPS: %d | TPS: %d\n", fps, tps);
                fps = 0;
                tps = 0;
            }
        }
        
        System.exit(0);
    }
    
    /**
     * Start.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void start(){
        if(running) return;
        running = true;
        mainThread = new Thread(this, TITLE + "-main");
        
        // If there is an exception thrown that we don't handle, lets let this method print the stack trace
        mainThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Console.uncaughtException(e);
            }
        });
        mainThread.start();
    }
    
    /**
     * Stop.
     *
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public void stop(){
        if(!running) return;
        running = false;
        try {
            mainThread.join(); // safely exit the thread when we can
        } catch (InterruptedException ex) {
            Console.catchException(ex);
            System.exit(1);
        }
    }

}
