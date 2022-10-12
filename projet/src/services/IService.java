package services;
import java.util.List;

import entities.Classe;
import entities.User;
public interface IService {
    public Classe insertClasse(Classe classe);
    public List<Classe> selectAllClasses();
    public User insertUser(User user);
    public List<User> selectAllUsers();
    public User selectUserByID(int id);
    public Classe selectClasseByID(int id);
    
}
