package com.everis.servlets;

import static com.everis.utils.JpaUtil.geEntityManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.dal.PrestadorDao;
import com.everis.dal.UsuarioDao;
import com.everis.entidades.Prestador;
import com.everis.entidades.Usuario;

@WebServlet("/prestadores")
public class PrestadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;
	private PrestadorDao prestadorDao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = new UsuarioDao(geEntityManager());
		prestadorDao = new PrestadorDao(geEntityManager());
	}

	public PrestadorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioDao.buscarTodos();
		List<Prestador> prestadores = prestadorDao.buscarTodos();
		request.setAttribute("usuariosList", usuarios);
		request.setAttribute("prestadoresList", prestadores);
		request.getRequestDispatcher("/WEB-INF/views/prestadores.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
