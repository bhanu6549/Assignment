package com.mindtree.candyshop.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyshop.entity.Candy;
import com.mindtree.candyshop.entity.Shop;
import com.mindtree.candyshop.exception.serviceexception.ServiceException;
import com.mindtree.candyshop.exception.serviceexception.customexceptin.NoShopFoundException;
import com.mindtree.candyshop.exception.serviceexception.customexceptin.ShopAlreadyExistException;
import com.mindtree.candyshop.exception.serviceexception.customexceptin.ShopDataNotFoundException;
import com.mindtree.candyshop.repository.ShopRepository;
import com.mindtree.candyshop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopRepository shopRepository;

	@Override
	public Shop addShop(Shop shop) throws ServiceException {
		// TODO Auto-generated method stub
		if (shopRepository.findByShopName(shop.getShopName()).isPresent()) {
			throw new ShopAlreadyExistException("Shop by this name already exist");
		}
		for (Candy candy : shop.getCandy()) {
			candy.setShop(shop);
		}
		return shopRepository.save(shop);
	}

	@Override
	public List<Shop> displayAllShops() throws ServiceException {
		// TODO Auto-generated method stub
		if (shopRepository.findAll().isEmpty()) {
			throw new NoShopFoundException("No shop found...!");
		} else
			return shopRepository.findAll();
	}

	@Override
	public Shop updateShop(String name, int shopId) throws ServiceException {
		// TODO Auto-generated method stub
		Shop shop = shopRepository.findById(shopId)
				.orElseThrow(() -> new ShopDataNotFoundException("No shop found of this id"));
		shop.setShopName(name);
		return shopRepository.save(shop);
	}

	@Override
	public void deleteShop(int shopId) throws ServiceException {
		// TODO Auto-generated method stub
		Shop shop=shopRepository.findById(shopId).orElseThrow(()->new ShopDataNotFoundException("No shop found of this id"));
		shopRepository.delete(shop);
	}
}
