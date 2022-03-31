package com.stefanosilva.bibliaonline.dto;

import java.util.List;

public class ListCharpterDTO {
   private BookDTO book;
   private List<Integer> charpters;
   
   public ListCharpterDTO() {}

public ListCharpterDTO(BookDTO book, List<Integer> charpters) {
	super();
	this.book = book;
	this.charpters = charpters;
}

public BookDTO getBook() {
	return book;
}

public void setBook(BookDTO book) {
	this.book = book;
}

public List<Integer> getCharpters() {
	return charpters;
}

public void setCharpters(List<Integer> charpters) {
	this.charpters = charpters;
}
   
}
