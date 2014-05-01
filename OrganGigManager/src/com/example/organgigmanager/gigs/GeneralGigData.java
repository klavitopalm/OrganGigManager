package com.example.organgigmanager.gigs;


public class GeneralGigData implements GigData {
	private long date = System.currentTimeMillis();
	private String location;
	private String issue;
	private boolean isBillMet;
	private boolean isInvoiceRequired;

	@Override
	public long getDate() {
		return date;
	}

	@Override
	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getIssue() {
		return issue;
	}

	@Override
	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public boolean isBillMet() {
		return isBillMet;
	}

	@Override
	public void setBillMet(boolean isBillMet) {
		this.isBillMet = isBillMet;

	}

	@Override
	public boolean isInvoiceRequired() {
		return isInvoiceRequired;
	}

	@Override
	public void setInvoiceRequired(boolean isInvoiceRequired) {
		this.isInvoiceRequired = isInvoiceRequired;
	}

}
