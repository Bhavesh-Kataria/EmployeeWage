import java.util.Scanner;

class Employee{
    Company c;
    String name;
    int id;
    Employee(String name,int id,Company c){
        this.name = name;
        this.id = id;
        this.c = c;
    }
}

class Company{
    String name;
    int minWorkingDays;
    int minWorkingHours;
    int monthlyWage;

    public Company(String name, int minWorkingDays, int minWorkingHours, int monthlyWage) {
        this.name = name;
        this.minWorkingDays = minWorkingDays;
        this.minWorkingHours = minWorkingHours;
        this.monthlyWage = monthlyWage;
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
    static void calculateCompanyExpense(Employee[] emps){
         int[] companyExpense = new int[3];
         for (Employee e : emps){
             if(e!=null){
                 switch (e.c.name) {
                     case "QK" -> companyExpense[0] += e.c.monthlyWage;
                     case "Wipro" -> companyExpense[1] += e.c.monthlyWage;
                     case "Reliance" -> companyExpense[2] += e.c.monthlyWage;
                 }
             }
         }
        System.out.println("Monthly expense for Qk is Rs. "+companyExpense[0]);
        System.out.println("Monthly expense for Wipro is Rs. "+companyExpense[1]);
        System.out.println("Monthly expense for Reliance is Rs. "+companyExpense[2]);
    }
}


public class EmployeeWageHandler {
    public static void main(String[] args) {
        Company c1= new Company("QK",14,100,3200);
        Company c2= new Company("Wipro",12,98,4000);
        Company c3= new Company("Reliance",18,150,2000);
        Employee emp1 = new Employee("Bhavesh", 1,c1);
        Employee emp2 = new Employee("Sahil", 2,c1);
        Employee emp3 = new Employee("Rushikesh", 3,c3);
        Employee emp4 = new Employee("Rehan", 4,c2);
        Employee emp5 = new Employee("Dhruv", 5,c2);
        Employee[] emps  = new Employee[10];
        emps[0] = emp1;
        emps[1] = emp2;
        emps[2] = emp3;
        emps[3] = emp4;
        emps[4] = emp5;
        EmpOpsHandler.calculateCompanyExpense(emps);
    }
}
