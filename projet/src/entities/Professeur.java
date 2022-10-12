package entities;

import core.Roles;

public class Professeur extends User{
    private String grade;
    
    public Professeur(int id, String nomComplet, String login, String password, String grade) {
        super(id, nomComplet, login, password);
        this.grade = grade;
        role=Roles.PROFESSEUR;
    }

    public Professeur(String nomComplet, String login, String password,String grade) {
        super(nomComplet, login, password);
        this.grade = grade;
        role=Roles.PROFESSEUR;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()+ "grade=" + grade + "]";
    }

   

 
}
