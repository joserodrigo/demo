package workflow.demo.business;

import java.util.List;
import javax.inject.Inject;
import workflow.demo.domain.Rol;
import workflow.demo.domain.Usuario;
import workflow.demo.persistence.RolDAO;
import workflow.demo.persistence.UsuarioDAO;
import workflow.demo.util.HashUtils;
import org.ticpy.tekoporu.annotation.Startup;
import org.ticpy.tekoporu.template.DelegateCrud;
import org.ticpy.tekoporu.transaction.Transactional;

public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private RolDAO rolDAO;

	@Startup
	@Transactional
	public void load() {

		if (findAll().isEmpty()) {

			// insert default roles
			if (rolDAO.findAll().isEmpty()) {
				rolDAO.insert(new Rol("admin"));
				rolDAO.insert(new Rol("user"));
			}

			List<Rol> list = rolDAO.findAll();
			Rol rol1 = list.get(0);
			Rol rol2 = list.get(1);

			insert(new Usuario("S", "Administrator", "admin@admin.com",
					"Administrador", HashUtils.md5("admin"), rol1, "5441345",
					"admin"));
			insert(new Usuario("S", "User", "user@user.com", "User",
					HashUtils.md5("user"), rol2, "787454", "user"));
			System.out.println(usuarioDAO.findAll().get(0).getUsername() + " "
					+ usuarioDAO.findAll().get(0).getRol().getRolId() + " "
					+ usuarioDAO.findAll().get(0).getRol().getDescripcion());
		}

	}

	public List<Usuario> listarUsuarios() {

		return usuarioDAO.find();
	}

	public String getUserDs(String us) {

		return usuarioDAO.getUserDs(us);
	}

	public Usuario userName(String user) {

		Usuario u;
		System.out.println("punto 1");
		for (int i = 0; i < listarUsuarios().size(); i++) {
			System.out.println("ingreso punto2");
			System.out.println("listar.get(i)=" + listarUsuarios().get(i));
			u = listarUsuarios().get(i);
			System.out.println("punto 3");
			if (user.equals(u.getUsername().toString())) {
				System.out.println("punto4");
				return u;
			}
			System.out.println("salto el if");
		}
		return null;

	}

	public List<Usuario> findPage(int pageSize, int first, String sortField,
			boolean sortOrderAsc) {

		return usuarioDAO.findPage(pageSize, first, sortField, sortOrderAsc);
	}

	public int count() {

		return usuarioDAO.count();
	}

}
