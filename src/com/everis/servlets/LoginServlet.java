package com.everis.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.dal.UsuarioDao;
import com.everis.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String usuarioForm = req.getParameter("txtUsuario");
			String senhaForm = req.getParameter("txtSenha");

//			// Validação Mock //
//			if (!usuarioForm.equals("admin") || !senhaForm.equals("admin")) {
//				req.setAttribute("erro", "Usuária ou senha inválidos!");
//				throw new RuntimeException("TENTATIVA DE ACESSO COM USUÁRIO INVÁLIDO");
//			}
			
			// Validação com Banco de Dados //
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaMySqlPU");
			EntityManager em = emf.createEntityManager();
			UsuarioDao usuarioDao = new UsuarioDao(em);
			Usuario usuario = usuarioDao.validaLogon(usuarioForm, senhaForm);
			if (usuario == null) {
				req.setAttribute("erro", "Usuária ou senha inválidos!");
				throw new RuntimeException("TENTATIVA DE ACESSO COM USUÁRIO INVÁLIDO");
			}

			resp.sendRedirect("menu");

		} catch (Exception e) {
			resp.sendRedirect("login.jsp?erro=USUARIO%20OU%20SENHA%20INVALIDOS");
		}
	}

}
