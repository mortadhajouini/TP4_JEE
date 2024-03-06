package dao;
import java.util.List;
import metier.entities.Smartphone;
public interface ISmartphoneDao {
public Smartphone save(Smartphone p);
public List<Smartphone> SmartphonesParMC(String mc);
public Smartphone getSmartphone(Long id);
public Smartphone updateSmartphone(Smartphone p);
public void deleteSmartphone(Long id);
}
