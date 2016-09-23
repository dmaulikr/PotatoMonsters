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
package com.bossletsplays.pm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * <strong>Project:</strong> PotatoMonsters <br>
 * <strong>File:</strong> Console.java [Class]
 * 
 * <p>
 * This class is a helper to allow us to print log statements to both the
 * console and our file.
 * </p>
 *
 * @author Matthew Rogers
 * @since @VERSION@
 */
public class Console {

    /** The err console. */
    private static PrintStream errConsole;

    /** The out console. */
    private static PrintStream outConsole;

    /** The file output. */
    private static PrintStream fileOutput;

    /**
     * Inits the logger.
     *
     * @param file The file
     * @throws FileNotFoundException The file not found exception
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void init(String file) throws FileNotFoundException {
        errConsole = System.err;
        outConsole = System.out;

        fileOutput = new PrintStream(new FileOutputStream(new File(file)));
        System.setOut(fileOutput);
        System.setErr(fileOutput);
    }

    /**
     * Gets the console out.
     *
     * @return The console out
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static PrintStream getConsoleOut() {
        return outConsole;
    }

    /**
     * Gets the console err.
     *
     * @return The console err
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static PrintStream getConsoleErr() {
        return errConsole;
    }

    /**
     * Writes to the console and file.
     *
     * @param msg The msg
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void write(Object msg) {
        outConsole.print(msg.toString());
        System.out.print(msg.toString());
    }

    /**
     * Write line to the console and file.
     *
     * @param msg The msg
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void writeLine(Object msg) {
        outConsole.println(msg.toString());
        System.out.println(msg.toString());
    }

    /**
     * Prints Error msg to the console and file.
     *
     * @param msg The msg
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void error(Object msg) {
        errConsole.print(msg.toString());
        System.err.print("[Error] " + msg.toString());
    }

    /**
     * Prints Error line to the console and file.
     *
     * @param msg The msg
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void errorLine(Object msg) {
        errConsole.println(msg.toString());
        System.err.println("[Error] " + msg.toString());
    }

    /**
     * Catch an exception and print the stacktrace to the console and file.
     *
     * @param ex The ex
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void catchException(Exception ex) {
        System.setErr(errConsole);
        ex.printStackTrace();
        System.setErr(fileOutput);
        ex.printStackTrace();
    }

    /**
     * Catches an uncaught/unhandled exception and prints the stacktrace to the
     * console and file.
     *
     * @param th The th
     * @author Matthew Rogers
     * @since @VERSION@
     */
    public static void uncaughtException(Throwable th) {
        System.setErr(errConsole);
        th.printStackTrace();
        System.setErr(fileOutput);
        th.printStackTrace();

    }

}
