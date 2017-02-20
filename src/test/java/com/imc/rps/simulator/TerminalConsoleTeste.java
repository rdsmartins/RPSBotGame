/**
 * 
 */
package com.imc.rps.simulator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import org.powermock.reflect.Whitebox;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.view.TerminalConsole;

/**
 * @author rodrigomartins
 *
 */
public class TerminalConsoleTeste {

	@Test
	public void test_setHumanGesture_getHumanGesture() throws Exception {
		TerminalConsole terminal = new TerminalConsole();
		Whitebox.invokeMethod(terminal, "setHumanGesture", 1);
		
		Gesture actual = terminal.getHumanGesture();
		Gesture expected = Gesture.values()[1-1];
		assertEquals(actual	, expected);
	}
	@Test
	public void test_verifyIsHumanGestureIndexIsvalid() throws Exception{
		TerminalConsole terminal = new TerminalConsole();
		ByteArrayInputStream in = new ByteArrayInputStream("30".getBytes());
		Scanner keyboard = new Scanner(in);
		
		Object ret = Whitebox.invokeMethod(terminal, "verifyIsHumanGestureIndexIsvalid", keyboard);
		
		Object actual = ret;
		Object expected = false;
		assertEquals(actual	, expected);
	}

}
