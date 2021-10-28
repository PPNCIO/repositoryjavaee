package org.dao.producto;

import java.util.List;

import org.modelo.producto.Producto;



//INTERFACE: NO SE PROGRAMA, SOLO SE AGREGAN LOS METODOS A IMPLEMENTAR 

public interface DaoProducto {
	
	public void addProducto(Producto producto);
	public List<Producto> listProductos();
	public Producto getProductoById(int id);
	public void deleteProducto(int id);
	
}
