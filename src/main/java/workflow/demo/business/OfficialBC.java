package workflow.demo.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.Startup;
import org.ticpy.tekoporu.template.DelegateCrud;
import org.ticpy.tekoporu.transaction.Transactional;
import workflow.demo.domain.Official;
import workflow.demo.domain.Section;
import workflow.demo.persistence.OfficialDAO;
import workflow.demo.persistence.SectionDAO;


public class OfficialBC extends DelegateCrud<Official, Integer, OfficialDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficialDAO officialDAO;

	@Inject
	private SectionDAO sectionDAO;

	@Startup
	@Transactional
	public void load() {

		if (findAll().isEmpty()) {

			List<Section> list = sectionDAO.findAll();
			Section section1 = list.get(0);
			Section section2 = list.get(1);
			Section section3 = list.get(2);

			insert(new Official(4567345, "Pablo", "Fariña", "Azara 455",
					"343556", "pablo@gmail.com", section1));
			insert(new Official(3567345, "Madi", "Ferreira", "Brasil 343",
					"443556", "madi@gmail.com", section2));
			insert(new Official(3505545, "Cesar", "Colman", "San Martin",
					"454639", "cesar@gmail.com", section3));
			// System.out.println(usuarioDAO.findAll().get(0).getUsername() +
			// " "
			// + usuarioDAO.findAll().get(0).getRol().getRolId() + " "
			// + usuarioDAO.findAll().get(0).getRol().getDescripcion());
		}

	}

	public List<Official> listarFuncionarios() {

		return officialDAO.find();
	}

	public List<Official> findPage(int pageSize, int first, String sortField,
			boolean sortOrderAsc) {

		return officialDAO.findPage(pageSize, first, sortField, sortOrderAsc);
	}

	public int count() {

		return officialDAO.count();
	}

}
