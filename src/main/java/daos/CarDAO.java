package daos;

import java.util.List;

import models.Car;

public class CarDAO implements Crud {
    Car car = new Car();

    @Override
    public Car findById(Integer id) {

        if (car.getId() == id) {
            return car;
        }
        return null;
    
    }

    @Override
    public List<Car> findAll() {
    
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Car update(Car dto) {
     
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Car create(Car dto) {
   
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(Integer id) {
      
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
