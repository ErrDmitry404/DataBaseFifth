package lab_5.controller;

import lab_5.model.dao.GeneralDAO;
import lab_5.model.dao.ServerDAO;
import lab_5.model.entity.Server;

import java.util.List;

public class ServerController implements GeneralDAO<Server> {


    ServerDAO serverDAO = new ServerDAO();

    @Override
    public List<Server> findAll() {
        return serverDAO.findAll();
    }

    @Override
    public Server findOne(Integer id) {
        return serverDAO.findOne(id);
    }

    @Override
    public void create(Server server) {
        serverDAO.create(server);
    }

    @Override
    public void update(Integer id, Server server) {
        serverDAO.update(id, server);
    }

    @Override
    public void delete(Integer id) {
        serverDAO.delete(id);
    }
}
