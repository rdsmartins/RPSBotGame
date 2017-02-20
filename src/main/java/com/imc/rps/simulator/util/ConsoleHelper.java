package com.imc.rps.simulator.util;

public class ConsoleHelper {
	public static void printQuestion(String msg) {
		printText(msg, false);
	}

	public static void logResult(String msg) {
		printText(msg, true);

	}

	public static void printLog(String msg) {
		printText(msg, true);
	}

	public static void printText(String msg, boolean newLine) {
		if (newLine) {
			System.out.println(msg);
			return;
		}
		System.out.print(msg);
	}

	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();

	}
}
