package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */

/**
 *Variables de la base de datos  
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String DBNAME = "actividad4";// nombre de la base de datos
    private static final String DB_USERNAME = "root"; // usuario de la base de datos
    private static final String DB_PASSWORD = ""; // contraseña base de datos
	
    private static final String LOGIN_QUERY = "SELECT usuari,password FROM login WHERE usuari=? and password=?";
    private static final String HOME_PAGE = "./welcome.jsp";// archivo donde redigira cuando haga login
    private static final String LOGIN_PAGE = "./index.jsp";// archivo con el codigo donde permite hacer el login

/**
 * Recolecta los datos del indice , lo que recibe del login 
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strUserName = request.getParameter("username");// guarda el nombre
		String strPassword = request.getParameter("password");// guarda la contraseña
		String strErrMsg = null;
		HttpSession session = request.getSession();
		boolean isValidLogon = false;
		try {
			isValidLogon = authenticateLogin(strUserName, strPassword);
			if(isValidLogon) {
				session.setAttribute("username", strUserName);
			} else {
				strErrMsg = "User name or Password is invalid. Please try again.";
			}
		} catch(Exception e) {
			strErrMsg = "Unable to validate user / password in database";
			
		}
		
		if(isValidLogon) {
			response.sendRedirect(HOME_PAGE);
		} else {
			session.setAttribute("errorMsg", strErrMsg);
			response.sendRedirect(LOGIN_PAGE);
		}
		
	}
	/**
	 * Verifica que el usuario existe en la base de datos a traves de :
	 * @param strUserName : comprueba con el nombre
	 * @param strPassword : comprueba la contraseña corresponda con el usuario
	 * @return
	 * @throws Exception
	 */
	private boolean authenticateLogin(String strUserName, String strPassword) throws Exception {
		boolean isValid = false;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(LOGIN_QUERY);
			prepStmt.setString(1, strUserName);
			prepStmt.setString(2, strPassword);
			ResultSet rs = prepStmt.executeQuery();
			if(rs.next()) {
				System.out.println("User login is valid in DB");
				isValid = true;
			}
		} catch(Exception e) {
			System.out.println("validateLogon: Error while validating password: "+e.getMessage());
			throw e;
		} finally {
			closeConnection(conn);
		}
		return isValid;
	}
	
	private void closeConnection(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch(SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}
	
	/**
	 * 
	 * @return Conexion con la base de datos , utilizando las variables mencionadas arriba 
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost/"+DBNAME+"?user="+DB_USERNAME+"&password="+DB_PASSWORD;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to open connection to db: "+sqle.getMessage());
			throw sqle;
		} catch(Exception e) {
			System.out.println("Exception: Unable to open connection to db: "+e.getMessage());
			throw e;
		}
		return conn;
	}

}

