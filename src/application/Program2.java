package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        /*System.out.println("=== TESTE 1 : department insert ===");

        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);

        System.out.println("New department inserted!");*/

        System.out.println("\n=== TESTE 2 : department findById ===");
        Department department = departmentDao.findById(6);
        System.out.println(department);

        System.out.println("\n=== TESTE 3 : department update ===");
        department = departmentDao.findById(6);
        department.setName("Clothes");
        departmentDao.update(department);
        System.out.println("UPDATED!");

        sc.close();
    }
}
