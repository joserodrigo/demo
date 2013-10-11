package workflow.demo.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.ticpy.tekoporu.template.JPACrud;
import workflow.demo.domain.Official;

public class OfficialDAO extends JPACrud<Official, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	@SuppressWarnings("unchecked")
	public List<Official> find() {

		Query q = em
				.createQuery("select o.nombre, o.apellido, o.telefono, o.email, s.sectiondesc "
						+ "from Official as o, Section as s where o.Section.sectionId=s.sectionId ");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Official> findPage(int pageSize, int first, String sortField,
			boolean sortOrderAsc) {

		String order = "asc";
		if (!sortOrderAsc)
			order = "desc";

		Query q = em
				.createQuery("select o.nombre,o.apellido,o.telefono, o.email, s.sectiondesc "
						+ " from Official as o, Section as s where o.Section.sectionId=s.sectionId order by "
						+ sortField + " " + order);
		q.setFirstResult(first);
		q.setMaxResults(pageSize);

		return (List<Official>) q.getResultList();

	}

	public int count() {

		Query q = em.createQuery("select count(*) from Official o");
		return ((Long) q.getSingleResult()).intValue();

	}
}
