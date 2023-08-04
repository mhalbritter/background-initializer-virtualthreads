package com.example.sb36695;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

/**
 * @author Moritz Halbritter
 */
public class CSV {
	public static void main(String[] args) throws IOException {
		int numberOfFiles = 10;
		String prefix = "pt-vt-";
		for (int i = 1; i <= numberOfFiles; i++) {
			Path file = Path.of(prefix + i + ".txt").toAbsolutePath();
			if (!Files.exists(file)) {
				throw new IllegalArgumentException("File %s doesn't exist".formatted(file));
			}
			csv(i, file);
		}
	}

	private static void csv(int num, Path file) throws IOException {
		List<String> lines = Files.readAllLines(file);
		double runnable = extractFromDuration(lines.stream().filter(line -> line.startsWith("Runnable")).findFirst().get());
		double latch = extractFromDuration(lines.stream().filter(line -> line.startsWith("Await Latch")).findFirst().get());
		double firstRequest = extractFromDuration(lines.stream().filter(line -> line.startsWith("First request")).findFirst().get());
		double started = parseStarted(lines.stream().filter(line -> line.contains("Started Sb36695Application in")).findFirst().get());

		System.out.printf(String.format(Locale.US, "%d,%f,%f,%f,%f%n", num, runnable, latch, firstRequest, started));
	}

	private static double parseStarted(String line) {
		int start = line.indexOf("Started Sb36695Application in ");
		int end = line.indexOf(" seconds", start);
		String duration = line.substring(start + 30, end);
		return Double.parseDouble(duration);
	}

	private static double extractFromDuration(String line) {
		int pt = line.indexOf("PT");
		int s = line.indexOf("S", pt);
		if (pt == -1 || s == -1) {
			return -1;
		}
		String duration = line.substring(pt + 2, s);
		return Double.parseDouble(duration);
	}
}
