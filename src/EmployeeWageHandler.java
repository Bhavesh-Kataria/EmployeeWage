
class Employee{
    String name;
    int id;
    boolean isPresentToday;
    int wageDaily;
    Employee(String name,int id,boolean isPresentToday,int wageDaily){
        this.name = name;
        this.id = id;
        this.isPresentToday = isPresentToday;
        this.wageDaily = wageDaily;
    }

    @Override
    public String toString() {
        return "Employee [ "+"Name : "+this.name+", Id : "+this.id+", isPresent : "+this.isPresentToday+", Wage : "+this.wageDaily +"]";
    }
}

class EmpOpsHandler{
    static boolean empAttendance(){
        int isPresent = (int)Math.round(Math.random());
        return isPresent == 1 ;
    }
    static int wageCalculator(){
        final int hours = 8;
        final int wagePerHour = 20;
        return  hours * wagePerHour;
    }
}


public class EmployeeWageHandler {
    public static void main(String[] args) {
        boolean setAttendance = EmpOpsHandler.empAttendance();
        int wage = EmpOpsHandler.wageCalculator();
        Employee emp = new Employee("Bhavesh", 1, setAttendance,wage);
        if (emp.isPresentToday) {
            System.out.println("Employee "+emp.name+" is present today");
            System.out.println("Employees today wage is "+emp.wageDaily+" Rs.");
        }else{
            System.out.println("Employee "+emp.name+" is absent today");
            emp.wageDaily = 0;
            System.out.println("Employees today wage is "+emp.wageDaily+" Rs.");
        }
    }
}
