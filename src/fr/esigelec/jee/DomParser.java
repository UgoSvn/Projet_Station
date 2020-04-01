package fr.esigelec.jee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author SEVERIN Ugo et ZOGHEIB Michaël
 *
 */

public class DomParser {
	String lien = "C:\\Users\\Public\\Documents\\StationsServices.xml";
	public DomParser() {
		InputStream input = null;
        ZipInputStream zis = null;
		try {
			FileWriter writer = new FileWriter(lien);  
            BufferedWriter buffer = new BufferedWriter(writer); 
			input = new URL("https://donnees.roulez-eco.fr/opendata/instantane").openStream();
			zis = new ZipInputStream(input);
			zis.getNextEntry();
			char data;
            StringBuilder ligne = new StringBuilder();
            //Stop when 
            while (!ligne.toString().equals("</pdv_liste>"))
            {
            	data = (char) zis.read();
                if ((data == '\n') )
                {
                	buffer.write(ligne.toString());
                    ligne = new StringBuilder();
                }
                else
                {
                    ligne.append(data);
                }
            }
            buffer.write(ligne.toString());
			buffer.close(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param string
	 * @return un double correspondant à la valeur du string en entré
	 */
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
	/**
	 * 
	 * @param string
	 * @return un double correspondant à la valeur du string en entré
	 */
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
	/**
	 * 
	 * @param valeur
	 * @return un String correspondant au prix dans un format utilisable
	 */
	public String conversionPrix(String valeur) {
		String valeurconvert = "";
		for(int i=0; i<valeur.length(); i++) {
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
	/**
	 * 
	 * @param latitude1
	 * @param longitude1
	 * @return un String correspondant à l'id de la station service la plus proche
	 */
	public String stationsLaPlusProche(double latitude1, double longitude1){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
	/**
	 * 
	 * @param latitude1
	 * @param longitude1
	 * @param n
	 * @param km
	 * @return une ArrayList<String> correspondant aux n stations les plus proches avec la distance les séparant de la position
	 */
	public ArrayList<String> stationLaNEmePlusProche(double latitude1, double longitude1, int n, String km){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
		ArrayList<String> ListId = new ArrayList<String>();
		ArrayList<String> ListId2 = new ArrayList<String>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
					double d = (double) Math.round(A.distance(latitude1, longitude1, latitude2, longitude2)*100)/100;
					if(Double.valueOf(km)>d) {
						ListeDouble.add(d);
						ListeDouble2.add(d);
						ListId.add(id);
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
		if(ListeDouble.size()>0) {
			Collections.sort(ListeDouble);
			if(ListId.size()<n) {
				n=ListId.size();
			}
			for(int i=0; i<n; i++) {
				double d2 = ListeDouble.get(i);
				int index = ListeDouble2.indexOf(d2);
				ListId2.add(ListId.get(index));
				ListId2.add(String.valueOf(d2));
			}
			return ListId2;
		}
		else {
			return null;
		}
		
		
		
	}
	/**
	 * 
	 * @param latitude1
	 * @param longitude1
	 * @param n
	 * @return un String correspondant à l'id de la n ème station la plus proche ( cette méthode n'est plus utilisée mais nous a été utile pour des tests)
	 */
	public String stationLaNEmePlusProcheAncienne(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
	
	/**
	 * 
	 * @param latitude1
	 * @param longitude1
	 * @param n
	 * @return un String correspondant au String à la distance de la n eme station la plus proche
	 */
	public String stationKmLaNEmePlusProche(double latitude1, double longitude1, int n){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
	/**
	 * 
	 * @param id
	 * @return une ArrayList<String> correspondant à une liste contenant le code postal, le type, l'adresse et la ville de la station 
	 */
	public ArrayList<String> stationCpTypeAdrVil(String id){
		ArrayList<String> ListeInformations = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
	/**
	 * 
	 * @param id
	 * @return une ArrayList<String> correspondant à une liste contenant les services d'une station
	 */
	public ArrayList<String> stationServices(String id){
		ArrayList<String> ListeServices = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
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
	/**
	 * 
	 * @param id
	 * @return une ArrayList<String> correspondant à une liste contenant les carburants et leur prix d'une station
	 */
	public ArrayList<String> stationPrix(String id){
		
		ArrayList<String> ListePrix = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList prixList = pdv.getElementsByTagName("prix");
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
	/**
	 * 
	 * @param id
	 * @return une ArrayList<String> correspondant à une liste contenant les horaires du jour actuel de la station
	 */
	public ArrayList<String> stationHorairesDuJour(String id){
		ArrayList<String> ListeHoraires = new ArrayList<String>();	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p1 = pdvList.item(i);
				if(p1.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p1;
					String id2 = pdv.getAttribute("id");
					if(id2.equals(id)) {
						NodeList horairesList = pdv.getElementsByTagName("horaires");
						if(horairesList.getLength()>0) {
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
												if(horaireList.getLength()>0) {
												Node p5 = horaireList.item(0);
												if(p5.getNodeType()==Node.ELEMENT_NODE) {
													Element horaire = (Element) p5;
													String ouverture = horaire.getAttribute("ouverture");
													String fermeture = horaire.getAttribute("fermeture");
													ListeHoraires.add(ouverture);
													ListeHoraires.add(fermeture);
													
												}
											}else {
												ListeHoraires.add("Caisses automatiques uniquement");
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
							else {
								ListeHoraires.add("Caisses automatiques uniquement");
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
		if(ListeHoraires.size()!=0) {
			return ListeHoraires;
		}
		else {
			ListeHoraires.add("pas d'horaires");
			return ListeHoraires;
		}
		
	}
	
	/**
	 * 
	 * @param latitude1
	 * @param longitude1
	 * @param id
	 * @return un double correspondant à la distance entre  une position et une station service
	 */
	public Double stationKm(double latitude1, double longitude1, String id){
		ArrayList<Double> ListeDouble = new ArrayList<Double>();
		double d = 1000;
		DistanceCalculator A = new DistanceCalculator();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(lien);
			NodeList pdvList = doc.getElementsByTagName("pdv");
			for(int i=0;i<pdvList.getLength();i++) {
				Node p = pdvList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element pdv = (Element) p;
					if(id.equals(pdv.getAttribute("id"))){
						i=pdvList.getLength()-1;
						String latitude = pdv.getAttribute("latitude");
						String longitude = pdv.getAttribute("longitude");
						if(latitude.length()==7&&longitude.length()==6) {
							double latitude2 = stringToDoubleLatitude(latitude);
							double longitude2 = stringToDoubleLongitude(longitude);
							d = (double) Math.round(A.distance(latitude1, longitude1, latitude2, longitude2)*100)/100;
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
		return d;
		
	}
	/**
	 * 
	 * @param n
	 * @param distance
	 * @param type1
	 * @param type2
	 * @param Gazole
	 * @param SP95
	 * @param SP98
	 * @param GPLc
	 * @param E10
	 * @param E85
	 * @param resto
	 * @param toil
	 * @param bar
	 * @param bout
	 * @param stat
	 * @param dab
	 * @param lav
	 * @param latitude
	 * @param longitude
	 * @return une ArrayList<String> au n stations services les plus proches correspondantes aux filtres établis 
	 */
	public ArrayList<String> stationsFiltresNEmePlusProche(int n, String distance, int type1, int type2, int Gazole, int SP95, int SP98, int GPLc, int E10, int E85, int resto, int toil, int bar, int bout, int stat, int dab, int lav, double latitude, double longitude){
			ArrayList<Double> ListKm = new ArrayList<Double>();
			ArrayList<Double> ListKm2 = new ArrayList<Double>();
			ArrayList<String> ListId = new ArrayList<String>();
			ArrayList<String> ListIdBis = new ArrayList<String>();
			ArrayList<String> ListId2 = new ArrayList<String>();
			ArrayList<String> ListServices = new ArrayList<String>();
			ArrayList<String> ListPrix = new ArrayList<String>();
			ArrayList<String> ListType = new ArrayList<String>();
			DistanceCalculator A = new DistanceCalculator();
			ArrayList<Double> ListeDouble = new ArrayList<Double>();
			ArrayList<Double> ListeDouble2 = new ArrayList<Double>();
			double d = 0;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(lien);
				NodeList pdvList = doc.getElementsByTagName("pdv");
				for(int i=0;i<pdvList.getLength();i++) {
					Node p = pdvList.item(i);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						Element pdv = (Element) p;
						String id = pdv.getAttribute("id");
						String latitude1 = pdv.getAttribute("latitude");
						String longitude1 = pdv.getAttribute("longitude");
						if(latitude1.length()==7&&longitude1.length()==6) {
							double latitude2 = stringToDoubleLatitude(latitude1);
							double longitude2 = stringToDoubleLongitude(longitude1);
							
							d = A.distance(latitude, longitude, latitude2, longitude2);
							
							if(d<=Double.valueOf(distance)) {
								d = (double) Math.round(d*100)/100;

								ListKm.add(d);
								ListKm2.add(d);
								ListIdBis.add(id);
							}
							
						}
						
						
					}
				}
				Collections.sort(ListKm);
				for(int i=0; i<ListIdBis.size();i++) {
					double d2 = ListKm.get(i);
					int index = ListKm2.indexOf(d2);
					ListId.add(ListIdBis.get(index));
					
				}
				ListIdBis.clear();
				ListKm2.clear();
				
				
				if(ListId.size()!=0) {
					
				for(int i =0; i<ListId.size(); i ++) {
					int k=0;
					if(i>-1&&i<ListId.size()) {
						ListPrix = stationPrix(ListId.get(i));
						}
					if(i>-1&&i<ListId.size()&&Gazole==1&&k==0) {
						if(!(ListPrix.contains("Gazole"))) {
							
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&SP95==1&&k==0) {
						if(!(ListPrix.contains("SP95"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&SP98==1&&k==0) {
						if(!(ListPrix.contains("SP98"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&GPLc==1&&k==0) {
						if(!(ListPrix.contains("GPLc"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&E10==1&&k==0) {
						if(!(ListPrix.contains("E10"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&E85==1&&k==0) {
						if(!(ListPrix.contains("E85"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(k==0) {
						ListServices = stationServices(ListId.get(i));
					if(i>-1&&i<ListId.size()&&resto==1&&k==0) {
						if(!(ListServices.contains("Restauration à emporter"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&toil==1&&k==0) {
						if(!(ListServices.contains("Toilettes publiques"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&dab==1&&k==0) {
						if(!(ListServices.contains("DAB (Distributeur automatique de billets)"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&bout==1&&k==0) {
						if(!(ListServices.contains("Boutique alimentaire"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&bar==1&&k==0) {
						if(!(ListServices.contains("Bar"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&stat==1&&k==0) {
						if(!(ListServices.contains("Station de gonflage"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
					if(i>-1&&i<ListId.size()&&lav==1&&k==0) {
						if(!(ListServices.contains("Lavage automatique"))) {
							ListId.remove(i);
							ListKm.remove(i);
							k=1;
						}
					}
				}
				if(k==0) {
						ListType = stationCpTypeAdrVil(ListId.get(i));
						if(i>-1&&i<ListId.size()&&type1==1&&k==0) {
							if(!(ListType.contains("Station service d'autoroute"))) {
								ListId.remove(i);
								ListKm.remove(i);
								k=1;
							}
						}
						if(i>-1&&i<ListId.size()&&type2==1&&k==0) {
							if(!(ListType.contains("Station service de route"))) {
								ListId.remove(i);
								ListKm.remove(i);
								k=1;
							}
						}	
				}
					if(k==1) {
						i--;
					}
					else {
						ListIdBis.add(ListId.get(i));
						ListKm2.add(ListKm.get(i));
						if(ListIdBis.size()==n) {
							for(int j=0;j<n;j++) {
								ListId2.add(ListIdBis.get(j));
								ListId2.add(String.valueOf(ListKm2.get(j)));
							}
							return ListId2;
						}
						
						
				}
				
				}
				}
				for(int j=0; j<ListKm.size();j++) {
					ListeDouble.add(ListKm.get(j));
					ListeDouble2.add(ListKm.get(j));
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
			if(ListeDouble.size()==0) {
				return ListId2;
			}
			else {
				if(ListId.size()<n) {
					n=ListId.size();
				}
				for(int i=0; i<n; i++) {
					double d2 = ListeDouble.get(i);
					int index = ListeDouble2.indexOf(d2);
					ListId2.add(ListId.get(index));
					ListId2.add(String.valueOf(d2));
				}
				return ListId2;
			}
			
			
			
		}


}
 