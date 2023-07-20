/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bsu.fpmi.edupract;

/**
 *
 * @author Suerte.Mind
 */
public class AnswerEvent extends java.util.EventObject {
    public static final int MESS = 0;  // Button constants
    protected int id;                             // Which button was pressed?
    public AnswerEvent(Object source, int id) {
	super(source);
	this.id = id;
    }
    public int getID() { return id; }             // Return the button
}

