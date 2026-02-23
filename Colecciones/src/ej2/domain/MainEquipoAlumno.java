package ej2.domain;

import ej2.model.Alumno;
import ej2.model.Equipo;

import java.util.List;

public class MainEquipoAlumno {
    static void main(String[] args) {
        // creamos los equipos de alumnos
        Equipo<Alumno> equipo1 = new Equipo<>("Real Madrid CF");
        Equipo<Alumno>  equipo2 = new Equipo<>("FC Barcelona");
        //Creamos a los alumnos
        Alumno a1 = new Alumno("juan ", "12345678D");
        Alumno a2 = new Alumno("Daniel", "12345678T");

        equipo1.addAlumno(a1);
        equipo2.addAlumno(a2);

        equipo1.interseccion(equipo2);

       Equipo<Alumno> todos = equipo1.unirEquipos(equipo2);
        List<Alumno> listaAlumos = todos.motrarListaAlumnos(null);
        for (Alumno a : listaAlumos){
            System.out.println("." + a.toString());
        }


    }
}
