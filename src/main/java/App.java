import daos.CarDAO;

public class App {
    public static void main (String[] args) {
        CarDAO carDAO = new CarDAO();
        carDAO.findById(3);

    }
    
}
