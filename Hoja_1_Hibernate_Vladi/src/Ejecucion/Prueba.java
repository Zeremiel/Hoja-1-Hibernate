package Ejecucion;

import java.time.LocalTime;
import java.util.Date;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import BBDD_Modelo_.Seguro;
import BBDD_Modelo_.Seguro.TipoSeguro;
import Utilidades_Imprescindible_.Utilidades;
public class Prueba 
{
	
	public static void main(String[] args)
	{
		Seguro estafa = new Seguro();
		estafa.setNif("94832");
		estafa.setNombre("Milana");
		estafa.setApe1("bonita");
		estafa.setApe2("Botijo");
		estafa.setEdad(32);
		estafa.setSexo(1);
		estafa.setCasado("S");
		estafa.setNumHijos(2);
		estafa.setFechaCreacion(new Date());
		estafa.setTipoSeguro(TipoSeguro.COCHE);
		estafa.setMayorEdad(estafa.calculaMayorEdad(estafa.getEdad()));
		
		estafa.setFechaNacimiento(new Date());
		estafa.setHoraContacto(LocalTime.now());
		
		estafa.setCodigo(new char[] {'t','o'});
		estafa.setComentarios("Cobrar y no pagar es nuestro lema");
		
		GuardarSeguro(estafa);
		
		Seguro estafa2 = recuperaSeguro(estafa.getIdSeguro());
		
		estafa2.setNombre("Edad actualizada");
		RefrescaSeguro(estafa2);
	
		Seguro estafa3 = new Seguro();
		estafa3.setNif("658241");
		EliminaSeguro(estafa3);
		
		Utilidades.getSessionFactory().close();
	}
		
	//Para borrar un seguro
	public static void EliminaSeguro(Seguro segui) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(segui);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) 
		{
			if (tx != null)
				tx.rollback();
			System.out.println("Error de algo");
		} 
		finally 
		{
			
			session.close();
		}

	}

	//Metodo que actualiza un seguro
	public static void RefrescaSeguro(Seguro segui) 
	{
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(segui);
			session.getTransaction().commit();
		} 
		catch (RuntimeException e) 
		{
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error al actualizar");
		}
		finally
		{
			session.close();
		}

	}

	//Metodo importante para guardar un seguro
	public static void GuardarSeguro(Seguro segui) 
	{
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try 
		{
			tx = session.beginTransaction();
			session.save(segui);
			session.getTransaction().commit();

		} 
		catch (RuntimeException e) 
		{
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error al almacenar el seguro.");
		} 
		finally 
		{
			session.close();
		}

	}

	//Este metodo devuelve un seguro a partir de un id
	public static Seguro recuperaSeguro(int id)
	{
		Session session = Utilidades.getSessionFactory().openSession();
		Seguro segui = new Seguro();
		session.beginTransaction();
		try
		{
			segui = (Seguro) session.load(Seguro.class, id);
			System.out.println("El segurode id" +id +"es:"
					+ segui.toString());
			session.getTransaction().commit();
		}
		catch (ObjectNotFoundException e) 
		{} 
		finally
		{
			session.close();
		}
		
		
		return segui;
	}

}
