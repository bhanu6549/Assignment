package com.mindtree.comicapp.service;

import java.util.Set;

import com.mindtree.comicapp.entity.SuperHero;
import com.mindtree.comicapp.entity.Univers;
import com.mindtree.comicapp.exception.dao.ComicAppDaoException;
import com.mindtree.comicapp.exception.service.ComicAppServiceException;

public interface ComicAppService {

	public String addUnivers(Univers univers) throws ComicAppServiceException;

	public String addSuperHero(SuperHero superHero) throws ComicAppServiceException;

	public String assignSuperHeroToUnivers(String spName, long universId) throws ComicAppServiceException;

	public Set<SuperHero> displaySuperHeroByUniversName(String universName1) throws ComicAppServiceException;

	public String updateSuperHeroHP(String sname, long hp1) throws ComicAppServiceException;

	public SuperHero displaySuperHeroWithMaxHpByUniversName(String universName2) throws ComicAppServiceException;

}
