package com.lec.java.crawl07;

public class InfoBook {
	private String bookTitle;
	private double price;
	private String url;
	private String imgUrl;
	
	public InfoBook() {}

	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		super();
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return bookTitle + ":" + price + "원, URL: " + url + ", img: " + imgUrl;
	}
}
