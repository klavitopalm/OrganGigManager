/**
 * 
 */
package com.example.organgigmanager.gigs;

import java.util.Date;

/**
 * @author klavi
 *
 */
public interface GigData {

	Date getDate();
	void setDate(Date date);

	String getLocation();
	void setLocation(String location);

	String getIssue();
	void setIssue(String issue);

	boolean isBillMet();
	void setBillMet(boolean isBillMet);

	boolean isInvoiceRequired();
	void setInvoiceRequired(boolean isInvoiceRequired);
}
