package metier.entities;
import java.io.Serializable;
public class Smartphone implements Serializable{
private Long idSmartphone;
private String nomSmartphone;
private double prix;
public Smartphone() {
super();
}
public Smartphone(String nomSmartphone, double prix) {
super();
this.nomSmartphone = nomSmartphone;
this.prix = prix;
}
public Long getIdSmartphone() {
return idSmartphone;
}
public void setIdSmartphone(Long idSmartphone) {
this.idSmartphone = idSmartphone;
}
public String getNomSmartphone() {
return nomSmartphone;
}
public void setNomSmartphone(String nomSmartphone) {
this.nomSmartphone = nomSmartphone;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
@Override
public String toString() {
return "Smartphone [idSmartphone=" + idSmartphone + ", nomSmartphone=" + 
nomSmartphone + ", prix=" + prix + "]";
}
}
