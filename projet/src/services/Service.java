package services;

import java.util.List;

import entities.Classe;
import entities.User;
import repositories.IClasseRepository;
import repositories.IUserRepository;
public class Service implements IService{

    IClasseRepository classeRepository;
    IUserRepository userRepository;
   
    public Service(IClasseRepository classeRepository, IUserRepository userRepository) {
        this.classeRepository = classeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Classe insertClasse(Classe classe) {
        return classeRepository.ajouterUneClasse(classe);
    }

    @Override
    public List<Classe> selectAllClasses() {
        return classeRepository.listerClasses();
    }

    @Override
    public User insertUser(User user) {
        return userRepository.ajouterProfesseur(user);
    }

    @Override
    public List<User> selectAllUsers() {
        
        return userRepository.listerProfesseur();
    }

    @Override
    public User selectUserByID(int id) {
        return userRepository.filterUnProfesseurParId(id);
    }

    @Override
    public Classe selectClasseByID(int id) {
        return classeRepository.filtrerUneClasseParId(id);
    }
    
}
