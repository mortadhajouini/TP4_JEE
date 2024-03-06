package web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.ISmartphoneDao;
import dao.SmartphoneDaoImpl;
import metier.entities.Smartphone;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
ISmartphoneDao metier;
@Override
public void init() throws ServletException {
metier = new SmartphoneDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response) 
		 throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
		request.getRequestDispatcher("Smartphones.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
		String motCle=request.getParameter("motCle");
		SmartphoneModele model= new SmartphoneModele();
		model.setMotCle(motCle);
		List<Smartphone> prods = metier.SmartphonesParMC(motCle);
		model.setSmartphones(prods);
		request.setAttribute("model", model);
		request.getRequestDispatcher("Smartphones.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do") )
		{
		request.getRequestDispatcher("saisieSmartphone.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") && 
		request.getMethod().equals("POST"))
		{
		 String nom=request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		Smartphone p = metier.save(new Smartphone(nom,prix));
		request.setAttribute("Smartphone", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deleteSmartphone(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
		Long id= Long.parseLong(request.getParameter("id"));
		 Smartphone p = metier.getSmartphone(id);
		 request.setAttribute("Smartphone", p);
		request.getRequestDispatcher("editerSmartphone.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
		Long id = Long.parseLong(request.getParameter("id"));
		String nom=request.getParameter("nom");
		double prix = 
		Double.parseDouble(request.getParameter("prix"));
		Smartphone p = new Smartphone();
		p.setIdSmartphone(id);
		p.setNomSmartphone(nom);
		p.setPrix(prix);
		metier.updateSmartphone(p);
		request.setAttribute("Smartphone", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{
		response.sendError(Response.SC_NOT_FOUND);
		}
		}

@Override
protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws 
ServletException, IOException {
doGet(request,response);
}
}