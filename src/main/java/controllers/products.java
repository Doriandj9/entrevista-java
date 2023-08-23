package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

/**
 * Servlet implementation class products
 */
@WebServlet(name = "products", urlPatterns = "/products")
public class products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.proccessRequestGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*
	 * Procesamos la peticion get por medio del controlador para mostrar en la vista
	 * los datos extraidos del modelo
	 * */
	
	protected void proccessRequestGet(HttpServletRequest request, HttpServletResponse response  ) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
		try {
			Product product = new Product();
			String filtro = request.getParameter("filter");
			Boolean isNull = Objects.isNull(filtro);
			if(!isNull &&  filtro.equals("stock")) {
				product = product.productsStock();
			}else if(!isNull && filtro.equals("uOM$_identifier")) {
				product = product.listProductsUnidad();
			}else {
				product = product.listProduct();
			}
			
			request.setAttribute("data", product);
			request.getRequestDispatcher("/views/lista.jsp").forward(request, response);
			
			
		} finally {
			// TODO: handle finally clause
			out.close();
		}
		
	}
	
	private Product filterProduct(String filter) {
		Boolean isNull =Objects.isNull(filter);
		Product product = new Product();
		Product resProduct = null;
		if( isNull || filter.isEmpty()) {
			resProduct =  product.listProduct();
		}
		
		return resProduct;
	}
}
