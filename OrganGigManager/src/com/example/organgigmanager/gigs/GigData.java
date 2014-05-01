/**
 * 
 */
package com.example.organgigmanager.gigs;


/**
 * @author klavi
 *
 */
public interface GigData {

	long getDate();
	void setDate(long date);

	String getLocation();
	void setLocation(String location);

	String getIssue();
	void setIssue(String issue);

	boolean isBillMet();
	void setBillMet(boolean isBillMet);

	boolean isInvoiceRequired();
	void setInvoiceRequired(boolean isInvoiceRequired);
}
