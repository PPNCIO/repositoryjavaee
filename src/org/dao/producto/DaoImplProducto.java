package org.dao.producto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.producto.Producto;

public class DaoImplProducto implements DaoProducto {

	@Override
	public void addProducto(Producto producto) {
	
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
		     System.out.println("Exception: " + e.getMessage());
		}
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> listProductos() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Producto> productos = null;
		try {
			session.beginTransaction();
			productos = (List<Producto>) session.createQuery("from Producto").list();
			session.getTransaction().commit();
		} catch (Exception e) {
		     System.out.println("Exception: " + e.getMessage());
		}
		return productos;
	}

	@Override
	public Producto getProductoById(int id) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Producto producto = null;
		try {
			session.beginTransaction();
			producto = (Producto) session.get(Producto.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		     System.out.println("Exception: " + e.getMessage());
		}
		     return producto;
	}

	@Override
	public void deleteProducto(int id) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unused")
		Producto producto = null;
		try {
			session.beginTransaction();
			producto = (Producto) session.get(Producto.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		     System.out.println("Exception: " + e.getMessage());

	}
  }
}