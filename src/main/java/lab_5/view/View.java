package lab_5.view;

import lab_5.controller.*;
import lab_5.model.entity.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {


    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final WorkerController workerController = new WorkerController();
    private final ComputerController computerController = new ComputerController();
    private final IrPhonesController irphonesController = new IrPhonesController();
    private final ITCompanyController itcompanyController = new ITCompanyController();
    private final MonitorController monitorController = new MonitorController();
    private final ServerController serverController = new ServerController();


    public View() {

        menu.put("11", this::getAllWorkers);
        menu.put("12", this::getWorkerById);
        menu.put("13", this::createWorker);
        menu.put("14", this::updateWorker);
        menu.put("15", this::deleteWorker);

        menu.put("21", this::getAllComputers);
        menu.put("22", this::getComputersById);
        menu.put("23", this::createComputer);
        menu.put("24", this::updateComputer);
        menu.put("25", this::deleteComputer);

        menu.put("31", this::getAllIrPhones);
        menu.put("32", this::getIrPhonesById);
        menu.put("33", this::createIrPhones);
        menu.put("34", this::updateIrPhones);
        menu.put("35", this::deleteIrPhones);

        menu.put("41", this::getAllITCompany);
        menu.put("42", this::getITCompanyById);
        menu.put("43", this::createITCompany);
        menu.put("45", this::deleteITCompany);

        menu.put("51", this::getAllMonitors);
        menu.put("52", this::getMonitorById);
        menu.put("53", this::createMonitor);
        menu.put("54", this::updateMonitor);
        menu.put("55", this::deleteMonitor);

        menu.put("61", this::getAllServers);
        menu.put("62", this::getServerById);
        menu.put("63", this::createServer);
        menu.put("64", this::updateServer);
        menu.put("65", this::deleteServer);
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter combination:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //========================== USER =================================

    private void getAllWorkers() {
        System.out.println("\nGetting workers...");
        System.out.println(workerController.findAll() + "\n");
    }

    private void getWorkerById() {
        System.out.println("\nEnter worker ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(workerController.findOne(id) + "\n");
    }

    private Worker getWorkerInputs() {
        System.out.println("\nEnter fullName: ");
        String fullName = SCANNER.next();
        System.out.println("Enter amount: ");
        Integer amount = SCANNER.nextInt();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        return new Worker(fullName, amount, age);
    }

    private void createWorker() {
        System.out.println("\nCreating worker...");
        Worker worker = getWorkerInputs();
        workerController.create(worker);
        System.out.println("Worker has been created!\n");
    }

    private void updateWorker() {
        System.out.println("\nUpdating worker... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Worker worker = getWorkerInputs()
                .setId(id);

        workerController.update(worker.getId(), worker);
        System.out.println("Worker with Id=" + id + " has been updated\n");
    }

    private void deleteWorker() {
        System.out.println("\nDeleting worker... Enter ID: ");
        int id = SCANNER.nextInt();

        workerController.delete(id);
        System.out.println("Worker with ID=" + id + " has been deleted\n");
    }


//========================== COMPUTER =================================

    private void getAllComputers() {
        System.out.println("\nGetting computers...");
        System.out.println(computerController.findAll() + "\n");
    }

    private void getComputersById() {
        System.out.println("\nEnter computer ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(computerController.findOne(id) + "\n");
    }

    private Computer getComputerInputs() {
        System.out.println("\nEnter name: ");
        Integer amount = SCANNER.nextInt();
        System.out.println("Enter surname: ");
        String manufacturer = SCANNER.next();
        System.out.println("Enter age: ");
        Integer monitorsId = SCANNER.nextInt();
        return new Computer(amount, manufacturer, monitorsId);
    }

    private void createComputer() {
        System.out.println("\nCreating artist...");
        Computer computer = getComputerInputs();
        computerController.create(computer);
        System.out.println("Computer has been created!\n");
    }

    private void updateComputer() {
        System.out.println("\nUpdating computer... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Computer computer = getComputerInputs()
                .setId(id);

        computerController.update(computer.getId(), computer);
        System.out.println("Computer with Id=" + id + " has been updated\n");
    }

    private void deleteComputer() {
        System.out.println("\nDeleting computer... Enter ID: ");
        int id = SCANNER.nextInt();

        computerController.delete(id);
        System.out.println("Computer with ID=" + id + " has been deleted\n");
    }

    //========================== IRPHONES =================================

    private void getAllIrPhones() {
        System.out.println("\nGetting irphones...");
        System.out.println(irphonesController.findAll() + "\n");
    }

    private void getIrPhonesById() {
        System.out.println("\nEnter irphone ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(irphonesController.findOne(id) + "\n");
    }

    public IrPhones getIrPhonesInputs() {
        System.out.println("\nEnter type: ");
        String type = SCANNER.next();
        System.out.println("\nEnter model: ");
        String model = SCANNER.next();
        System.out.println("\nEnter phone_id: ");
        Integer phoneId = SCANNER.nextInt();
        return new IrPhones(type, model, phoneId);
    }

    private void createIrPhones() {
        System.out.println("\nCreating IrPhone...");
        IrPhones irphones = getIrPhonesInputs();
        irphonesController.create(irphones);
        System.out.println("IrPhone has been created!\n");
    }

    private void updateIrPhones() {
        System.out.println("\nUpdating irphone... Enter ID: ");
        Integer id = SCANNER.nextInt();
        IrPhones irphones = getIrPhonesInputs()
                .setId(id);

        irphonesController.update(irphones.getId(), irphones);
        System.out.println("IrPhone with Id=" + id + " has been updated\n");
    }

    private void deleteIrPhones() {
        System.out.println("\nDeleting IrPhone... Enter ID: ");
        int id = SCANNER.nextInt();

        irphonesController.delete(id);
        System.out.println("IrPhone with ID=" + id + " has been deleted\n");
    }

//    //========================== ITCOMPANY =================================


    private void getAllITCompany() {
        System.out.println("\nGetting ITCompanies...");
        System.out.println(itcompanyController.findAll() + "\n");
    }

    private void getITCompanyById() {
        System.out.println("\nEnter monitor ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(itcompanyController.findOne(id) + "\n");
    }

    public ITCompany getITCompanyInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter typeOfDevices: ");
        String typeOfDevices = SCANNER.next();
        System.out.println("\nEnter companyNumber: ");
        Integer companyNumber = SCANNER.nextInt();
        System.out.println("\nEnter workers: ");
        Integer workers = SCANNER.nextInt();
        return new ITCompany(name, typeOfDevices, companyNumber, workers);
    }

    private void createITCompany() {
        System.out.println("\nCreating monitor...");
        ITCompany itcompany = getITCompanyInputs();
        itcompanyController.create(itcompany);
        System.out.println("ITCompany has been created!\n");
    }

//    private void updateITCompany() {
//        System.out.println("\nUpdating ITCompany... Enter ID: ");
//        Integer id = SCANNER.nextInt();
//        Integer itcompany = getITCompanyInputs()
//                .getCompanyConfiguration();
//
//        itcompanyController.update(itcompany.getCompanyConfiguration(), itcompany);
//        System.out.println("ITCompany with Id=" + id + " has been updated\n");
//    }

    private void deleteITCompany() {
        System.out.println("\nDeleting ITCompany... Enter ID: ");
        int id = SCANNER.nextInt();

        itcompanyController.delete(id);
        System.out.println("ITCompany with ID=" + id + " has been deleted\n");
    }

//    //========================== MONITOR =================================

    private void getAllMonitors() {
        System.out.println("\nGetting monitors...");
        System.out.println(monitorController.findAll() + "\n");
    }

    private void getMonitorById() {
        System.out.println("\nEnter server ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(monitorController.findOne(id) + "\n");
    }


    private Monitor getMonitorInputs() {
        System.out.println("\nEnter monitorsResolution: ");
        String monitorsResolution = SCANNER.next();
        System.out.println("\nEnter model: ");
        String model = SCANNER.next();
        return new Monitor(monitorsResolution, model);
    }

    private void createMonitor() {
        System.out.println("\nCreating monitor...");
        Monitor monitor = getMonitorInputs();
        monitorController.create(monitor);
        System.out.println("Monitor has been created!\n");
    }

    private void updateMonitor() {
        System.out.println("\nUpdating monitor... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Monitor monitor = getMonitorInputs()
                .setId(id);

        monitorController.update(monitor.getId(), monitor);
        System.out.println("Monitor with Id=" + id + " has been updated\n");
    }

    private void deleteMonitor() {
        System.out.println("\nDeleting monitor... Enter ID: ");
        int id = SCANNER.nextInt();

        monitorController.delete(id);
        System.out.println("Monitor with ID=" + id + " has been deleted\n");
    }

//    //========================== SERVER =================================


    private void getAllServers() {
        System.out.println("\nGetting servers...");
        System.out.println(serverController.findAll() + "\n");
    }

    private void getServerById() {
        System.out.println("\nEnter server ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(serverController.findOne(id) + "\n");
    }

    public Server getServerInputs() {
        System.out.println("\nEnter server_id: ");
        Integer serverId = SCANNER.nextInt();
        Server server = serverController.findOne(serverId);
        return new Server(server);
    }

    private void createServer() {
        System.out.println("\nCreating server...");
        Server server = getServerInputs();
        serverController.create(server);
        System.out.println("Server has been created!\n");
    }

    private void updateServer() {
        System.out.println("\nUpdating server... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Server server = getServerInputs()
                .setId(id);

        serverController.update(server.getId(), server);
        System.out.println("Server with Id=" + id + " has been updated\n");
    }

    private void deleteServer() {
        System.out.println("\nDeleting server... Enter ID: ");
        int id = SCANNER.nextInt();

        serverController.delete(id);
        System.out.println("Server with ID=" + id + " has been deleted\n");
    }
}
