package beans;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import artRoom.entities.Discount;
import artRoom.entities.Gallery;
import artRoom.entities.Artwork;
import artRoom.services.IServiceDiscountLocal;

@ManagedBean(name = "discountitemBean")
@SessionScoped
public class DiscountItemBean implements Serializable {

	private static final long serialVersionUID = 5540731501817952361L;

	/* la liste des galleries */
	private Map<String, Integer> galleries;

	/* la liste des items dans un shop */
	private Map<String, Integer> galleryartworks;

	/* la liste des items du discount */
	private List<Artwork> artworks;

	/* le Discount selectionné */
	private Discount selected_discount;

	/* le gallery selectionné */
	private Gallery selected_gallery;

	/* l'item selectionné */
	private Artwork selected_artwork;

	@EJB
	private IServiceDiscountLocal service;

	/* initialisation des select */
	public void initSelect() {
		galleries.clear();
		List<Gallery> galleries_loaded;
		try {
			galleries_loaded = service.findArtworksAndGalleries();
			if (galleries_loaded.size() > 0) {
				for (Gallery g : galleries_loaded) {
					galleries.put(g.getAddress(), g.getIdGallery());
				}

				/* initialisation du premier shop */
				selected_gallery = galleries_loaded.get(0);

				/* chargement des items */
				   loadArtworks();
			}
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, "Connection Error");
			System.out.println("[-] Error : DiscountItemBean/init: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		galleries = new LinkedHashMap<>();
		initSelect();
	}

	/* les items du discount */
	public List<Artwork> getItems() {
		artworks = selected_discount.getArtworks();
		return artworks;
	}

	/* la liste des galleries */
	public Map<String, Integer> getGalleryArtworks() {
		return galleryartworks;
	}

	/* la liste des item d'un gallery */
	public Map<String, Integer> getGalleries() {
		return galleries;
	}

	/* chargement des items d'un shop */
	public void loadArtworks() {
		List<Artwork> artworks;
		try {
			artworks = service.findGalleryArtworks(selected_gallery);
			if (galleryartworks == null) {
				galleryartworks = new LinkedHashMap<>();
			}
			if (galleryartworks.size() > 0) {
				galleryartworks.clear(); // si deja vide clear() lance une exception
			}
			for (Artwork i : artworks) {
				galleryartworks.put(i.getTitle(), i.getIdArtwork());
			}

			/* initialisation */
			selected_artwork = artworks.get(0);
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, "Connection Error");
			System.out.println("[-] Error : DiscountItemBean/loadItems: " + e.getMessage());
		}
	}

	/* lors du changement de la valeur de gallery */
	public void selectedGalleryChanged(ValueChangeEvent e) {
		try {
			selected_gallery = service.findGalleryById(Integer.parseInt(e.getNewValue().toString()));
			loadArtworks();
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "Connection Error");
			System.out.println("[-] Error : DiscountItemBean/selectedShopChanged: " + ex.getMessage());
		}
	}

	/* lors du changement de la valeur de item */
	public void selectedItemChanged(ValueChangeEvent e) {
		try {
			selected_artwork = service.findArtworkById(Integer.parseInt(e.getNewValue().toString()));
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "Connection Error");
			System.out.println("[-] Error : DiscountItemBean/selectedItemChanged: " + ex.getMessage());
		}
	}

	/* suppression d'un item du discount */
	public void deleteItemDiscount(Artwork artwork) {
		try {
			service.deleteItemDiscount(selected_discount, artwork);
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "Unable to delete item");
			System.out.println("[-] Error : DiscountItemBean/deleteItemDiscount: " + ex.getMessage());
		}
	}

	/* alernative de selected_discount.getItems().contains */
	public boolean itemExist() {
		for (Artwork i : selected_discount.getArtworks()) {
			if (i.getIdArtwork() == selected_artwork.getIdArtwork()) {
				return true;
			}
		}
		return false;
	}

	/* ajout d'un item a un discount */
	public void addItemDisocunt() {
		try {
			if (itemExist()) {
				JsfUtil.addErrorMessage("This item aleardy exists ");
			} else {
				service.addItemDiscount(selected_discount, selected_artwork);
			}
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "Unable to add item");
			System.out.println("[-] Error : DiscountItemBean/addItemDisocunt: " + ex.getMessage());
		}
	}

	public String showList() {
		return "list?faces-redirect=true";
	}

	public Discount getSelected_discount() {
		return selected_discount;
	}

	public void setSelected_discount(Discount selected_discount) {
		this.selected_discount = selected_discount;
	}

	public Map<String, Integer> getGalleryartworks() {
		return galleryartworks;
	}

	public void setGalleryartworks(Map<String, Integer> galleryartworks) {
		this.galleryartworks = galleryartworks;
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	public Gallery getSelected_gallery() {
		return selected_gallery;
	}

	public void setSelected_gallery(Gallery selected_gallery) {
		this.selected_gallery = selected_gallery;
	}

	public Artwork getSelected_artwork() {
		return selected_artwork;
	}

	public void setSelected_artwork(Artwork selected_artwork) {
		this.selected_artwork = selected_artwork;
	}

	public IServiceDiscountLocal getService() {
		return service;
	}

	public void setService(IServiceDiscountLocal service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setGalleries(Map<String, Integer> galleries) {
		this.galleries = galleries;
	}

}
