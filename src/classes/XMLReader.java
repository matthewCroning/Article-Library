package classes;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReader {
	
	final static String XML_FILE_NAME = "C:\\Users\\Matth\\ArticleLibrary\\ArticleLibrary\\resources\\dataset.xml";
	
	ArrayList<Article> articles = new ArrayList<Article>();

    public static void main(String[] args) {
       XMLReader xml = new XMLReader();
    }
    
	 public XMLReader(){
		 try {
			 System.out.println(System.getProperty("user.dir"));
			 
			 File currentDirFile = new File(".");
			 String helper = currentDirFile.getAbsolutePath();
			 String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
			 System.out.println(currentDir);
				File fXmlFile = new File(XML_FILE_NAME);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("row");
						
				System.out.println("----------------------------");
				System.out.println(nList.getLength());
				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					//System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String id = eElement.getAttribute("_id");
						if(id.equals("")) {
							id = "0";
						}
						String headline = eElement.getElementsByTagName("headline").item(0).getTextContent();
						String agency = eElement.getElementsByTagName("agency").item(0).getTextContent();
						String date = eElement.getElementsByTagName("publish_date").item(0).getTextContent();
						String city = eElement.getElementsByTagName("city").item(0).getTextContent();
						String content = eElement.getElementsByTagName("content").item(0).getTextContent();
						Article newArticle = new Article(id, headline, agency, date, city, content);
						articles.add(newArticle);
					}
					
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			  
	
	 }
	 
	 public ArrayList<Article> getArticles(){
		 return articles;
	 }
	 
	 public void sortById(){
		 IdCompare idCompare = new IdCompare(); 
	     Collections.sort(articles, idCompare); 
	 }
	 
	 public void sortByAgency() {
		 AgencyCompare agencyCompare = new AgencyCompare();
		 Collections.sort(articles, agencyCompare);
	 }
	 
	 public void sortByHeadline() {
		 HeadlineCompare headlineCompare = new HeadlineCompare();
		 Collections.sort(articles, headlineCompare);
	 }
	 
	 public Article getArticleById(String id) {
		 int i = 0;
			while (i < articles.size()) {
				if(articles.get(i).getId().equals(id)) {
					System.out.println(articles.get(i).getHeadline());
					return articles.get(i);
				}
				i++;
			}
			return null;
	 }
	 
    public ArrayList<Article> getFilteredArticles(String id, String headline, String agency, String date, String city, String content){
    	ArrayList<Article> filteredArticles = new ArrayList<Article>();
    	ArrayList<Article> removeArticles = new ArrayList<Article>();
    	
    	filteredArticles = articles;

         
         filteredArticles.forEach((article) -> {
 			System.out.println(article);
 			String line = article.getId();
            String word = id;
 			String pattern = "(.*)" + word + "(.*)";
 		    Pattern r = Pattern.compile(pattern);
 		    Matcher m = r.matcher(line);
 	         if (m.find()) {
 	         }else {
 	            removeArticles.add(article);
 	         }
  		});
         filteredArticles.removeAll(removeArticles);
         
        
         filteredArticles.forEach((article) -> {
  			System.out.println(article);
  			String line = article.getAgency();
            String word = agency;
  			String pattern = "(.*)" + word + "(.*)";
  		    Pattern r = Pattern.compile(pattern);
  		    Matcher m = r.matcher(line);
  	         if (m.find()) {
  	         }else {
  	            removeArticles.add(article);
  	         }
   		});
          filteredArticles.removeAll(removeArticles);
      
          filteredArticles.forEach((article) -> {
    			System.out.println(article);
    			String line = article.getHeadline();
              String word = headline;
    			String pattern = "(.*)" + word + "(.*)";
    		    Pattern r = Pattern.compile(pattern);
    		    Matcher m = r.matcher(line);
    	         if (m.find()) {
    	         }else {
    	            removeArticles.add(article);
    	         }
     		});
            filteredArticles.removeAll(removeArticles);
        
            filteredArticles.forEach((article) -> {
      			System.out.println(article);
      			String line = article.getDate();
                String word = date;
      			String pattern = "(.*)" + word + "(.*)";
      		    Pattern r = Pattern.compile(pattern);
      		    Matcher m = r.matcher(line);
      	         if (m.find()) {
      	         }else {
      	            removeArticles.add(article);
      	         }
       		});
              filteredArticles.removeAll(removeArticles);
          
              filteredArticles.forEach((article) -> {
        			System.out.println(article);
        			String line = article.getCity();
                  String word = city;
        			String pattern = "(.*)" + word + "(.*)";
        		    Pattern r = Pattern.compile(pattern);
        		    Matcher m = r.matcher(line);
        	         if (m.find()) {
        	         }else {
        	            removeArticles.add(article);
        	         }
         		});
                filteredArticles.removeAll(removeArticles);
            
                filteredArticles.forEach((article) -> {
          			System.out.println(article);
          			String line = article.getContent();
                    String word = content;
          			String pattern = "(.*)" + word + "(.*)";
          		    Pattern r = Pattern.compile(pattern);
          		    Matcher m = r.matcher(line);
          	         if (m.find()) {
          	         }else {
          	            removeArticles.add(article);
          	         }
           		});
                  filteredArticles.removeAll(removeArticles);
              
         return filteredArticles;
    	
	}
    
   
}

class IdCompare implements Comparator<Article> 
{ 
    public int compare(Article a1, Article a2) 
    { 
        if ( extractInt(a1.getId()) < extractInt( a2.getId())) return -1; 
        if ( extractInt(a1.getId()) >  extractInt(a2.getId())) return 1; 
        else return 0; 
    }
    
    int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        // return 0 if no digits found
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }
}

class AgencyCompare implements Comparator<Article> 
{ 
    public int compare(Article a1, Article a2) 
    { 
    	return a1.getAgency().compareTo(a2.getAgency()); 
    }
} 

class HeadlineCompare implements Comparator<Article> 
{ 
    public int compare(Article a1, Article a2) 
    { 
    	return a1.getHeadline().compareTo(a2.getHeadline()); 
    }
} 
