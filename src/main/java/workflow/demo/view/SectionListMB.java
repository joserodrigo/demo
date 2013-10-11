package workflow.demo.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import workflow.demo.business.SectionBC;
import workflow.demo.domain.Section;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;

@ViewController
@NextView("/section_edit.xhtml")
@PreviousView("/section_list.xhtml")
public class SectionListMB extends AbstractListPageBean<Section, Long> {

	private static final long serialVersionUID = 1L;
	@Inject
	private SectionBC sectionBC;

	private LazyDataModel<Section> model;

	private int pageSize = 5;

	@SuppressWarnings("serial")
	@PostConstruct
	public void loadLazyModel() {

		model = new LazyDataModel<Section>() {

			@Override
			public List<Section> load(int first, int pageSize,
					String sortField, boolean sortOrder,
					Map<String, String> filters) {

				if (sortField == null) sortField = "sectionId"; // default sort field

				List<Section> section = new ArrayList<Section>();
				section = sectionBC.findPage(pageSize, first, sortField,
						sortOrder);

				return section;
			}
		};

		model.setRowCount(sectionBC.count());
		model.setPageSize(pageSize);

	}

	@Override
	protected List<Section> handleResultList() {

		return this.sectionBC.findAll();
	}

	@Transactional
	public String deleteSelection() {

		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				sectionBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	public LazyDataModel<Section> getModel() {

		return model;
	}

	public int getPageSize() {

		return this.pageSize;
	}

}
