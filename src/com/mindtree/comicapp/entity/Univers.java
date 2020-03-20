package com.mindtree.comicapp.entity;

import java.util.Set;

public class Univers {
	
	private long universId;
	private String universName;
	
	private Set<SuperHero> superHeroList;

	public Univers() {
		// TODO Auto-generated constructor stub
	}

	public Univers(long universId, String universName, Set<SuperHero> superHeroList) {
		this.universId = universId;
		this.universName = universName;
		this.superHeroList = superHeroList;
	}

	public long getUniversId() {
		return universId;
	}

	public void setUniversId(long universId) {
		this.universId = universId;
	}

	public String getUniversName() {
		return universName;
	}

	public void setUniversName(String universName) {
		this.universName = universName;
	}

	public Set<SuperHero> getSuperHeroList() {
		return superHeroList;
	}

	public void setSuperHeroList(Set<SuperHero> superHeroList) {
		this.superHeroList = superHeroList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((superHeroList == null) ? 0 : superHeroList.hashCode());
		result = prime * result + (int) (universId ^ (universId >>> 32));
		result = prime * result + ((universName == null) ? 0 : universName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Univers other = (Univers) obj;
		if (superHeroList == null) {
			if (other.superHeroList != null)
				return false;
		} else if (!superHeroList.equals(other.superHeroList))
			return false;
		if (universId != other.universId)
			return false;
		if (universName == null) {
			if (other.universName != null)
				return false;
		} else if (!universName.equals(other.universName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Univers [universId=" + universId + ", universName=" + universName + ", superHeroList=" + superHeroList
				+ "]";
	}

	
	
	
	
	

}
