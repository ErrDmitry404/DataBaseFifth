package lab_5.controller;

import lab_5.model.dao.GeneralDAO;
import lab_5.model.dao.IrPhonesDAO;
import lab_5.model.entity.IrPhones;

import java.util.List;

public class IrPhonesController implements GeneralDAO<IrPhones> {


    IrPhonesDAO irPhonesDAO = new IrPhonesDAO();

    @Override
    public List<IrPhones> findAll() {
        return irPhonesDAO.findAll();
    }

    @Override
    public IrPhones findOne(Integer id) {
        return irPhonesDAO.findOne(id);
    }

    @Override
    public void create(IrPhones irPhones) {
        irPhonesDAO.create(irPhones);
    }

    @Override
    public void update(Integer id, IrPhones irPhones) {
        irPhonesDAO.update(id, irPhones);
    }

    @Override
    public void delete(Integer id) {
        irPhonesDAO.delete(id);
    }
}
