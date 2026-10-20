package org.challenge.anagrama.app;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        System.out.println("Ingrese la primer palabra: ");
        String palabra1 = IO.readln().toLowerCase();

        System.out.println("Ingrese la segunda palabra: ");
        String palabra2 = IO.readln().toLowerCase();

        boolean desigualdad = verificarDesigualdad(palabra1, palabra2);
        boolean longitud = verificarLongitud(palabra1, palabra2);
        boolean mismasLetras = verificarMismasLetras(palabra1, palabra2);
        String mensaje = generarMensaje(desigualdad, longitud, mismasLetras, palabra1, palabra2);
        mostrarMensaje(mensaje);

        System.out.println(desigualdad);
        System.out.println(longitud);
        System.out.println(mismasLetras);
        System.out.println(mensaje);

    }

    public static boolean verificarDesigualdad(String palabra1, String palabra2){
        return !palabra1.equals(palabra2);
    }

    public static boolean verificarLongitud(String palabra1, String palabra2){
        return palabra1.length() == palabra2.length();
    }

    public static boolean verificarMismasLetras(String palabra1, String palabra2){
        List<Character> listaPalabra1 = new ArrayList<>();
        List<Character> listaPalabra2 = new ArrayList<>();

        for (char c : palabra1.toCharArray()) listaPalabra1.add(c);
        for (char c : palabra2.toCharArray()) listaPalabra2.add(c);

        for (char c : listaPalabra1) {
            if (!listaPalabra2.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static String generarMensaje(boolean desigualdad, boolean longitud, boolean mismasLetras, String palabra1, String palabra2){
        if (mismasLetras && desigualdad && longitud) {
            return "La palabra " + palabra1 + " y " + palabra2 + " Si son anagramas";
        }
        else {
            return "La palabra " + palabra1 + " y " + palabra2 + " NO son anagramas";
        }
    }

    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}