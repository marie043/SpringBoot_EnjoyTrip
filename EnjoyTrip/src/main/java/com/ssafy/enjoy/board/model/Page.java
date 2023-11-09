package com.ssafy.enjoy.board.model;

public class Page {
	private int pgno;
	private String key;
	private String word;
	public int getPgno() {
		return pgno;
	}
	public void setPgno(int pgno) {
		this.pgno = pgno;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	@Override
	public String toString() {
		return "Page [pgno=" + pgno + ", key=" + key + ", word=" + word + "]";
	}
	public void setWord(String word) {
		this.word = word;
	}
}	
