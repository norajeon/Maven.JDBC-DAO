package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import models.Car;

public class CarDAO implements Crud {

    @Override
    public Car findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
    
            if(rs.next())
            {
        return extractCarFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    return null;
    
    }

    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("make") );
        car.setModel( rs.getString("model") );
        car.setColor( rs.getString("color") );
        car.setVin(rs.getString("vin"));
        car.setYear(rs.getInt("year"));
    
        return car;
    }

    @Override
    public List<Car> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
    
            Set users = new HashSet();
    
            while(rs.next())
            {
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }
    
            return users;
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return null;
    }

    @Override
    public Car update(Car dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET name=?, pass=?, age=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getId());
            int i = ps.executeUpdate();
    
          if(i == 1) {
        return true;
          }
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return false;
    }

    @Override
    public Car create(Car dto) {
   
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);
    
          if(i == 1) {
        return true;
          }
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return false;
    }
    
}
