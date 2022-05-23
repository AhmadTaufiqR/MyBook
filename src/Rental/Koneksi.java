package Rental;
import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    private static Connection cn;
    
    public static Connection getkoneksi(){
        if(cn == null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn=DriverManager.getConnection("jdbc:mysql://localhost/tbl_perpus","root","");
                System.out.println("BERHASIL");
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        }
        return cn;
    }

}
