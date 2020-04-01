<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    import="fr.esigelec.jee.*"
    import="java.util.ArrayList"
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale1=1, shrink-to-fit=no>
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Liste des stations</title>
	
	 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans+Condensed:300&display=swap" rel="stylesheet">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/8fc4291567.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Teko:700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	
	<!-- Style sheet CSS -->
	<link rel="stylesheet" type="text/css" href="css/list.css" />
	<%int type1=0; %>
	<%String[] c1l1 = request.getParameterValues("c1l1");
					 
					if (c1l1 == null) {
					    // no checkboxes selected
					    System.out.println (" SSA Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c1l1.length; ++i) {   
					        System.out.println ("SSA Cochee ");// cochée 
					        type1=1;
					    }
					} 
					System.out.println(type1);%>
	<%int type2=0; %>
	<%String[] c1l2 = request.getParameterValues("c1l2");
					 
					if (c1l2 == null) {
					    // no checkboxes selected
					    System.out.println (" SSR Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c1l2.length; ++i) {   
					        System.out.println ("SSR Cochee ");// cochée 
					        type2=1;
					    }
					} 
					System.out.println(type2);%>
	<%if(type1 == 1 && type2 == 1){
		type1=0;
		type2=0;
	}%>
	}
	<%int Gazole=0; %>
	<%String[] c2l1 = request.getParameterValues("c2l1");
					 
					if (c2l1 == null) {
					    // no checkboxes selected
					    System.out.println (" Gazole Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l1.length; ++i) {   
					        System.out.println ("Gazole Cochee ");// cochée 
					        Gazole=1;
					    }
					} 
					System.out.println(Gazole);%>
	<%int SP95=0; %>
	<%String[] c2l2 = request.getParameterValues("c2l2");
					 
					if (c2l2 == null) {
					    // no checkboxes selected
					    System.out.println (" SP95 Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l2.length; ++i) {   
					        System.out.println ("SP95 Cochee ");// cochée 
					        SP95=1;
					    }
					} 
					System.out.println(SP95);%>
	<%int SP98=0; %>
	<%String[] c2l3 = request.getParameterValues("c2l3");
					 
					if (c2l3 == null) {
					    // no checkboxes selected
					    System.out.println (" SP98 Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l3.length; ++i) {   
					        System.out.println ("SP98 Cochee ");// cochée 
					        SP98=1;
					    }
					} 
					System.out.println(SP98);%>
	<%int GPLc=0; %>
	<%String[] c2l4 = request.getParameterValues("c2l4");
					 
					if (c2l4 == null) {
					    // no checkboxes selected
					    System.out.println (" GPLc Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l4.length; ++i) {   
					        System.out.println ("GPLc Cochee ");// cochée 
					        GPLc=1;
					    }
					} 
					System.out.println(GPLc);%>
	<%int E10=0; %>
	<%String[] c2l5 = request.getParameterValues("c2l5");
					 
					if (c2l5 == null) {
					    // no checkboxes selected
					    System.out.println (" E10 Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l5.length; ++i) {   
					        System.out.println ("E10 Cochee ");// cochée 
					        E10=1;
					    }
					} 
					System.out.println(E10);%>
	<%int E85=0; %>
	<%String[] c2l6 = request.getParameterValues("c2l6");
					 
					if (c2l6 == null) {
					    // no checkboxes selected
					    System.out.println (" E85 Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c2l6.length; ++i) {   
					        System.out.println ("E85 Cochee ");// cochée 
					        E85=1;
					    }
					} 
					System.out.println(E85);%>
					
					
					
	<%int resto=0; %>
	<%String[] c3l1 = request.getParameterValues("c3l1");
					 
					if (c3l1 == null) {
					    // no checkboxes selected
					    System.out.println (" Resto Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l1.length; ++i) {   
					        System.out.println ("Resto Cochee ");// cochée 
					        resto=1;
					    }
					} 
					System.out.println(resto);%>
	<%int toil=0; %>
	<%String[] c3l2 = request.getParameterValues("c3l2");
					 
					if (c3l2 == null) {
					    // no checkboxes selected
					    System.out.println (" Toilette Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l2.length; ++i) {   
					        System.out.println ("Toilette Cochee ");// cochée 
					        toil=1;
					    }
					} 
					System.out.println(toil);%>
	<%int bar=0; %>
	<%String[] c3l3 = request.getParameterValues("c3l3");
					 
					if (c3l3 == null) {
					    // no checkboxes selected
					    System.out.println (" Bar Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l3.length; ++i) {   
					        System.out.println ("Bar Cochee ");// cochée 
					        bar=1;
					    }
					} 
					System.out.println(bar);%>
	<%int bout=0; %>
	<%String[] c3l4 = request.getParameterValues("c3l4");
					 
					if (c3l4 == null) {
					    // no checkboxes selected
					    System.out.println (" Boutique Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l4.length; ++i) {   
					        System.out.println ("Boutique Cochee ");// cochée 
					        bout=1;
					    }
					} 
					System.out.println(bout);%>
	<%int stat=0; %>
	<%String[] c3l5 = request.getParameterValues("c3l5");
					 
					if (c3l5 == null) {
					    // no checkboxes selected
					    System.out.println (" Station de gonflage Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l5.length; ++i) {   
					        System.out.println ("Station de gonflage Cochee ");// cochée 
					        stat=1;
					    }
					} 
					System.out.println(stat);%>
	<%int dab=0; %>
	<%String[] c3l6 = request.getParameterValues("c3l6");
					 
					if (c3l6 == null) {
					    // no checkboxes selected
					    System.out.println (" DAB Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l6.length; ++i) {   
					        System.out.println ("DAB Cochee ");// cochée 
					        dab=1;
					    }
					} 
					System.out.println(dab);%>
	<%int lav=0; %>
	<%String[] c3l7 = request.getParameterValues("c3l7");
					 
					if (c3l7 == null) {
					    // no checkboxes selected
					    System.out.println (" Lavage Non Cochée ");// Non cochée 
					} else { 
					    for (int i = 0; i < c3l7.length; ++i) {   
					        System.out.println ("Lavage Cochee ");// cochée 
					        lav=1;
					    }
					} 
					System.out.println(lav);%>
</head>

<body>
	
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-md-12 navbare">
				<!-- NavBar -->
				<div class="my-navebar">
					<nav class="my-navbar navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
						<div class="container">
					  		<a class="navbar-brand" href="#"></a>
					  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					    	<span class="navbar-toggler-icon"></span>
					  	  </button>
					
					  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
					    		<ul class="navbar-nav ml-auto">
					    			<li class="nav-item">
					        			<a class="nav-link" href="AboutUs.jsp">About us</a>
					      			</li>
					      			<li class="nav-item">
					        			<a class="nav-link" href="ApplyMoreFilter.jsp">Apply more filters</a>
					      			</li>
					      			<li class="nav-item">
					        			<a class="nav-link" href="Accueil.jsp">Home</a>
					      			</li>
					    		</ul>
					  		</div>
					  	</div>
					</nav>
				</div>
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-12 titre">
				<br /><br /><br /><br /><br /><br /><h1>FIND A GAZ STATION</h1>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12 soustitre">
				<p>Liste des stations les plus proches de vous</p><br />
			</div>
		</div>
		
		<div class="row">
			<%DomParser a = new DomParser();%>

			<%
			
			double longitude = 0;
			double latitude = 0;
			String paramlat = request.getParameter("lat");
			String paramlong = request.getParameter("long");
			String km = request.getParameter("km");
			String param_n = request.getParameter("nbr");
			int n = Integer.parseInt(param_n);
			longitude = Double.parseDouble(paramlat);
			latitude = Double.parseDouble(paramlong);
			ArrayList<String> liste = a.stationsFiltresNEmePlusProche(n, km, type1, type2, Gazole, SP95, SP98, GPLc, E10, E85, resto, toil, bar, bout, stat, dab, lav, latitude, longitude);
			//ArrayList<String> liste = a.stationLaNEmePlusProche(longitude,latitude,n, km);
			%>
			
			<div class="col-md-1 nothing">
			</div>
			<div class="col-md-2 station1">
				<% n=1; %>
				<br /><br />
				<%if(liste.size()>1) {%>
				<h1>Station 1 situé à <%=liste.get(1) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=1&amp;id=<%=liste.get(0)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="1">Voir</button></a></center>
				<%}
				else{%><br /><br /><br /><br /><br /><br /><br /><%}
				%>
				
			</div>
			<div class="col-md-2 station2">
				<% n=2; %>
				<br /><br />
				<%if(liste.size()>3) {%>
				<h1>Station 2 situé à <%=liste.get(3) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=2&amp;id=<%=liste.get(2)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="2">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station3">
				<% n=3; %>
				<br /><br />
				<%if(liste.size()>5) {%>
				<h1>Station 3 situé à <%=liste.get(5) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=3&amp;id=<%=liste.get(4)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning"id="3">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station4">
				<% n=4; %>
				<br /><br />
				<%if(liste.size()>7) {%>
				<h1>Station 4 situé à <%=liste.get(7) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=4&amp;id=<%=liste.get(6)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="4">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station5">
				<% n=5; %>
				<br /><br />
				<%if(liste.size()>9) {%>
				<h1>Station 5 situé à <%=liste.get(9) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=5&amp;id=<%=liste.get(8)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="5">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-1 nothing">
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-1 nothing">
			</div>
			<div class="col-md-2 station6">
				<% n=6; %>
				<br /><br />
				<%if(liste.size()>11) {%>
				<h1>Station 6 situé à <%=liste.get(11) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=6&amp;id=<%=liste.get(10)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="6">Voir</button></a></center>
				<%}
				else{%><br /><br /><br /><br /><br /><br /><br /><%}
				%>
			</div>
			<div class="col-md-2 station7">
				<% n=7; %>
				<br /><br />
				<%if(liste.size()>13) {%>
				<h1>Station 7 situé à <%=liste.get(13) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=7&amp;id=<%=liste.get(12)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="7">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station8">
				<% n=8; %>
				<br /><br />
				<%if(liste.size()>15) {%>
				<h1>Station 8 situé à <%=liste.get(15) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=8&amp;id=<%=liste.get(14)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="8">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station9">
				<% n=9; %>
				<br /><br />
				<%if(liste.size()>17) {%>
				<h1>Station 9 situé à <%=liste.get(17) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=9&amp;id=<%=liste.get(16)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="9">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station10">
				<% n=10; %>
				<br /><br />
				<%if(liste.size()>19) {%>
				<h1>Station 10 situé à <%=liste.get(19) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=10&amp;id=<%=liste.get(18)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="10">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-1 nothing">
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12 nothing">
				<br />
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 nothing">
				<br /><br /><br />
			</div>
		</div>
		
		<!-- Footer -->
		<footer class="container-fluid">
	        <div class="row justify-content-around align-items-center">
	            <div class="col-12 col-md-4 text-center">
	                <a href="https://www.facebook.com/Page.ESIGELEC/" target="_blank">
	                    <i class="fab fa-facebook"></i>
	                </a>
	                
	                <a href="https://www.instagram.com/esigelec_officiel/?hl=fr" target="_blank">
	                    <i class="fab fa-instagram"></i>
	                </a>
	
	                <a href="https://www.youtube.com/user/ESIGELECIRSEEM" target="_blank">
	                    <i class="fab fa-youtube"></i>
	                </a>
	            </div>
	        </div>
	    </footer>
		
	</div>
	
	
</body>

</html>