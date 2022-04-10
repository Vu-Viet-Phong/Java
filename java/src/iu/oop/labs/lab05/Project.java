package iu.oop.labs.lab05;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Project {
    private String projectId;
    private Date startDate;
    private Date endDate;
    ArrayList<Employee> listOfEmployee = new ArrayList<>();

    public Project(String projectId, Date startDate, Date endDate, ArrayList<Employee> listOfEmployee) {
        this.projectId = projectId;
        this.endDate = endDate;
        this.startDate = startDate;
        this.listOfEmployee = listOfEmployee;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public long estimateBudget() {
        int estimateBudget = 0;
        
        for (Employee a: listOfEmployee) {
           estimateBudget += a.getSalaryPerHour() * 8 * 5;
        }

        long milliSecondsElapsed = endDate.getTime() - startDate.getTime();
        long diff = TimeUnit.MINUTES.convert(milliSecondsElapsed, TimeUnit.MILLISECONDS);
        diff = diff / (1440 * 7);

        return estimateBudget * diff;
    }

    @Override
    public String toString() {
        return "Project{listOfEmployee = " + listOfEmployee + "}";
    }
}
    
