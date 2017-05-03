package artRoom.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import artRoom.entities.Discount;
import artRoom.entities.Gallery;
import artRoom.entities.Artwork;
//import tn.tunisiamall.entities.Shop;

@Local
public interface IServiceDiscountLocal {
	List<Discount> findAllDiscountsByDiscountValue(Date startDate, Date endDate, int discount, String orderby)
			throws Exception;

	List<Discount> findAllDiscounts(Date startDate, Date endDate, String orderby) throws Exception;

	void addDiscount(Discount discount) throws Exception;

	void updateDiscount(Discount discount) throws Exception;

	void deleteDiscount(Discount discount) throws Exception;

	void deleteItemDiscount(Discount discount, Artwork artwork) throws Exception;

	void addItemDiscount(Discount discount, Artwork artwork) throws Exception;

	List<Artwork> findGalleryArtworks(Gallery gallery) throws Exception;

	Artwork findArtworkById(int id) throws Exception;

	Gallery findGalleryById(int id) throws Exception;

	List<Gallery> findArtworksAndGalleries() throws Exception;

	/*List<Shop> findItemsAndShops() throws Exception;
	
	Shop findShopById(int id) throws Exception;

	void deleteItemDiscount(Discount discount, Item item) throws Exception;

	void addItemDiscount(Discount discount, Item item) throws Exception;

	Item findItemById(int id) throws Exception;

	List<Item> findShopItems(Shop shop) throws Exception;*/
}
