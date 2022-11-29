/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Equipo;
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
public class EquipoDAO {
                private static final String SQL_SELECT ="SELECT * FROM equipos";
             private static final String SQL_SELECTXID ="SELECT * FROM equipos where idEquipo=";
    private static final String SQL_INSERT = "INSERT INTO equipos(nombre,plan)VALUES";
    private static final String SQL_DELETE = "DELETE FROM equipos WHERE idEquipo=";
    
    
    
        public List<Equipo> seleccionarEquipos(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equipo equipo = null;
        List<Equipo> equipolist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idEquipo = rs.getInt("idEquipo");
            String nombre = rs.getString("nombre");
            String plan = rs.getString("plan");
            
            equipo = new Equipo(idEquipo,nombre,plan);
            equipolist.add(equipo);
            
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
        
        return equipolist;
    }
        
     public String insertar (Equipo equipo){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (equipo.getNombre() != null) {
                            Con.ConectarBD();
               Con.sentencia.execute(SQL_INSERT +"('"+equipo.getNombre()+"','"+equipo.getPlan()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminar(Equipo equipo) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + equipo.getIdEquipo());
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
     
          public Equipo seleccionarEquipo(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equipo equipo = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idEquipo = rs.getInt("idEquipo");
            String nombre = rs.getString("nombre");
            String plan = rs.getString("plan");
            
            equipo = new Equipo(idEquipo,nombre,plan);
            
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
        return equipo;
     }
          
     public String actualizar (Equipo equipo){
        String sms ="";
       String SQL_UPDATE ="UPDATE equipo SET nombre='"+equipo.getNombre()+"',plan='"+equipo.getPlan()+"'  WHERE idEquipo= "+equipo.getIdEquipo();
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
