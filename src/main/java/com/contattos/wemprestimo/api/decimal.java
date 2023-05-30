package com.contattos.wemprestimo.api;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class decimal {

	private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("#,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
	private static final String[] SUFFIXES = new String[] {"", "K", "M", "B", "T", "Q", "QQ", "S", "SS", "O", "N", "D", "U", "DD", "UD", "TD", "QD", "QQD", "SD", "SSD", "OD", "ND", "V", "W", "X", "Y", "Z", "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN"};
	private static final int MAX_LENGTH = 4;
	private static final double MAX_VALUE = Math.pow(1000, SUFFIXES.length);

	public static String formatSimbolo(double number) {
		if (number < 0 || number >= MAX_VALUE) {
			return NUMBER_FORMAT.format(number);
		}

		int suffixIndex = 0;
		while (number >= 1000 && suffixIndex < SUFFIXES.length - 1) {
			number /= 1000;
			suffixIndex++;
		}

		String formattedNumber = NUMBER_FORMAT.format(number);
		String suffix = SUFFIXES[suffixIndex];

		if (formattedNumber.length() > MAX_LENGTH) {
			formattedNumber = formattedNumber.substring(0, MAX_LENGTH);
		}

		return formattedNumber + suffix;
	}
}
