package beans;

import java.io.ByteArrayInputStream;
/**
 
 * @author Rached Amira
 *
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import artRoom.entities.User;
import artRoom.entities.Admin;
import artRoom.entities.Artist;

import artRoom.services.UserServiceRemote;
import artRoom.services.UserServiceLocal;


/* TODO:    UploadPic*/

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = -4135665361498136610L;

	@EJB
	UserServiceLocal service;
	private User user_edit;
	private User userLoggedIN;
	private User userChoosen;
	private User userProfile;
	private boolean loggedIN = false;
	private boolean isVisitor = false;
    private  String picture_name;

    private UploadedFile file; 


	/* Liste des users */
	private List<User> users;

	/* Valeurs des select */
	private Map<String, String> searchValues;
	private Map<String, String> sortValues;

	/* Valeur des filtres */
	private String lastNameFilter;
	private String firstNameFilter;
//	private String usernameFilter;
	private String emailFilter;
	private String addressFilter;
	private byte[]  picture;

	/* Valeurs de recherche */
	private String search_userValue;

	/* Variable pour l'ajout d'une nouvelle entité et la modification */
	private String address;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
//	private String username;
	private String firstName;
	private boolean banned;
    private String role;
	/*
	 * Variable pour la recuperation de l'id de l'item selectionné pour le
	 * modifier
	 */
	private int idSelectedItem;

	/* variable pour recuper l'utilisateur selectionné pour afficher ses info */
	private User SelectedUser;

	/* les valeur selectionné depuis les select */
	private String sortValue;
	private String searchValue;
	private String searchValue1;
	private String sortValue1;



	/* initialisation */
	@PostConstruct
	public void init() {
		/* initialisation des valeurs de recherche */
		searchValues = new LinkedHashMap<>();
		searchValues.put("firstName", "firstName");
		/*searchValues.put("lastName", "lastName");
		searchValues.put("E-mail", "email");
		searchValues.put("Role", "Role");*/

		searchValue = "firstName";


		/* initialisation des valeurs des sorts */
		sortValues = new LinkedHashMap<>();
		sortValues.put("firstName", "firstName");
		sortValues.put("lastName", "lastName");
		sortValues.put("role", "role");

		sortValue = "role";
		sortValue = "firstName";
		sortValue = "lastName";
		



		/* initialisation de la valeur de la recherche de user */
		this.search_userValue = "";
	}

	

	/* Afficher la fenetre de la liste */
	public String showList() {
		this.SelectedUser = null;
		return "list?faces-redirect=true";
	}
	/* Afficher la fenetre de la liste */
	public String showList1() {
		this.SelectedUser = null;
		return "/panel/admin/user/list?faces-redirect=true";		
	}
	/* chargement des users utilisé par les appelles ajax */
	public void loadUsers() {
		/* afficher les messages */
		try {
			if (search_userValue.trim().length() == 0) {
				users = (List<User>) service.findAllUsersSortBy(sortValue);

			} else {
				users = (List<User>) service.findAllUsersByValue(search_userValue, searchValue, sortValue);
			}
		} catch (Exception e) {
			System.out.println("[-] Error : UserBean/gerUser: " + e.getMessage());
			JsfUtil.addErrorMessage(e, "Connection Error");
		}
	}
	/* Affichage de la liste des users */
	public List<User> getUsers() {
		loadUsers();
		return this.users;
	}
	/**/
	public String affichelist() {
		String navTo = "list?faces-redirect=true";
		return navTo;
	}

	/* lors du changement de la valeur de sort */
	public void sortChanged(ValueChangeEvent e) {
		sortValue = e.getNewValue().toString();
	}

	/* lors du changement de la valeur de recherche */
	public void searchChanged(ValueChangeEvent e) {
		searchValue = e.getNewValue().toString();
	}

	/* fonction pour afficher la fenetre de l'ajout */
	public String showAdd() {
		/* initialisation des variables */
		address = "";
		lastName = "";
		email = "";
		password = "";
		phoneNumber = (long) 0;
		firstName = "";
		//pic = "";
		/* redirection vers la fentre de l'ajout */
		return "add?faces-redirect=true";
	}
	/* fonction pour afficher l'image */
	public StreamedContent parsePic(User user) {
		return new DefaultStreamedContent(new ByteArrayInputStream(user.getPicture()));
	}
	/* Ajout d'une nouvelle entite */
	public void addUser() {
		User user = new User(password, address,firstName, lastName,email, phoneNumber) ;
		try {
			service.addUser(user);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("User Added");
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to add user");
		}
	}

	/* fonction pour afficher la fenetre de la modification */
	public String showEdit(User user) {
		/* initialisation des variables */
		idSelectedItem = user.getIdUser();
		firstName = user.getFirstName();
        lastName = user.getLastName();
		email = user.getEmail();
		role=user.getRole();
		address = user.getAddress();
		banned = user.isBanned();
		password=user.getPassword();
		phoneNumber = user.getPhoneNumber();
		

		/* redirection vers la fentre de modification */
		return "editaccount?faces-redirect=true";
	}

	/* fontion pour la modification */
	public String editUser() {
		User edit = new User(idSelectedItem,firstName,lastName,email,password,role,address
				,banned,phoneNumber);
		try {
			service.updateUser(edit);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("User Updated !!");
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to update user");
		}return "list?faces-redirect=true";
	}
    
	public void editUsers() {
		User d = new User(firstName,lastName,email,role,address
				,banned,phoneNumber );
		try {

			service.updateUser(d);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("User Updated !!");

		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to update user");
		}
	}
	/* fontion pour activer les comptes */
	public void ApproveUser(User user)
	{try 
	
	{
				service.enableUser(user);
				/* Afficher un message de confirmation */
				if (user.isActive())
				{
					JsfUtil.addSuccessMessage("User activated");
				}
				else
				{
					JsfUtil.addSuccessMessage("User denied access : inactive");				
				}
			} catch (Exception e) {
				/* Afficher un message d'erreur */
				JsfUtil.addErrorMessage(e, "Failed");
			}
	
		}
	
	public String approveUser(User user) {
		if (user.isActive()) {
			return ("True");
		} else {
			return ("false");
		}
	}
	
	/* fonction pour la suppression */
	public void deleteUser(User user) {
		try {
			service.deleteUser(user);
			/* Afficher un message de confirmation */
			JsfUtil.addSuccessMessage("User Removed");
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed to remove user");
		}
		
	}

	/* fonction pour afficher le type de l'utilisateur */
	public String typeUser(User user) {
		/*if (user instanceof Admin) {
			return "Admin";
		} else if (user instanceof Artist) {
			return "Artist";
		} else if (user instanceof User) {
			return "client";
		} else {
			return "Unknown";
		}*/
		if (user.getRole()=="Admin") {
			return ("Admin"); 
		} else if (user.getRole()=="Artist") {
			return ("Artist");
		} else if (user.getRole()=="Client") {
			return "client";
		} else if (user.getRole()=="GalleryOwner") {
			return ("Gallery Owner");
		}/*else {
			return "Unknown";
		}*/
		return user.getRole();
	}

	/* fonction pour retourner si l'utilisateur est blocké */
	public String bannedUser(User user) {
		if (user.isBanned()) {
			return ("True");
		} else {
			return ("false");
		}
	}

	/* fonction pour afficher les info d'un utilisateur */
	public String showInfo(User user) {
		this.SelectedUser = user;
		return "view?faces-redirect=true";
	}



	/* fonction pour blocker / deblocker un utilisateur */
	public void banUser(User user) {
		try {
			service.banUser1(user);
			/* Afficher un message de confirmation */
			if (user.isBanned())
			{
				JsfUtil.addSuccessMessage("User banned");
			}
			else
			{
				JsfUtil.addSuccessMessage("User unbanned");				
			}
		} catch (Exception e) {
			/* Afficher un message d'erreur */
			JsfUtil.addErrorMessage(e, "Failed");
		}
	}



	public UserServiceLocal getService() {
		return service;
	}



	public void setService(UserServiceLocal service) {
		this.service = service;
	}



	public Map<String, String> getSearchValues() {
		return searchValues;
	}



	public void setSearchValues(Map<String, String> searchValues) {
		this.searchValues = searchValues;
	}



	public Map<String, String> getSortValues() {
		return sortValues;
	}



	public void setSortValues(Map<String, String> sortValues) {
		this.sortValues = sortValues;
	}



	public String getLastNameFilter() {
		return lastNameFilter;
	}



	public void setLastNameFilter(String lastNameFilter) {
		this.lastNameFilter = lastNameFilter;
	}



	public String getFirstNameFilter() {
		return firstNameFilter;
	}



	public void setFirstNameFilter(String firstNameFilter) {
		this.firstNameFilter = firstNameFilter;
	}



	public String getEmailFilter() {
		return emailFilter;
	}



	public void setEmailFilter(String emailFilter) {
		this.emailFilter = emailFilter;
	}



	public String getSearch_userValue() {
		return search_userValue;
	}



	public void setSearch_userValue(String search_userValue) {
		this.search_userValue = search_userValue;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public boolean isBanned() {
		return banned;
	}



	public void setBanned(boolean banned) {
		this.banned = banned;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public int getIdSelectedItem() {
		return idSelectedItem;
	}



	public void setIdSelectedItem(int idSelectedItem) {
		this.idSelectedItem = idSelectedItem;
	}



	public User getSelectedUser() {
		return SelectedUser;
	}



	public void setSelectedUser(User selectedUser) {
		SelectedUser = selectedUser;
	}



	public String getSortValue() {
		return sortValue;
	}



	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String doInscription() {
		User subscriber = new User(firstName,lastName,email,password,address,role,phoneNumber);
		//User subscriber = new User(picture,firstName,lastName,email,password,address,role,phoneNumber);
	//	subscriber.setPicture( file.getContents());
		subscriber.setPicture( picture);
		subscriber.setFirstName(firstName);
		subscriber.setLastName(lastName);
		subscriber.setEmail(email);
		subscriber.setPassword(password);
		subscriber.setAddress(address);
		subscriber.setRole(role);
		subscriber.setPhoneNumber(phoneNumber);
        service.addUser(subscriber);
        return "/public/welcome?faces-redirect=true";	}
	
	public String doRenderUpdate()
	{
		user_edit=service.findUserById(((User)Utils.getSession().getAttribute("firstName")).getIdUser());
		return "/Profile/editaccount?faces-redirect=true";
	}
	public String doRenderQuit()
	{
		return "/list?faces-redirect=true";
	}
	public String  DoUpdate() {
		
		service.updateUser(user_edit);
		HttpSession session = Utils.getSession();
		session.setAttribute("identity", user_edit);
		return "/panel/admin/user/list?faces-redirect=true";
					
	}
	public String  DoUpdateProfile() {
		
		service.updateUser(user_edit);
		HttpSession session = Utils.getSession();
		session.setAttribute("email", user_edit);
		return "/Profile/myprofile?faces-redirect=true";
					
	}
	public String showlogin()
	{
		return "/login2?faces-redirect=true";
	}
	public String showprofile()
	{
		isVisitor = false;
		userProfile = userLoggedIN;
		String navTo = "Profile?faces-redirect=true";
		return navTo;
	}

	public String getPicture_name() {
		return picture_name;
	}



	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}


	public User getUser_edit() {
		return user_edit;
	}



	public void setUser_edit(User user_edit) {
		this.user_edit = user_edit;
	}



	public User getUserLoggedIN() {
		return userLoggedIN;
	}



	public void setUserLoggedIN(User userLoggedIN) {
		this.userLoggedIN = userLoggedIN;
	}



	public User getUserChoosen() {
		return userChoosen;
	}



	public void setUserChoosen(User userChoosen) {
		this.userChoosen = userChoosen;
	}



	public User getUserProfile() {
		return userProfile;
	}



	public void setUserProfile(User userProfile) {
		this.userProfile = userProfile;
	}



	public boolean isLoggedIN() {
		return loggedIN;
	}



	public void setLoggedIN(boolean loggedIN) {
		this.loggedIN = loggedIN;
	}

	/*public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
*/
	public boolean isVisitor() {
		return isVisitor;
	}



	public void setVisitor(boolean isVisitor) {
		this.isVisitor = isVisitor;
	}



	public String getAddressFilter() {
		return addressFilter;
	}



	public void setAddressFilter(String addressFilter) {
		this.addressFilter = addressFilter;
	}



	public String getSearchValue1() {
		return searchValue1;
	}



	public void setSearchValue1(String searchValue1) {
		this.searchValue1 = searchValue1;
	}



	public String getSortValue1() {
		return sortValue1;
	}



	public void setSortValue1(String sortValue1) {
		this.sortValue1 = sortValue1;
	}



	public UploadedFile getFile() {
		return file;
	}



	public void setFile(UploadedFile file) {
		this.file = file;
	}
	

}
