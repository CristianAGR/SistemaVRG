/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author axelg
 */
public class Equipo {
            private int idEquipo;
    private String nombre;
    private String plan;
    
    //Constuctores

    public Equipo() {
    }

    // eliminar
    public Equipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    // insertar
     public Equipo(String nombre, String plan) {
        this.nombre = nombre;
        this.plan = plan;
    }
    // editar
    public Equipo(int idEquipo,String nombre, String plan) {
         this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.plan = plan;

    }
    

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }


    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{");
        sb.append("idEquipo=").append(idEquipo);
        sb.append(", nombre=").append(nombre);
        sb.append(", plan=").append(plan);
        sb.append('}');
        return sb.toString();
    }
    


    
    


}
