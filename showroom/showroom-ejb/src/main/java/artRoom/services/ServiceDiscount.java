package artRoom.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import  artRoom.entities.Discount;
import artRoom.entities.Gallery;
import  artRoom.entities.Artwork;
//import  artRoom.entities.shop;

@Stateless
public class ServiceDiscount implements IServiceDiscountRemote, IServiceDiscountLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public void addDiscount(Discount discount) throws Exception {
		em.persist(discount);
	}

	@Override
	public void updateDiscount(Discount discount) throws Exception {
		em.merge(discount);
	}

	@Override
	public void deleteDiscount(Discount discount) throws Exception {
		em.remove(em.merge(discount));
	}

	// Ma7abetch temchi :(
	// @Override
	// public List<Item> findItemsByDiscount(Discount discount) throws Exception
	// {
	// TypedQuery<Item> query = em.createQuery("select i from Item i join
	// i.discounts d where d.id in (?1)", Item.class);
	// query.setParameter(1, discount.getId());
	// List<Item> items = query.getResultList();
	// if ( items.size() < 1 )
	// {
	// return new ArrayList<>();
	// }
	// return items;
	// }

	@Override
	public List<Discount> findAllDiscounts(Date startDate, Date endDate, String orderby) throws Exception {
		TypedQuery<Discount> query = em.createQuery("SELECT d FROM Discount d "

				+ "where ( DATE_FORMAT(d.start_date, '%m') >= DATE_FORMAT(?1, '%m') "
				+ "and DATE_FORMAT(d.end_date, '%m') <= DATE_FORMAT(?2, '%m') )" + "order by d." + orderby + " desc",
				Discount.class);
		query.setParameter(1, startDate);
		query.setParameter(2, endDate);

		List<Discount> discounts = query.getResultList();
		for (Discount discount : discounts) {
			discount.getArtworks().size();// ByPass LazyExceptionError
		}
		return discounts;
	}

	@Override
	public List<Discount> findAllDiscountsByDiscountValue(Date startDate, Date endDate, int discount, String orderby)
			throws Exception {
		TypedQuery<Discount> query = em.createQuery(
				"SELECT d FROM Discount d " + "where ( ( DATE_FORMAT(d.start_date, '%m') >= DATE_FORMAT(?1, '%m')) "
						+ "and ( DATE_FORMAT(d.end_date, '%m') <= DATE_FORMAT(?2, '%m')) "
						+ "and d.discountvalue = ?3) " + "order by d." + orderby + " desc",
				Discount.class);
		query.setParameter(1, startDate);
		query.setParameter(2, endDate);
		query.setParameter(3, discount);

		List<Discount> discounts = query.getResultList();
		for (Discount discount2 : discounts) {
			discount2.getArtworks().size(); // ByPass LazyExceptionError
		}
		return discounts;
	}

	@Override
	public Discount findDiscountById(int id) throws Exception {
		return em.find(Discount.class, id);
	}

	@Override
	public List<Gallery> findArtworksAndGalleries() throws Exception {
		TypedQuery<Gallery> query = em.createQuery("SELECT s FROM Gallery s", Gallery.class);
		List<Gallery> galleries = query.getResultList();
		for (int i = 0; i < galleries.size(); i++) {
			galleries.get(i).getArtworks().size();
		}
		return galleries;
	}

	@Override
	public void deleteItemDiscount(Discount discount, Artwork artwork) throws Exception {
		discount.getArtworks().remove(artwork);
		em.merge(discount);
	}

	@Override
	public void addItemDiscount(Discount discount, Artwork artwork) throws Exception {
		discount.getArtworks().add(artwork);
		em.merge(discount);
	}

	@Override
	public Gallery findGalleryById(int id) throws Exception {
		return em.find(Gallery.class, id);
	}

	@Override
	public Artwork findArtworkById(int id) throws Exception {
		return em.find(Artwork.class, id);
	}

	@Override
	public List<Artwork> findGalleryArtworks(Gallery gallery) throws Exception {
		TypedQuery<Artwork> query = em.createQuery("SELECT i FROM Artwork i where i.galleryart=?1", Artwork.class);
		query.setParameter(1, gallery);
		List<Artwork> artworks = query.getResultList();
		return artworks;
	}
}
