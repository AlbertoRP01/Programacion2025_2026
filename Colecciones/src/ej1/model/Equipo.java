package ej1.model;

import ej1.exceptions.EquipoException;

import java.util.*;

public class Equipo {
    private String nomnbre;
    private Set<Alumno> alumnos;

    public Equipo(String nomnbre) {
        this.nomnbre = nomnbre;
        this.alumnos = new HashSet<>();
    }

    public Equipo(String nomnbre, Set<Alumno> alumnos) {
        this.nomnbre = nomnbre;
        this.alumnos = alumnos;
    }

    /**
     * Añades a un alumno al equipo
     *
     * @param alumno
     */
    public void addAlumno(Alumno alumno) {
        if (!alumnos.add(alumno)) {
            throw new EquipoException("No  se pudo añadir el alumno");
        }
    }

    /**
     * eliminas al alumno del equipo,   en el caso de que no pertenezca al equipo
     * lanza una excepcion
     *
     * @param alumno
     */
    public void removeAlumno(Alumno alumno) {
        if (!alumnos.remove(alumno)) {
            throw new EquipoException("El alumno no pertenece al equipo");
        }
    }

    /**
     * TODO: Queremos saber si ese alumno pertenece al equipo
     *
     * @param a
     * @return devuelve al alumno en caso de que se encuentre
     */
    public Alumno PerteneceAlEquipo(Alumno a) {
        if (!alumnos.contains(a)) {
            return null;

        } else {
            return a;
        }
    }

    /**
     * Muestra la lista de alumnos
     *
     * @param alumno
     * @return devuelve la lista de alumnos
     */
    public List<Alumno> motrarListaAlumnos(Alumno alumno) {
        return new ArrayList<>(alumnos);
    }

    /**
     * TODO:Unimos los equipos  creando otro equipo nuevo a traves de una coleccion de alumnos nuevo
     *
     * @param
     * @return devuelve el equipo resultante
     */
    public Equipo unirEquipos(Equipo a) {
        Set<Alumno> union = new HashSet<>();
        union.addAll(alumnos);
        union.addAll(a.alumnos);
        Equipo resultante = new Equipo("Union FC");
        resultante.alumnos = union;
        return resultante;
    }

    /**
     * TODO:
     *
     * @param
     * @return devuelve un equipo nuevo
     */
    public Equipo unirEquipos2(Equipo a) {
        Set<Alumno> union = new HashSet<>();
        union.addAll(alumnos);
        union.addAll(a.alumnos);
        return new Equipo("Union FC");
    }

    /**
     * Retenemos todos los elememntos de la coleccion y se la pasamos a la nueva para que no se borre los elementos
     * de la original
     * @param a
     * @return devuelve el equipo
     */
    public Equipo interseccion(Equipo a) {
        Set<Alumno> union = new HashSet<>(this.alumnos);
        union.retainAll(a.alumnos);
        return new Equipo("Union FC", union);
    }
}


