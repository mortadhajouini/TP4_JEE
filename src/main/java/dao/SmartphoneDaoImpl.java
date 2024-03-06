package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Smartphone;
public class SmartphoneDaoImpl implements ISmartphoneDao {
@Override
public Smartphone save(Smartphone p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("INSERT INTO SmartphoneS(NOM_Smartphone,PRIX) VALUES(?,?)");
ps.setString(1, p.getNomSmartphone());
ps.setDouble(2, p.getPrix());
ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement
("SELECT MAX(ID_Smartphone) as MAX_ID FROM SmartphoneS");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setIdSmartphone(rs.getLong("MAX_ID"));
}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public List<Smartphone> SmartphonesParMC(String mc) {
 List<Smartphone> prods= new ArrayList<Smartphone>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from SmartphoneS where NOM_Smartphone LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Smartphone p = new Smartphone();
p.setIdSmartphone(rs.getLong("ID_Smartphone"));
p.setNomSmartphone(rs.getString("NOM_Smartphone"));
p.setPrix(rs.getDouble("PRIX"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public Smartphone getSmartphone(Long id) {
	 
	 Connection conn=SingletonConnection.getConnection();
	 Smartphone p = new Smartphone();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from SmartphoneS where ID_Smartphone = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	p.setIdSmartphone(rs.getLong("ID_Smartphone"));
	p.setNomSmartphone(rs.getString("NOM_Smartphone"));
	p.setPrix(rs.getDouble("PRIX"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}

@Override
public Smartphone updateSmartphone(Smartphone p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("UPDATE SmartphoneS SET NOM_Smartphone=?,PRIX=? WHERE ID_Smartphone=?");
ps.setString(1, p.getNomSmartphone());
ps.setDouble(2, p.getPrix());
ps.setLong(3, p.getIdSmartphone());
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}

@Override
public void deleteSmartphone(Long id) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("DELETE FROM SmartphoneS WHERE ID_Smartphone = ?");
ps.setLong(1, id);
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
}

}
