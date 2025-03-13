
class Employee{
    String name;
    int id;
    boolean isPresentToday;
    Employee(String name,int id,boolean isPresentToday){
        this.name = name;
        this.id = id;
        this.isPresentToday = isPresentToday;
    }

    @Override
    public String toString() {
        return "Employee [ "+"Name : "+this.name+", Id : "+this.id+", isPresent : "+this.isPresentToday+"]";
    }
}

class EmpOpsHandler{
    static boolean empAttendance(){
        int isPresent = (int)Math.round(Math.random());
        return isPresent == 1 ;
    }
}


public class EmployeeWageHandler {
    public static void main(String[] args) {
        boolean setAttendance = EmpOpsHandler.empAttendance();
        Employee emp = new Employee("Bhavesh", 1, setAttendance);
        if (emp.isPresentToday) {
            System.out.println("Employee "+emp.name+" is present today");
        }else{
            System.out.println("Employee "+emp.name+" is absent today");
        }
    }
}
