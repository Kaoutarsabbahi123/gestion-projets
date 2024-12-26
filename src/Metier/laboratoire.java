package Metier;

public class laboratoire {
    private String nom;
    private int num;
    private String email;
    private String tel;
    private String adress;

    public laboratoire(String nom, int num, String email, String tel, String adress) {
        this.nom = nom;
        this.num = num;
        this.email = email;
        this.tel = tel;
        this.adress = adress;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public static String[] getAttribut(){
        String[] res={"Num_labo","Nom_labo","Email_labo","Num_telel","Adresse_labo"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getNum();
            case 1 : return this.getNom();
            case 2 : return this.getEmail();
            case 3 : return this.getTel();
            case 4 : return this.getAdress();

        }
        return null;
    }
}
