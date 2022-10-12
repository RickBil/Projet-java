import java.util.Scanner;

import entities.Classe;
import repositories.ClasseRepository;
import repositories.IClasseRepository;
import repositories.IUserRepository;
import repositories.UserRepository;
import services.IService;
import services.Service;
import views.ClasseView;
import views.UserView;


public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner clavier=new Scanner(System.in);
       IClasseRepository classeRepository=new ClasseRepository();
       IUserRepository userRepository=new UserRepository();
       IService service=new Service(classeRepository,userRepository);
       ClasseView classeview=new ClasseView(service);
       UserView userview=new UserView(service);
       int choix;
      
       do {
        System.out.println("1--page user");
        System.out.println("2--page classe");
        System.out.println("3--quitter");
        System.out.println("donner le choix");
        choix=clavier.nextInt();
        clavier.nextLine();
        switch (choix) {
            case 1:
                userview.affiche();
                break;
            case 2:
                classeview.affiche();
                break;
            default:
                break;
        }
        
       } while (choix!=3);
        
    }
}
