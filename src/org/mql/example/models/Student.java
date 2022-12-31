/**
 * 
 */
package org.mql.example.models;

import org.mql.example.utils.Date;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Student extends Person {
	private Date dateOfSubscription;
	
	public Student(int id) {
		super(id);
	}

	public Date getDateOfSubscription() {
		return dateOfSubscription;
	}
	public void setDateOfSubscription(Date dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	@Override
	public String toString() {
		return "Student [" + getFullName() + " subscribed at " + dateOfSubscription + "]";
	}
}
