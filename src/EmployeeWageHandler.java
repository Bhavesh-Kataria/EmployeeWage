import java.util.Scanner;

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
    static int wageCalculator(int presentHours){
        final int hours = 8;
        final int partTimeHours = 4;
        final int wagePerHour = 20;
        if(presentHours <= partTimeHours){
            return wagePerHour * partTimeHours;
        }else{
            return  wagePerHour * hours;
        }
    }
}


public class EmployeeWageHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wage = 0;
        boolean setAttendance = EmpOpsHandler.empAttendance();
        if(setAttendance){
            System.out.println("Enter your log in time");
            int logInTime = sc.nextInt();
            System.out.println("Enter your log out time");
            int logOutTime = sc.nextInt();
            int presentHours = logOutTime - logInTime;
            wage = EmpOpsHandler.wageCalculator(presentHours);
        }
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
