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

import com.everis.dal.ClienteDao;
import com.everis.dal.UsuarioDao;
import com.everis.entidades.Cliente;
import com.everis.entidades.Usuario;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;
	private ClienteDao clienteDao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = new UsuarioDao(geEntityManager());
		clienteDao = new ClienteDao(geEntityManager());
	}

	public ClienteServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioDao.buscarTodos();
		List<Cliente> clientes = clienteDao.buscarTodos();
		request.setAttribute("usuariosList", usuarios);
		request.setAttribute("clientesList", clientes);
		request.getRequestDispatcher("/WEB-INF/views/clientes.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Obtendo parametros da requisicao */
		
		String nomeForm = request.getParameter("nomeCliente");
		String emailForm = request.getParameter("emailCliente");
		String telefoneForm = request.getParameter("telefoneCliente");
		String usuarioForm = request.getParameter("usuarioCliente");
		
		/* Criando objeto cliente */
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeForm);
		cliente.setEmail(emailForm);
		cliente.setTelefone(telefoneForm);
		cliente.setUsuario(usuarioDao.buscar(usuarioForm));

		/* Salvando cliente no banco de dados */
		
		clienteDao.salvar(cliente);
		
		/* Redirecionando para a listagem */
		
		response.sendRedirect("clientes");
	}

}
