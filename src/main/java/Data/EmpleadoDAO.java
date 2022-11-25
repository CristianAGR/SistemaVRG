/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author axelg
 */
public class EmpleadoDAO {
                    private static final String SQL_SELECT ="SELECT * FROM empleados";
             private static final String SQL_SELECTXID ="SELECT * FROM empleados where idEmpleado=";
    private static final String SQL_INSERT = "INSERT INTO empleados(nombre,genero,rol,idEquipo)VALUES";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE idEmpleado=";
    
    
    
        public List<Empleado> seleccionarEmpleados(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleadolist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idEmpleado = rs.getInt("idEmpleado");
            String nombre = rs.getString("nombre");
            String genero = rs.getString("genero");
            String rol = rs.getString("rol");
            int idEquipo = rs.getInt("idEquipo");
            
            empleado = new Empleado(idEmpleado,nombre,genero, rol,idEquipo);
            empleadolist.add(empleado);
            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);//Error de SQL
            
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);//Error de SQL
            }
        
        }
        
        return empleadolist;
    }
        
     public String insertar (Empleado empleado){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (empleado.getNombre() != null) {
                            Con.ConectarBD();
               Con.sentencia.execute(SQL_INSERT +"('"+empleado.getNombre()+"','"+empleado.getGenero()+"','"+empleado.getRol()+"','"+empleado.getIdEquipo()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminar(Empleado empleado) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + empleado.getIdEmpleado());
            registros = stmt.executeUpdate();
            if(registros == 1) {
                sms="Eliminado";
            } else {
                sms="No Eliminado";
            }
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return sms;
    }
     
          public Empleado seleccionarEmpleado(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idEmpleado = rs.getInt("idProspecto");
            String nombre = rs.getString("nombre");
            String genero = rs.getString("genero");
            String rol = rs.getString("rol");
            int idEquipo = rs.getInt("idEquipo");
            
            empleado = new Empleado(idEmpleado,nombre,genero, rol, idEquipo);
            
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);//Error de SQL
            
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);//Error de SQL
            }
        
        }
        return empleado;
     }
          
     public String actualizar (Empleado empleado){
        String sms ="";
       String SQL_UPDATE ="UPDATE empleados SET nombre='"+empleado.getNombre()+"',genero='"+empleado.getGenero()+"',rol='"+empleado.getRol()+"',idEquipo='"+empleado.getIdEquipo()+"'  WHERE idEmpleado= "+empleado.getIdEmpleado();
     try { 
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            Con.sentencia.execute(SQL_UPDATE);
            sms="Registro Actualizado";
            Con.DesconectarBD();
        }catch (SQLException ex) {
            sms=ex.toString();
        }
       return sms;
    }
}
