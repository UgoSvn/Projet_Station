package fr.esigelec.jee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {
	
	public double stringToDoubleLatitude(String string) {
		String string2="";
		for(int i=0; i<7; i++) {
			if(i==1) {
				String s = String.valueOf(string.charAt(i));
				string2 = string2.concat(s);
				string2 = string2.concat(".");
			}
			else {
				String s = String.valueOf(string.charAt(i));
				string2 = string2.concat(s);
			}
		}
		return Double.valueOf(string2);
	}
	public double stringToDoubleLongitude(String string) {
		String string2="";
		for(int i=0; i<6; i++) {
			if(i==0) {
				String s = String.valueOf(string.charAt(i));
				string2 = string2.concat(s);
				string2 = string2.concat(".");
			}
			else {
				String s = String.valueOf(string.charAt(i));
				string2 = string2.concat(s);
			}
		}
		return Double.valueOf(string2);
	}
	
	public String stationsLaPlusProche(double latitude1, double longitude1){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					String latitude = pdv.getAttribute("latitude");
					String longitude = pdv.getAttribute("longitude");
					String id = pdv.getAttribute("id");
					if(latitude.length()==7&&longitude.length()==6) {
					double latitude2 = stringToDoubleLatitude(latitude);
					double longitude2 = stringToDoubleLongitude(longitude);
					double d = A.distance(latitude1, longitude1, latitude2, longitude2);
					ListeDouble.add(d);
					ListeDouble2.add(d);
					ListId.add(id);
					
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(ListeDouble);
		double d2 = ListeDouble.get(0);
		int index = ListeDouble2.indexOf(d2);
		return ListId.get(index);
		
		
	}
	
	public String stationLaNèmePlusProche(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					String latitude = pdv.getAttribute("latitude");
					String longitude = pdv.getAttribute("longitude");
					String id = pdv.getAttribute("id");
					if(latitude.length()==7&&longitude.length()==6) {
					double latitude2 = stringToDoubleLatitude(latitude);
					double longitude2 = stringToDoubleLongitude(longitude);
					double d = A.distance(latitude1, longitude1, latitude2, longitude2);
					ListeDouble.add(d);
					ListeDouble2.add(d);
					ListId.add(id);
					
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(ListeDouble);
		double d2 = ListeDouble.get(n-1);
		int index = ListeDouble2.indexOf(d2);
		return ListId.get(index);
		
		
	}
	
	public String stationKmLaNèmePlusProche(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					String latitude = pdv.getAttribute("latitude");
					String longitude = pdv.getAttribute("longitude");
					String id = pdv.getAttribute("id");
					if(latitude.length()==7&&longitude.length()==6) {
					double latitude2 = stringToDoubleLatitude(latitude);
					double longitude2 = stringToDoubleLongitude(longitude);
					double d = A.distance(latitude1, longitude1, latitude2, longitude2);
					ListeDouble.add(d);
					
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(ListeDouble);
		return String.valueOf(ListeDouble.get(n-1));
		
	}

	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\JavaJee/Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					String id = pdv.getAttribute("id");
					System.out.println(id);
					
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/			
		DomParser A = new DomParser();
//		System.out.println(A.stringToDoubleLatitude("4620114"));
//		System.out.println(A.stringToDoubleLongitude("462011145"));
		System.out.println(A.stationsLaPlusProche(49.5517696, 0.9568256));
		System.out.println(A.stationLaNèmePlusProche(49.5517696, 0.9568256, 5));
		System.out.println("1");
		
		
	}

}
 