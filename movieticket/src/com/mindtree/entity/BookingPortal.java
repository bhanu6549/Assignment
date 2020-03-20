package com.mindtree.entity;

public class BookingPortal {
	private int portalId;
	private String portalName;
	public BookingPortal(int portalId, String portalName) {
		super();
		this.portalId = portalId;
		this.portalName = portalName;
	}
	public BookingPortal() {
		
	}
	public int getPortalId() {
		return portalId;
	}
	public void setPortalId(int portalId) {
		this.portalId = portalId;
	}
	public String getPortalName() {
		return portalName;
	}
	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}
	@Override
	public String toString() {
		return "BookingPortal [portalId=" + portalId + ", portalName=" + portalName + "]";
	}
	
	
	


}
