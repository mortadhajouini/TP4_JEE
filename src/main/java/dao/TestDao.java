package dao;
import java.util.List;
import metier.entities.Smartphone;
public class TestDao {
public static void main(String[] args) {
SmartphoneDaoImpl pdao= new SmartphoneDaoImpl();
Smartphone prod= pdao.save(new Smartphone("iphone 8 plus",2800));
System.out.println(prod);
List<Smartphone> prods =pdao.SmartphonesParMC("HP");
for (Smartphone p : prods)
System.out.println(p);
}
}
