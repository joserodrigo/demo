package workflow.demo.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.util.ResourceBundle;
import workflow.demo.business.OfficialBC;
import workflow.demo.business.UsuarioBC;
import workflow.demo.domain.Official;
import workflow.demo.domain.Usuario;


@ViewController
@NextView("official_edit.xhtml")
@PreviousView("official_list.xhtml")
public class OfficialListMB extends AbstractListPageBean<Official, Integer>{


	private static final long serialVersionUID = 1L;
    
	@Inject
	private OfficialBC officialBC;
	@Inject
	private ResourceBundle bundle;
	
	private LazyDataModel<Official> model;	
	private int pageSize = 3;
	

	@SuppressWarnings("serial")
	@PostConstruct
	public void loadLazyModel() {
		model = new LazyDataModel<Official>() {

			@Override
			public List<Official> load(int first, int pageSize, String sortField,
					boolean sortOrder, Map<String, String> filters) {
					
					if(sortField == null) sortField = "officialId"; //default sort field
				
					List<Official> func = new ArrayList<Official>();
					func = officialBC.findPage(pageSize, first, sortField, sortOrder);
				
					return func;
			}
		};
		
		model.setRowCount(officialBC.count());
		model.setPageSize(pageSize);
	}
	
	@Override
	protected List<Official> handleResultList() {

		return this.officialBC.listarFuncionarios();
	} 
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				officialBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	
	public LazyDataModel<Official> getModel() {
	    return model; 
	}
	
	public int getPageSize() {
		
		return this.pageSize;
		
	}
	

}
