package workflow.demo.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.Startup;
import org.ticpy.tekoporu.template.DelegateCrud;
import org.ticpy.tekoporu.transaction.Transactional;
import workflow.demo.domain.Section;
import workflow.demo.persistence.SectionDAO;

public class SectionBC extends DelegateCrud<Section, Long, SectionDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SectionDAO sectionDAO;

	@Startup
	@Transactional
	public void load() {

		if (findAll().isEmpty()) {
			insertTestData();
		}
	}

	public List<Section> findPage(int pageSize, int first, String sortField,
			boolean sortOrderAsc) {

		return sectionDAO.findPage(pageSize, first, sortField, sortOrderAsc);
	}

	public int count() {

		return sectionDAO.count();
	}

	public void insertTestData() {

		insert(new Section("Informatica"));
		insert(new Section("Contabilidad"));
		insert(new Section("Recursos Humanos"));
		insert(new Section("Direccion General de Finanzas"));
		insert(new Section("Extraccion de Renumeraciones"));
	}
}
