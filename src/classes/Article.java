package classes;

import java.util.Comparator;

public class Article implements Comparable<Article>{
	String id;
	String headline;
	String agency;
	String Date;
	String City;
	String Content;
	
	public Article(String id, String headline, String agency, String date, String city, String content){
		this.id = id;
		this.headline = headline;
		this.agency = agency;
		this.Date = date;
		this.City = city;
		this.Content = content;
		
	}
	
	public void printArticle() {
		System.out.println(id);
		System.out.println(headline);
		System.out.println(agency);
		
	}

	public String getDate() {
		return Date;
	}

	public String getCity() {
		return City;
	}

	public String getContent() {
		return Content;
	}

	public String getId() {
		return id;
	}

	public String getHeadline() {
		return headline;
	}

	public String getAgency() {
		return agency;
	}

	@Override
	public int compareTo(Article o) {
		// TODO Auto-generated method stub
		return 0;
	}

}


  