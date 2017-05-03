package artRoom.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import artRoom.entities.Artwork;
import artRoom.entities.Discount;
//import artRoom.entities.Shop;

@Remote
public interface IServiceDiscountRemote {

	void addDiscount(Discount discount) throws Exception;

	void updateDiscount(Discount discount) throws Exception;

	void deleteDiscount(Discount discount) throws Exception;

	List<Discount> findAllDiscounts(Date startDate, Date endDate, String orderby) throws Exception;

	List<Discount> findAllDiscountsByDiscountValue(Date startDate, Date endDate, int discount, String orderby)
			throws Exception;
	void deleteItemDiscount(Discount discount, Artwork artwork) throws Exception;

	Discount findDiscountById(int id) throws Exception;
	void addItemDiscount(Discount discount, Artwork artwork) throws Exception;

	//List<Shop> findItemsAndShops() throws Exception;

}