package jdbc;

import com.konyuh.connectionpool.HikariCPDataSource;
import org.junit.Test;
//import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

    @Test
    public void TestConnection(){
        try(Connection connection =  HikariCPDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID, login  FROM \"user\"");){
            while (resultSet.next()){
                int i = resultSet.getInt("id");
                String string = resultSet.getString(2);
                System.out.println(resultSet.getRow() + ". " + i + " " + string);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
