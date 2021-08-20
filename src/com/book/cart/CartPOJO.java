package com.book.cart;

public class CartPOJO {
private String ISBN13;
private String EMAIL;
private String TITLE;

private String  IMAGEAPIPATH;
private int PRICE;
private int qty;
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}

public String getEMAIL() {
	return EMAIL;
}
public String getTITLE() {
	return TITLE;
}
public String getISBN13() {
	return ISBN13;
}
public String getIMAGEAPIPATH() {
	return IMAGEAPIPATH;
}
public int getPRICE() {
	return PRICE;
}

public void setEMAIL(String eMAIL) {
	EMAIL = eMAIL;
}
public void setTITLE(String tITLE) {
	TITLE = tITLE;
}
public void setISBN13(String iSBN13) {
	ISBN13 = iSBN13;
}
public void setIMAGEAPIPATH(String iMAGEAPIPATH) {
	IMAGEAPIPATH = iMAGEAPIPATH;
}
public void setPRICE(int pRICE) {
	PRICE = pRICE;
}


}
