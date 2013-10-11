package workflow.demo.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import workflow.demo.domain.Usuario;
import org.ticpy.tekoporu.template.JPACrud;

public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	@SuppressWarnings("unchecked")
	public List<Usuario> find() {

		Query q = em
				.createQuery("select new Usuario(u.usuarioId, u.username,u.nombre, u.apellido, u.telefono, u.email )"
						+ " from org.ticpy.ruvig.domain.Usuario u");
		return q.getResultList();
	}

	// metodo para concatenar el nombre y apellido del usuario
	public String getUserDs(String nick) {

		String userDs = "";
		Query q = em
				.createQuery("select u.nombre, u.apellido as ds from Usuario u where u.username='"
						+ nick + "'");
		List<Object[]> listaResultados = q.getResultList();
		for (int i = 0; i < listaResultados.size(); i++) {
			userDs = listaResultados.get(i)[0] + " "
					+ listaResultados.get(i)[1];
		}
		return userDs;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findPage(int pageSize, int first, String sortField,
			boolean sortOrderAsc) {

		String order = "asc";
		if (!sortOrderAsc)
			order = "desc";

		Query q = em
				.createQuery("select new Usuario(u.usuarioId, u.username,u.nombre, u.apellido, u.telefono, u.email )"
						+ " from Usuario u order by " + sortField + " " + order);
		q.setFirstResult(first);
		q.setMaxResults(pageSize);

		return (List<Usuario>) q.getResultList();

	}

	public int count() {

		Query q = em.createQuery("select count(*) from Usuario u");
		return ((Long) q.getSingleResult()).intValue();

	}

}
