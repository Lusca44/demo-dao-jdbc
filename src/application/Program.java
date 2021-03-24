package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1 : seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);


        System.out.println("\n=== TESTE 2 : seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3 : seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 4 : seller insert ========= FLAG");
        if(0 > 10) {
            Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.00, dep);
            sellerDao.insert(newSeller);

            System.out.println("Inserted! new seller id = " + newSeller.getId());
        }

        System.out.println("\n=== TESTE 5 : seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha");
        sellerDao.update(seller);
        System.out.println("UPDATED!");

        System.out.println("\n=== TESTE 6 : seller delete ========= FLAG");
        if(0 > 10) {
            System.out.println("Enter id for delete teste: ");
            int id = sc.nextInt();
            sellerDao.deleteById(id);

            System.out.println("Seller id  = " + id + " deleted!");
        }

        sc.close();
    }
}
