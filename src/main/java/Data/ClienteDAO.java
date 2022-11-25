
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
            private static final String SQL_SELECT ="SELECT * FROM clientes";
            private static final String SQL_SELECTXID ="SELECT idCliente,nombre,empresa,numero,correo,idEquipo FROM clientes where idCliente=";
            private static final String SQL_INSERT = "INSERT INTO clientes(nombre,empresa,numero,correo,idEquipo)VALUES";
            private static final String SQL_DELETE = "DELETE FROM clientes WHERE idCliente=";
    
    
    
        public List<Cliente> seleccionarClientes(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientelist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idCliente = rs.getInt("idCliente");
            String nombre = rs.getString("nombre");
            String empresa = rs.getString("empresa");
            String numero = rs.getString("numero");
            String correo = rs.getString("correo");
            int idEquipo = rs.getInt("idEquipo");
            
            cliente = new Cliente(idCliente,nombre,empresa,numero,correo,idEquipo);
            clientelist.add(cliente);
            
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
        
        return clientelist;
    }
        
     public String insertarCliente (Cliente cliente){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (cliente.getNombre() != null) {
                            Con.ConectarBD();
               Con.sentencia.execute(SQL_INSERT +"('"+cliente.getNombre()+"','"+cliente.getEmpresa()+"','"+cliente.getNumero()+"','"+cliente.getCorreo()+"','"+cliente.getIdEquipo()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminarCliente(Cliente cliente) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + cliente.getIdCliente());
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
     
          public Cliente seleccionarCliente(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idCliente = rs.getInt("idCliente");
            String nombre = rs.getString("nombre");
            String empresa = rs.getString("empresa");
            String numero = rs.getString("numero");
            String correo = rs.getString("correo");
            int idEquipo = rs.getInt("idEquipo");
            cliente = new Cliente(idCliente,nombre,empresa, numero, correo, idEquipo);
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
        return cliente;
     }
          
     public String actualizarCliente (Cliente cliente){
        String sms ="";
       String SQL_UPDATE ="UPDATE clientes SET nombre='"+cliente.getNombre()+"',empresa='"+cliente.getEmpresa()+"',numero='"+cliente.getNumero()+"',correo='"+cliente.getCorreo()+"',idEquipo='"+cliente.getIdEquipo()+"'  WHERE idCliente= "+cliente.getIdCliente();
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
