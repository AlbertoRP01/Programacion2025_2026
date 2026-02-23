package ej2.domain;

import ej2.model.Alumno;
import ej2.model.Equipo;

import java.util.HashSet;
import java.util.List;

public class MainEquipoInteger {
    static void main(String[] args) {
        Equipo<Integer> equipoA = new Equipo<>("Primos");
        equipoA.addAlumno(2);
        equipoA.addAlumno(3);
        equipoA.addAlumno(5);

        Equipo<Integer> equipoB = new Equipo<>("Pares");
        equipoB.addAlumno(2);
        equipoB.addAlumno(4);
        equipoB.addAlumno(6);

        // 1. Probamos la Intersección (elementos comunes)
        Equipo<Integer> inter = equipoA.interseccion(equipoB);
        System.out.println("Intersección: " + inter.motrarListaAlumnos(null));

        // 2. Probamos la Unión (todos sin repetir)
        Equipo<Integer> union = equipoA.unirEquipos(equipoB);
        System.out.println("Unión: " + union.motrarListaAlumnos(null));
    }
}
