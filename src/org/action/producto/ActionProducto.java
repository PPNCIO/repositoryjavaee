package org.action.producto;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.producto.DaoImplProducto;
import org.dao.producto.DaoProducto;
import org.modelo.producto.Producto;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionProducto extends ActionSupport implements ModelDriven<Producto> {
	private Producto producto = new Producto();
	private DaoProducto dao = new DaoImplProducto();
	private List<Producto> listProductos = new ArrayList<Producto>();
		
	public String execute() { 
		return SUCCESS;
		
	}
	public String add( ) { 
		dao.addProducto(producto);
		return SUCCESS;
	}
	public String list() {
		setListProductos(dao.listProductos());
		return SUCCESS;
	}
	public String edit() {
		HttpServletRequest request = (HttpServletRequest)
		ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		producto = dao.getProductoById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	public String delete() { 
		HttpServletRequest request = (HttpServletRequest)
		ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.deleteProducto(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	@Override
	public Producto getModel() {
		return producto;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<Producto> getListProductos() {
		return listProductos;
	}
	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}
	
}
