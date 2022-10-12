package views;
import java.util.Scanner;

import entities.Professeur;
import entities.User;
import services.IService;

public class UserView {

    Scanner clavier=new Scanner(System.in);
    int choix;
    String nom,login,password,grade;
    IService service;

    public UserView(IService service) {
        this.service = service;
    }

    public void affiche(){
        do {
            System.out.println("1-- ajouter un user");
            System.out.println("2--lister les les professeurs");
            System.out.println("3--filtrer un professeur par id");
            System.out.println("4--affecter une classe a un professeur");
            System.out.println("6--quitter");
            System.out.println("faite votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();

            switch (choix) {
                case 1:
                System.out.println("donner nom ");
                nom=clavier.nextLine();
                System.out.println("donner login ");
                login=clavier.nextLine();
                System.out.println("donner password");
                password=clavier.nextLine();
                System.out.println("donner grade ");
                grade=clavier.nextLine();
                User user=new Professeur(nom, login, password, grade);
                User userAvecId=service.insertUser(user);
                System.out.println(userAvecId);
                    
                break;
                case 2:
                    service.selectAllUsers().forEach(System.out::println);
                break;
                case 3:
                    System.out.println("donner un id");
                    int id=clavier.nextInt();
                     user=service.selectUserByID(id);
                     System.out.println(user);
                    
                break;
            
                default:
                    break;
            }
            
        } while (choix!=6);
    }
    
}
