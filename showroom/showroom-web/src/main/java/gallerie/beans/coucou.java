package gallerie.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class coucou {
	private List<String> list;

	public List<String> getList() {
		list.add("a");
		list.add("e");
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
