package lab_5.controller;

import lab_5.model.dao.ComputerDAO;
import lab_5.model.dao.GeneralDAO;
import lab_5.model.entity.Computer;

import java.util.List;

public class ComputerController implements GeneralDAO<Computer> {


    ComputerDAO computerDAO = new ComputerDAO();

    @Override
    public List<Computer> findAll() {
        return computerDAO.findAll();
    }

    @Override
    public Computer findOne(Integer id) {
        return computerDAO.findOne(id);
    }

    @Override
    public void create(Computer computer) {
        computerDAO.create(computer);
    }

    @Override
    public void update(Integer id, Computer computer) {
        computerDAO.update(id, computer);
    }

    @Override
    public void delete(Integer id) {
        computerDAO.delete(id);
    }
}
