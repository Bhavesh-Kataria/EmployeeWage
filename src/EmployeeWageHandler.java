import java.util.Scanner;

class Employee{
    String name;
    int id;
    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [ "+"Name : "+this.name+", Id : "+this.id+"]";
    }
}

class EmpOpsHandler{
    static final int hours = 8;
    static final int partTimeHours = 4;
    static final int wagePerHour = 20;
    static boolean empAttendance(){
        int isPresent = (int)Math.round(Math.random());
        return isPresent == 1 ;
    }
    static int calculateWorkingHours(int logIn, int logOut){
        return logOut - logIn;
    }
    static int wageCalculator(int presentHours){
        switch (presentHours){
            case 1 :
            case 2 :
            case 3 :
            case 4 : return wagePerHour * partTimeHours;
            default: return  wagePerHour * hours;
        }
    }
    static int[] monthlyWageCalculator(){
        Scanner sc = new Scanner(System.in);
        int wage = 0;
        int fullDays = 0;
        int halfDays = 0;
        int monthlyWage = 0;
        int logInTime = 0;
        int logOutTime = 0;
        int presentHours = 0;
        boolean setAttendance;
        int[] empData = new int[3];
        for (int i =1 ; i<=20 ; i++){
            setAttendance = empAttendance();
            if(setAttendance){
                System.out.println("Enter your log in time");
                logInTime = sc.nextInt();
                System.out.println("Enter your log out time");
                logOutTime = sc.nextInt();
                presentHours = calculateWorkingHours(logInTime,logOutTime);
                if(presentHours<=4){
                    halfDays ++;
                }else{
                    fullDays ++;
                }
                wage = wageCalculator(presentHours);
                monthlyWage += wage;
            }
            else{
                System.out.println("Employee is absent on day "+i);
            }
        }
        empData[0] = halfDays;
        empData[1] = fullDays;
        empData[2] = monthlyWage;
        return  empData;
    }
}


public class EmployeeWageHandler {
    public static void main(String[] args) {
        Employee emp = new Employee("Bhavesh", 1);
        int[] empData = EmpOpsHandler.monthlyWageCalculator();
        System.out.println("Employee "+emp.name+" was present for a total of "+empData[1]+" fulldays and "+empData[0]+" halfdays based on that his total salary for month is "+empData[2]+" Rs.");
    }
}
