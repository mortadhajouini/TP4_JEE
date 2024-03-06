 package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Smartphone;
public class SmartphoneModele {
private String motCle;
List<Smartphone> Smartphones = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Smartphone> getSmartphones() {
return Smartphones;
}
public void setSmartphones(List<Smartphone> Smartphones) {
this.Smartphones = Smartphones;
}
}