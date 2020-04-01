package fr.esigelec.jee;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * 
 * @author SEVERIN Ugo et ZOGHEIB Michaël
 *
 */
public class DistanceCalculator
{
	//Grâce à un calcul nous pouvons déterminer la distance entre deux positions en partant de leurs coordonnées
	/**
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return un double correspondant à la distance entre deux positions en km
	 */
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
			return (dist);
		}
	}
	
}