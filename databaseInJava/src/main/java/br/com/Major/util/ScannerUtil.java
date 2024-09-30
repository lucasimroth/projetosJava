package br.com.Major.util;

import java.util.Scanner;

/**
 * Classe utilitária para obter um Scanner
 */

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
}