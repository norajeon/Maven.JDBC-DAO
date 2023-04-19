package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car");
            ResultSet rs = ps.executeQuery();


            List<Car> cars = new ArrayList<>();
    
            while(rs.next())
            {
                Car carry = extractCarFromResultSet(rs);
                cars.add(carry);
            }
    
            return cars;
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return null;
    }

    @Override
    public Car update(Car dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET name=?, pass=?, age=? WHERE id=?");
            ps.setString(1, car.getMake());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getId());
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

    @Override
    public Car create(Car dto) {
   
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM car WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
