package iu.oop.labs.lab05;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProjectPrinter implements Runnable {
    private Project project;

    public ProjectPrinter(Project project) {
        this.project = project;
    }

    @Override
    public void run() {
        ArrayList<Employee> emp = project.getListOfEmployee();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Employee obj : emp) {
            System.out.printf(
                "[Project ID: %s - Project Duration: %s to %s] [Name: %s - Salary Per Hour: %s]\n",
                project.getProjectId(), simpleDateFormat.format(project.getStartDate()),
                simpleDateFormat.format(project.getEndDate()), obj.getEmployeeName(),
                obj.getSalaryPerHour());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread is interrupted");
            }
        }
    }
}

