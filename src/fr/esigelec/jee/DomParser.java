package fr.esigelec.jee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public String conversionPrix(String valeur) {
		String valeurconvert = "";
		for(int i=0; i<4; i++) {
			if(i==0) {
				String s = String.valueOf(valeur.charAt(i));
				valeurconvert = valeurconvert.concat(s);
				valeurconvert = valeurconvert.concat(".");
			}
			else {
				String s = String.valueOf(valeur.charAt(i));
				valeurconvert = valeurconvert.concat(s);
			}
		}
		return valeurconvert;
	}
	
	public String stationsLaPlusProche(double latitude1, double longitude1){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
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
	
	public String stationLaNEmePlusProche(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
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
	
	public String stationKmLaNEmePlusProche(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					String latitude = pdv.getAttribute("latitude");
					String longitude = pdv.getAttribute("longitude");
					if(latitude.length()==7&&longitude.length()==6) {
					double latitude2 = stringToDoubleLatitude(latitude);
					double longitude2 = stringToDoubleLongitude(longitude);
					double d = (double) Math.round(A.distance(latitude1, longitude1, latitude2, longitude2)*100)/100;
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
	
	public ArrayList<String> stationCpTypeAdrVil(String id){
		ArrayList<String> ListeInformations = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						String cp = pdv.getAttribute("cp");
						String type = pdv.getAttribute("pop");
						ListeInformations.add(cp);
						if(type.equals("A")) {
							ListeInformations.add("Station service d'autoroute");
						}
						else {
							ListeInformations.add("Station service de route");
						}
						ListeInformations.add(cp);
						NodeList infosList = pdv.getChildNodes();
						for(int j=0;j<infosList.getLength();j++) {
							Node p2 = infosList.item(j);
							if(p2.getNodeType()==Node.ELEMENT_NODE) {
								Element infos = (Element) p2;
								if(infos.getTagName().equals("adresse")) {
									ListeInformations.add(infos.getTextContent());
									
								}
								if(infos.getTagName().equals("ville")) {
									ListeInformations.add(infos.getTextContent());
								}
							}
						
					}
					
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
		return ListeInformations;
		
	}
	
	public ArrayList<String> stationServices(String id){
		ArrayList<String> ListeServices = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList infosList = pdv.getChildNodes();
						for(int j=0;j<infosList.getLength();j++) {
							Node p2 = infosList.item(j);
							if(p2.getNodeType()==Node.ELEMENT_NODE) {
								Element infos = (Element) p2;
								if(infos.getTagName().equals("services")) {
									NodeList servicesList = infos.getChildNodes();
									for(int k=0;k<servicesList.getLength();k++) {
										Node p3 = servicesList.item(k);
										if(p3.getNodeType()==Node.ELEMENT_NODE) {
											Element services = (Element) p3;
											ListeServices.add(services.getTextContent());
										}	
									}
									
								}
							}
						
					}
					
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
		return ListeServices;
		
	}
	
	public ArrayList<String> stationPrix(String id){
		
		ArrayList<String> ListePrix = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList prixList = pdv.getElementsByTagName("prix");
						System.out.println(prixList.getLength());
						for(int k=0;k<prixList.getLength();k++) {
							Node p3 = prixList.item(k);
							if(p3.getNodeType()==Node.ELEMENT_NODE) {
								Element prix = (Element) p3;
								String nom = prix.getAttribute("nom");
								String valeur = prix.getAttribute("valeur");
								if(ListePrix.contains(nom)) {
									int index = ListePrix.indexOf(nom);
									ListePrix.remove(index + 1);
									ListePrix.add(index + 1, conversionPrix(valeur));
								}
								else {
									ListePrix.add(nom);
									ListePrix.add(conversionPrix(valeur));
								}
									}	

							}
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
		return ListePrix;
		
	}
	
	public ArrayList<String> stationHorairesDuJour(String id){
		ArrayList<String> ListeHoraires = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList horairesList = pdv.getElementsByTagName("horaires");
							Node p3 = horairesList.item(0);
							if(p3.getNodeType()==Node.ELEMENT_NODE) {
								Element horaires = (Element) p3;
								String automate = horaires.getAttribute("automate-24-24");
								if(automate.equals("1")) {
									NodeList jourList = horaires.getElementsByTagName("jour");
									for(int j=0;j<jourList.getLength();j++) {
										Node p4 = jourList.item(j);
										if(p4.getNodeType()==Node.ELEMENT_NODE) {
											Element jour = (Element) p4;
											String id3 = jour.getAttribute("id");
											if(id3.equals(String.valueOf(Calendar.WEEK_OF_YEAR +1))) {
												NodeList horaireList = pdv.getElementsByTagName("horaire");
												Node p5 = horaireList.item(0);
												if(p5.getNodeType()==Node.ELEMENT_NODE) {
													Element horaire = (Element) p5;
													String ouverture = horaire.getAttribute("ouverture");
													String fermeture = horaire.getAttribute("fermeture");
													ListeHoraires.add(ouverture);
													ListeHoraires.add(fermeture);
													
												}
											}
										}
									}
								}	
								else {
									ListeHoraires.add("Caisses automatiques uniquement");
								}
							}
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
		return ListeHoraires;
		
	}
	
	
	
	public ArrayList<String> stationsFiltres(String distance, int Gazole, int SP95, int SP ){
		ArrayList<String> ListePrix = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\ugose\\eclipse-workspace\\Projet_Station\\Stations.xml");
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList prixList = pdv.getElementsByTagName("prix");
						System.out.println(prixList.getLength());
						for(int k=0;k<prixList.getLength();k++) {
							Node p3 = prixList.item(k);
							if(p3.getNodeType()==Node.ELEMENT_NODE) {
								Element prix = (Element) p3;
								String nom = prix.getAttribute("nom");
								String valeur = prix.getAttribute("valeur");
								if(ListePrix.contains(nom)) {
									int index = ListePrix.indexOf(nom);
									ListePrix.remove(index + 1);
									ListePrix.add(index + 1, valeur);
								}
								else {
									ListePrix.add(nom);
									ListePrix.add(valeur);
								}
									}	

							}
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
		return ListePrix;
		
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
//		System.out.println(A.stationsLaPlusProche(49.5517696, 0.9568256));
//		System.out.println(A.stationLaNEmePlusProche(49.5517696, 0.9568256, 5));
//		System.out.println(A.stationKmLaNEmePlusProche(49.5517696, 0.9568256, 8));
//		System.out.println(A.stationCpTypeAdrVil("1000001"));
//		System.out.println(A.stationServices("1000001"));
//		System.out.println(A.stationPrix("1000001"));
//		String id = "1000004";
//		System.out.println(A.stationHorairesDuJour("1000004"));
//		for(int i=0; i<A.stationServices(id).size(); i++) {
//			System.out.println(A.stationServices(id).get(i));
//		}
		
		
		
	}

}
 