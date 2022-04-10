package iu.oop.labs.lab05;

public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String employeeName;
    private int salaryPerHour;
    private int noOfLeavingDay;
    private int noOfTravelDay;

    public Employee(String employeeId, String employeeName, int salaryPerHour, int noOfLeavingDay, int noOfTravelDay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
        this.noOfLeavingDay = noOfLeavingDay;
        this.noOfTravelDay = noOfTravelDay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getNoOfLeavingDay() {
        return noOfLeavingDay;
    }

    public void setNoOfLeavingDay(int noOfLeavingDay) {
        this.noOfLeavingDay = noOfLeavingDay;
    }

    public int getNoOfTravelDay() {
        return noOfTravelDay;
    }

    public void setNoOfTravelDay(int noOfTravelDay) {
        this.noOfTravelDay = noOfTravelDay;
    }
    
    public int calculateWeeklySalary() {
        return salaryPerHour * 8 * (5 - noOfLeavingDay + noOfLeavingDay / 2);
    }

    @Override
    public int compareTo(Employee obj) {
        if (this.noOfTravelDay == obj.noOfTravelDay) {
            if (this.noOfLeavingDay == obj.noOfLeavingDay) return 0;
            else return (this.noOfLeavingDay < obj.noOfLeavingDay) ? 1 : -1;
        }

        return (this.noOfTravelDay > obj.noOfTravelDay) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "[Name: " + employeeName + " - Salary Per Hour: " + salaryPerHour + " - Weekly Salary: " + calculateWeeklySalary() + "]";
    }
}

