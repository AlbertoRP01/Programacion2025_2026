package ej2.model;

import ej2.exceptions.EquipoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo <T>{
    private String nombre;
    private Set<T> integrantes;

    public Equipo(String nomnbre) {
        this.nombre = nomnbre;
        this.integrantes = new HashSet<T>();
    }

    public Equipo(String nomnbre, Set<T> alumnos) {
        this.nombre = nomnbre;
        this.integrantes = alumnos;
    }

    /**
     * Añades a un alumno al equipo
     *
     * @param elemento
     */
    public void addAlumno(T elemento) {
        if (!integrantes.add(elemento)) {
            throw new EquipoException("No  se pudo añadir el alumno");
        }
    }

    /**
     * eliminas al alumno del equipo,   en el caso de que no pertenezca al equipo
     * lanza una excepcion
     *
     * @param elemento
     */
    public void removeAlumno(T elemento) {
        if (!integrantes.remove(elemento)) {
            throw new EquipoException("El alumno no pertenece al equipo");
        }
    }

    /**
     * TODO: Queremos saber si ese alumno pertenece al equipo
     *
     * @param a
     * @return devuelve al alumno en caso de que se encuentre
     */
    public T PerteneceAlEquipo(T a) {
        if (!integrantes.contains(a)) {
            return null;

        } else {
            return a;
        }
    }

    /**
     * Muestra la lista de alumnos
     *
     * @param elemento
     * @return devuelve la lista de alumnos
     */
    public List<T> motrarListaAlumnos(T elemento) {
        return new ArrayList<>(integrantes);
    }

    /**
     * TODO:Unimos los equipos  creando otro equipo nuevo a traves de una coleccion de alumnos nuevo
     *
     * @param
     * @return devuelve el equipo resultante
     */
    public Equipo<T> unirEquipos(Equipo<T> a) {
        Set<T> union = new HashSet<>(this.integrantes);
        union.addAll(integrantes);
        union.addAll(a.integrantes);
        Equipo resultante = new Equipo("Union FC");
        resultante.integrantes = union;
        return resultante;
    }

    /**
     * TODO:
     *
     * @param
     * @return devuelve un equipo nuevo
     */
    public Equipo<T> unirEquipos2(Equipo<T> a) {
        Set<T> union = new HashSet<>(this.integrantes);
        union.addAll(integrantes);
        union.addAll(a.integrantes);
        return new Equipo("Union FC");
    }

    /**
     * Retenemos todos los elememntos de la coleccion y se la pasamos a la nueva para que no se borre los elementos
     * de la original
     * @param a
     * @return devuelve el equipo
     */
    public Equipo<T> interseccion(Equipo<T> a) {
        Set<T> union = new HashSet<>(this.integrantes);
        union.retainAll(a.integrantes);
        return new Equipo("Union FC", union);
    }
}


