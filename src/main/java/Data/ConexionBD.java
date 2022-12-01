
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionBD {
    
        public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    private static final String url_bd="jdbc:mysql://localhost:3306/sistemaVRG?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String user_bd="root";
    private static final String pass_bd="123456";
    
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(url_bd);
            dataSource.setUsername(user_bd);
            dataSource.setPassword(pass_bd);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
  public void ConectarBD(){
  try {
     final String Controlador="com.mysql.jdbc.Driver";
     Class.forName(Controlador);
     conexion=DriverManager.getConnection(url_bd,user_bd,pass_bd);
     sentencia=conexion.createStatement();
    }
    catch(ClassNotFoundException | SQLException ex){
     System.out.print(ex);
    }
  }
  
  public  void DesconectarBD(){
  try{
      if(conexion!=null){
        if(sentencia!=null){
          sentencia.close();
        }
        conexion.close();
      }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }
  public static Connection getConnection() throws SQLException{
   try {
            Class.forName("com.mysql.jdbc.Driver");
            return getDataSource().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getDataSource().getConnection();
  }
      public static void close(ResultSet rs)throws SQLException{
    rs.close();
    }
    //Ejecuta la sentencia
    public static void close(Statement smtm)throws SQLException{
        smtm.close();
    }
    //Guarda la instruccion 
    public static void close(PreparedStatement smtm)throws SQLException{
        smtm.close();
    }
    //Cerrar la conexion 
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
    
}
