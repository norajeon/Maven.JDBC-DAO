package daos;

import java.util.List;

import models.Car;

public interface Crud {
    public Car findById(Integer id);
    public List<Car> findAll();
    public Car update(Car dto);
    public Car create(Car dto);
    public void delete(Integer id);
    
}   
