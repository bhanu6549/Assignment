package com.mindtree.comicapp.service.serivceimplementation;

import java.util.Set;

import com.mindtree.comicapp.dao.ComicAppDaoService;
import com.mindtree.comicapp.dao.daoimplementation.ComicAppDaoServiceImplemantation;
import com.mindtree.comicapp.entity.SuperHero;
import com.mindtree.comicapp.entity.Univers;
import com.mindtree.comicapp.exception.dao.ComicAppDaoException;
import com.mindtree.comicapp.exception.service.ComicAppServiceException;
import com.mindtree.comicapp.exception.service.custom.SuperHeroAlreadyExistsException;
import com.mindtree.comicapp.exception.service.custom.SuperHeroNotFoundException;
import com.mindtree.comicapp.exception.service.custom.UniverAlreadyExistsException;
import com.mindtree.comicapp.exception.service.custom.UniversNotFoundException;
import com.mindtree.comicapp.service.ComicAppService;

public class ComicAppServiceImpl implements ComicAppService {

	ComicAppDaoService comicAppDaoService = new ComicAppDaoServiceImplemantation();

	@Override
	public String addUnivers(Univers univers) throws ComicAppServiceException {
		String mString = null;

		try {
			if (comicAppDaoService.validateUnivers(univers)) {
				try {
					mString = comicAppDaoService.addUniversToDB(univers);
				} catch (ComicAppDaoException e) {
					throw new ComicAppServiceException(e.getMessage(), e);
				}

				return mString;
			} else {
				throw new UniverAlreadyExistsException("Univers Already Exists !!!");
			}
		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public String addSuperHero(SuperHero superHero) throws ComicAppServiceException {

		String mString = null;

		try {
			if (comicAppDaoService.validateSuperHero(superHero.getSuperHeroName())) {

				try {
					mString = comicAppDaoService.addSuperHeroToDB(superHero);
				} catch (ComicAppDaoException e) {
					throw new ComicAppServiceException(e.getMessage(), e);
				}

				return mString;
			} else {
				throw new SuperHeroAlreadyExistsException("Super Hero Already Exists !!!");
			}
		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public String assignSuperHeroToUnivers(String spName, long universId) throws ComicAppServiceException {
		String mString = null;

		try {
			if (!comicAppDaoService.validateSuperHero(spName)) {
				if (comicAppDaoService.validateUnivers(universId)) {
					try {
						mString = comicAppDaoService.assignSuperHeroToUniversInDB(spName, universId);
					} catch (ComicAppDaoException e) {
						throw new ComicAppServiceException(e.getMessage(), e);
					}
					return mString;
				} else {
					throw new UniversNotFoundException("Univers Not Found !!!");
				}
			} else {
				throw new SuperHeroNotFoundException("Super Hero Not Found !!!");
			}
		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);

		}

	}

	@Override
	public Set<SuperHero> displaySuperHeroByUniversName(String universName1) throws ComicAppServiceException {

		long universId = 0;
		Set<SuperHero> superHerolist;
		try {
			universId = comicAppDaoService.getUniversId(universName1);

			if (universId == 0) {
				throw new UniversNotFoundException("Universe Not Found");
			} else {
				superHerolist = comicAppDaoService.getSuperHeroByUniversName(universId);

				if (superHerolist == null)
					throw new SuperHeroNotFoundException("Super Hero not found in " + universName1 + " !!!");

				return superHerolist;
			}

		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);

		}

	}

	@Override
	public String updateSuperHeroHP(String sname, long hp1) throws ComicAppServiceException {

		try {
			if (!comicAppDaoService.validateSuperHero(sname)) {

				String mString = comicAppDaoService.updateSuperHeroHpInDB(sname, hp1);

				return mString;
			} else {
				throw new SuperHeroNotFoundException("Super Hero Not Found !!!");
			}
		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);

		}

	}

	@Override
	public SuperHero displaySuperHeroWithMaxHpByUniversName(String universName2) throws ComicAppServiceException {

		long universId = 0;
		SuperHero superHero ;
		try {
			universId = comicAppDaoService.getUniversId(universName2);

			if (universId == 0) {
				throw new UniversNotFoundException("Universe Not Found");
			} else {
				superHero = comicAppDaoService.getSuperHeroWithMaxHpByUniversName(universId);

				if (superHero == null)
					throw new SuperHeroNotFoundException("Super Hero not found in " + universName2 + " !!!");

				return superHero;
			}

		} catch (ComicAppDaoException e) {
			throw new ComicAppServiceException(e.getMessage(), e);

		}
		
	}

}
