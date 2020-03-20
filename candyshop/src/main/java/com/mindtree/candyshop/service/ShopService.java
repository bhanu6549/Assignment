package com.mindtree.candyshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.candyshop.entity.Shop;
import com.mindtree.candyshop.exception.serviceexception.ServiceException;

@Service
public interface ShopService {
	Shop addShop(Shop shop) throws ServiceException;
	List<Shop> displayAllShops() throws ServiceException;
	Shop updateShop(String name,int shopId) throws ServiceException;
	void deleteShop(int shopId) throws ServiceException;
}
