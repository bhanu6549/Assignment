package com.mindtree.candyshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.candyshop.dto.ResponseBody;
import com.mindtree.candyshop.dto.ShopDTO;
import com.mindtree.candyshop.entity.Shop;
import com.mindtree.candyshop.exception.ApplicationException;
import com.mindtree.candyshop.service.ShopService;

@RestController
public class ShopController {
	@Autowired
	ShopService shopService;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/addShop")
	public ResponseEntity<?> addShop(@Valid @RequestBody ShopDTO shop) throws ApplicationException {
		Shop DTOToEntity = modelMapper.map(shop, Shop.class);
		Shop outputOfService = shopService.addShop(DTOToEntity);
		ShopDTO entityToDTO = modelMapper.map(outputOfService, ShopDTO.class);
		return new ResponseEntity<ResponseBody<ShopDTO>>(
				new ResponseBody<ShopDTO>(entityToDTO, null, "shop added successfully", true), HttpStatus.OK);
	}

	@GetMapping("/displayShop")
	public ResponseEntity<?> displayAllShops() throws ApplicationException {
		return new ResponseEntity<ResponseBody<List<ShopDTO>>>(new ResponseBody<List<ShopDTO>>(
				modelMapper.map(shopService.displayAllShops(), new TypeToken<List<ShopDTO>>() {
				}.getType()), null, "Shop List Found", true), HttpStatus.OK);
	}

	@PutMapping("/updateShop/{shopId}/{name}")
	public ResponseEntity<?> updateWatchPrice(@PathVariable int shopId, @PathVariable String name)
			throws ApplicationException {

		return new ResponseEntity<ResponseBody<ShopDTO>>(
				new ResponseBody<ShopDTO>(modelMapper.map(shopService.updateShop(name, shopId), ShopDTO.class), null,
						"shop name Updated Successfully", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/deleteShop/{shopId}")
	public ResponseEntity<?> deleteShop(@PathVariable int shopId) throws ApplicationException {
		shopService.deleteShop(shopId);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "Shop Successfuly Deleted", true), HttpStatus.OK);
	}
}
