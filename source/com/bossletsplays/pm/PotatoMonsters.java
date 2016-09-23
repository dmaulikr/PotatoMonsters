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

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import com.bossletsplays.pm.utils.Console;

public class PotatoMonsters {
    
    public static void main(String[] args){
        // Initialize our console logging system
        try {
            Console.init("./console.log");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        // create the game, needs to be final so we can access it in the windowClosing method
        final Game game = new Game();
        JFrame frame = new JFrame(Game.TITLE);
        frame.add(game);
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        // We could use setDefaultCloseOperation, but I prefer this way
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Log it to the console cause why not
                Console.writeLine("Closing game");
                game.stop();
            }
        });
        
        // make window appear in center of monitor
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }

}
