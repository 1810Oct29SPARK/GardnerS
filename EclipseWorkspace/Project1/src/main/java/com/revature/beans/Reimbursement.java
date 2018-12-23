package com.revature.beans;

import java.sql.Blob;

public class Reimbursement {

	public int rId;
	public int eId;
	public String status;
	public String description;
	public String amount;
	public Blob pic;

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", eId=" + eId + ", status=" + status + ", description=" + description
				+ ", amount=" + amount + ", pic=" + pic + "]";
	}

	public Reimbursement(int rId, int eId, String status, String description, String amount, Blob pic) {
		super();
		this.rId = rId;
		this.eId = eId;
		this.status = status;
		this.description = description;
		this.amount = amount;
		this.pic = pic;
	}
	
}
