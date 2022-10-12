package repositories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Mysql;
import core.Roles;
import entities.Professeur;
import entities.User;
public class UserRepository extends Mysql implements IUserRepository{
    private static final String SQL_INSERT="insert into users(nom_complet,login,password,grade,role) values(?,?,?,?,?)";
    private static final String SQL_SELECT_ALL="select * from users where role like ?";
    private static final String SQL_SELECT_BY_ID="select * from users where id=? and role like ? ";

    List <User>listeUsers=new ArrayList<>();
    @Override
    public User ajouterProfesseur(User user) {

        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getNomComplet());
            ps.setString(2,user.getLogin());
            ps.setString(3,user.getPassword());
            ps.setString(4,((Professeur) user).getGrade());
            ps.setString(5,(user.getRole().name()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return user;
    }

    @Override
    public List<User> listerProfesseur() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ALL);
            ps.setString(1,"PROFESSEUR");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new Professeur(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("grade"));
                    listeUsers.add(user);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listeUsers;
    }

    @Override
    public User filterUnProfesseurParId(int id) {
        Professeur user=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ps.setString(2,Roles.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 user=new Professeur(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("grade"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return user;
    }

   
}
