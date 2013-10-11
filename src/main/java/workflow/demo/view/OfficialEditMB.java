package workflow.demo.view;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import workflow.demo.business.OfficialBC;
import workflow.demo.business.SectionBC;
import workflow.demo.domain.Official;
import workflow.demo.domain.Section;
import workflow.demo.domain.Usuario;
import workflow.demo.util.HashUtils;

@ViewController
@PreviousView("/official_list.xhtml")
public class OfficialEditMB extends AbstractEditPageBean<Official, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficialBC officialBC;

	@Inject
	private SectionBC sectionBC;

	protected List<Section> getTiposRoles() {

		return sectionBC.findAll();
	}

	@Override
	@Transactional
	public String delete() {

		this.officialBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		Official official = getBean();
		this.officialBC.insert(official);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		Official official = getBean();
		this.officialBC.update(official);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.officialBC.load(getId()));

	}

}
