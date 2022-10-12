package repositories;

import java.util.List;

import entities.User;

public interface IUserRepository {
    public User ajouterProfesseur(User user);
    public List<User> listerProfesseur();
    public User filterUnProfesseurParId(int id);
    
}
