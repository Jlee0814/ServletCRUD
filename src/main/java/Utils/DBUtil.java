package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String jdbcURL="jdbc:mysql://localhost:3306/event_list";
    private static String jdbcUsername="root";
    private static String jdbcPassword="jionghong";
    private static Connection conn=null;
        static{
               try {
                       //1.load driver
                       Class.forName("com.mysql.jdbc.Driver");
                       //2.connect
                   conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
               } catch (ClassNotFoundException e) {
                       e.printStackTrace();
                   } catch (SQLException e) {
                        e.printStackTrace();
                   }
      }

         public static Connection getConnection(){
              return conn;
         }


}
