package beans;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import artRoom.entities.Discount;
import artRoom.services.IServiceDiscountLocal;

@ManagedBean(name = "discountBean")
@SessionScoped
public class DiscountBean implements Serializable {

	private static final long serialVersionUID = -4135665361498136610L;

	@EJB
	IServiceDiscountLocal service;

	/*
	 * Injection du bean DiscountIteamBean pour passer la valeur du
	 * selected_discount au bean DiscountIteamBean
	 */
	@ManagedProperty(value = "#{discountitemBean}")
	private DiscountItemBean discountitemBean;

	/* Liste des dicounts */
	private List<Discount> discounts;

	/* Valeurs des select */
	private Map<String, Integer> months;
	private Map<String, String> sortValues;

	/* Valeur des filtres */
	private Date startDate;
	private Date endDate;
	private String sortValue;
	private int search_discountValue;

	/* Variable pour l'ajout d'une nouvelle entité et la modification */
	private int discountvalue;
	private Date start_date;
	private Date end_date;

	/* Variable pour la recuperation de l'id de l'item selectionné */
	private int idSelectedItem;

	/* initialisation */
	@PostConstruct
	public void init() {
		Calendar c = Calendar.getInstance();

		/* Initialisation des mois */
		months = new LinkedHashMap<>();
		months.put("January", Calendar.JANUARY);
		months.put("February", Calendar.FEBRUARY);
		months.put("March", Calendar.MARCH);
		months.put("April", Calendar.APRIL);
		months.put("May", Calendar.MAY);
		months.put("June", Calendar.JUNE);
		months.put("July", Calendar.JULY);
		months.put("August", Calendar.AUGUST);
		months.put("September", Calendar.SEPTEMBER);
		months.put("October", Calendar.OCTOBER);
		months.put("November", Calendar.NOVEMBER);
		months.put("December", Calendar.DECEMBER);

		/* initialisation du start_date */
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		startDate = c.getTime();

		/* initialisation du end_date */
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		endDate = c.getTime();

		/* initialisation des valeurs des sorts */
		sortValues = new LinkedHashMap<>();
		sortValues.put("Discount value", "discountvalue");
		sortValues.put("Start Date", "start_date");
		sortValues.put("End Date", "end_date");
		sortValue = "discountvalue";

		/* initialisation de la valeur de la recherche de discount */
		this.search_discountValue = 0;
	}

	/* le format de la date dans l'affichage */
	public String formatDate(java.sql.Timestamp date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM", Locale.US);
		return sdf.format(date);
	}

	/* Afficher la fenetre de la liste */
	public String showList() {
		return "list?faces-redirect=true";
	}

	/* chargement des discounts utilisé par les appelles ajax */
	public void loadDiscounts() {
		/* afficher les messages */
		try {
			if (search_discountValue == 0) {
				discounts = (List<Discount>) service.findAllDiscounts(startDate, endDate, sortValue);
			} else {
				discounts = (List<Discount>) service.findAllDiscountsByDiscountValue(startDate, endDate,
						search_discountValue, sortValue);
			}
		} catch (Exception e) {
			System.out.println("[-] Error : DiscountBean/gerDiscount: " + e.getMessage());
			JsfUtil.addErrorMessage(e, "Connection Error");
		}
	}

	/* Affichage de la liste des discounts */
	public List<Discount> getDiscounts() {
		loadDiscounts();
		return this.discounts;
	}

	/* lors du changement de la valeur de startDate */
	public void startDateChanged(ValueChangeEvent e) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, Integer.parseInt(e.getNewValue().toString()));
		startDate = c.getTime();
	}

	/* lors du changement de la valeur de endDate */
	public void endDateChanged(ValueChangeEvent e) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, Integer.parseInt(e.getNewValue().toString()));
		endDate = c.getTime();
	}

	/* lors du changement de la valeur de tri */
	public void sortValueChanged(ValueChangeEvent e) {
		this.sortValue = e.getNewValue().toString();
	}

	/* lors du click sur la recherche */
	public void searchValueChanged(ValueChangeEvent e) {
		this.search_discountValue = Integer.parseInt(e.getNewValue().toString());
	}

	/* fonction pour initialiser les champs d'ajout */

	public void initAdd() {
		discountvalue = 0;
		start_date = Calendar.getInstance().getTime();
		end_date = Calendar.getInstance().getTime();
	}

	/* fonction pour afficher la fenetre de l'ajout */
	public String showAdd() {
		/* initialisation des variables */
		initAdd();
		/* redirection vers la fentre de l'ajout */
		return "add?faces-redirect=true";
	}

	/* Ajout d'une nouvelle entite */
	public void addDiscount() {
		Discount d = new Discount(discountvalue, start_date, end_date);
		try {
			service.addDiscount(d);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("Discount Added");
			initAdd();
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to add discount");
		}
	}

	/* fonction pour afficher la fenetre de la modification */
	public String showEdit(Discount d) {
		/* initialisation des variables */
		idSelectedItem = d.getId();
		discountvalue = d.getDiscountvalue();
		start_date = d.getStart_date();
		end_date = d.getEnd_date();

		/* redirection vers la fentre de modification */
		return "edit?faces-redirect=true";
	}

	/* fontion pour la modification */
	public void editDiscount() {
		Discount d = new Discount(idSelectedItem, discountvalue, start_date, end_date);
		try {
			service.updateDiscount(d);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("Discount Updated !!");

		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to update discount");
		}
	}

	/* fonction pour la suppression */
	public void deleteDiscount(Discount d) {
		try {
			service.deleteDiscount(d);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("Discount Removed");
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to remove discount");
		}
	}

	/* fonction pour afficher la fentre des items d'un discount */
	public String showItems(Discount discount) {
		discountitemBean.setSelected_discount(discount);
		discountitemBean.initSelect();
		return "items?faces-redirect=true";
	}

	public Map<String, Integer> getMonths() {
		return months;
	}

	public Map<String, String> getSortValues() {
		return sortValues;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getSortValue() {
		return sortValue;
	}

	public int getSearch_discountValue() {
		return search_discountValue;
	}

	public void setSearch_discountValue(int search_discountValue) {
		this.search_discountValue = search_discountValue;
	}

	public int getDiscountvalue() {
		return discountvalue;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setDiscountvalue(int discountvalue) {
		this.discountvalue = discountvalue;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getIdSelectedItem() {
		return idSelectedItem;
	}

	public void setIdSelectedItem(int idSelectedItem) {
		this.idSelectedItem = idSelectedItem;
	}

	public DiscountItemBean getDiscountitemBean() {
		return discountitemBean;
	}

	/* essentielle pour la dependency injection */
	public void setDiscountitemBean(DiscountItemBean discountitemBean) {
		this.discountitemBean = discountitemBean;
	}

}
