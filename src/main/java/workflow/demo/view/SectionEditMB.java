package workflow.demo.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import workflow.demo.business.SectionBC;
import workflow.demo.domain.Section;

@ViewController
@PreviousView("/section_list.xhtml")
public class SectionEditMB extends AbstractEditPageBean<Section, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SectionBC sectionBC;

	@Override
	@Transactional
	public String delete() {

		this.sectionBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		this.sectionBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		this.sectionBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.sectionBC.load(getId()));

	}
}
