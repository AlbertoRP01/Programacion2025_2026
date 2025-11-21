package ej1.persona;

import ej1.excepciones.PersonaException;

import java.time.LocalDate;

public class Persona {
    private  String nombre;
    private LocalDate fechaNac;
    private  int dni;
    private char sexo;
    private float altura ;
    private float peso;

    public Persona(String nombre, LocalDate fechaNac, int dni, char sexo, float altura, float peso) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public char getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setDni(int dni) throws PersonaException {
        if (dni < 0){
            throw new PersonaException("No puedes Introducir un dni negativo");
        }
        this.dni = dni;
    }

    public void setAltura(float altura) throws PersonaException {
        if (altura < 0){
            throw new PersonaException("No puedes introducir una altura negativa");
        }
        this.altura = altura;
    }

    public void setPeso(float peso) throws PersonaException {
        if (peso < 0 ){
            throw new PersonaException("No puedes introducir un peso negativo");
        }
        this.peso = peso;
    }

    public void setSexo(char sexo) throws PersonaException {
        if (sexo != 'M' && sexo != 'F') {
            throw new PersonaException("No puedes introducir otro tipo de genero");
        }
        this.sexo = sexo;
    }

    public String letraDni(){
        char letra;
        String dniEntero;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        letra = letras.charAt(this.dni % letras.length());
        dniEntero = "" + this.dni + letra;
        return dniEntero;
    }

    public  double getIMC(){
        return this.peso / (Math.pow(altura, 2));
    }

    @Override
    public String toString() {
        return "Persona:" +
                "nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", dni=" + dni +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                ".";
    }
}
