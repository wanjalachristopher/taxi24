package com.taxi.pojo;

public class InvoiceObj {
 private Double amt;
 private String time;
 private String invoiceNo;
 public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getInvoiceNo() {
	return invoiceNo;
}
public void setInvoiceNo(String invoiceNo) {
	this.invoiceNo = invoiceNo;
}
public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
private String driverName;
public Double getAmt() {
	return amt;
}
public void setAmt(Double amt) {
	this.amt = amt;
} 
}
