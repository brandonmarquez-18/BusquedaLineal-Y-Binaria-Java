package busquedas;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Busquedas {
    public static void main(String[] args) {
        ArrayList<Integer> vectorDinamico = new ArrayList<Integer>();
        int enteroABuscar = 0;
        int RepetirMenu = 0;
        while (RepetirMenu <= 0 || RepetirMenu > 5) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("ELIGA UNA OPCIÓN DEL MENÚ:\n"
                    + "1.- INGRESAR ENTEROS AL VECTOR.\n"
                    + "2.- REALIZAR BUSQUEDA LINEAL.\n"
                    + "3.- REALIZAR BUSQUEDA BINARIA.\n"
                    + "4.- SALIR"));
            switch (opc) {
                case 1:
                    vectorDinamico.add(Integer.parseInt(JOptionPane.showInputDialog("DIGITA UN ENTERO:")));
                    break;
                case 2:
                    enteroABuscar = Integer
                            .parseInt(JOptionPane.showInputDialog("DIGITA EL ENTERO A BUSCAR EN EL VECTOR:"));
                    int size = vectorDinamico.size();
                    for (int i = 0; i < vectorDinamico.size(); i++) {
                        if (vectorDinamico.get(i) == enteroABuscar) {
                            JOptionPane.showMessageDialog(null,
                                    "EL TIEMPO QUE SE LLEVO ACABO PARA ENCONTRAR EL NÚMERO QUÉ DIJITÓ FUE DE: "
                                            + (i + 1) + " VUELTA'S");
                        }
                    }
                    break;
                case 3:
                    enteroABuscar = Integer
                            .parseInt(JOptionPane.showInputDialog("DIGITA EL ENTERO A BUSCAR EN EL VECTOR:"));
                    for (int i = 0; i < vectorDinamico.size(); i++) {
                        if (enteroABuscar == vectorDinamico.get(i)) {
                            JOptionPane.showMessageDialog(null, BusquedaBinaria(vectorDinamico, enteroABuscar)
                                    + " FUE EL NÚMERO DE VUELTAS PARA ENCONTRAR EL ENTERO");
                        }
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "BYE.....");
                    RepetirMenu = 2;
                    break;
            }
        }
    }

    public static int BusquedaBinaria(ArrayList<Integer> vectorDinamico, int dato) {
        Collections.sort(vectorDinamico);
        int n = vectorDinamico.size();
        int mitad;
        int inferior = 0;
        int superior = n - 1;
        while (inferior <= superior) {
            mitad = (superior + inferior) / 2;

            if (vectorDinamico.get(mitad) == dato) {
                return mitad + 1;
            } else if (dato < vectorDinamico.get(mitad)) {
                superior = mitad - 1;
            } else {
                inferior = mitad + 1;
            }
        }
        return -1;
    }
}