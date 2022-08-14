package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import Class.Carre;
import Class.Cercle;
import Class.Cube;
import Class.FormeGeometriques;
import Class.Point;
import Class.Rectangle;
import Class.Sphere;
import Class.TriangleEquilateral;
import Class.TriangleIsocele;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            
		  
		Point point;


		try {
			point=new Point(-5, -5);
			System.out.println(point.afficher());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		
		Point point2=new Point(2,2);
		try {
			System.out.println("\n\n\n");
			System.out.println(point2.afficher());
			System.out.println(" ****** changer abscisse à -10 ******");
			point2.setX(-10);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		
		
		Point point3=new Point(3,3);
		try {
			System.out.print("\n\n\n");
			System.out.print(point3.afficher());
			System.out.print("\n ****** changer ordonnée à -20 ******");
			point3.setY(-20);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("\n"+e);
		}

		
		
		Point point4=new Point(4,4);
		try {
			System.out.print("\n\n\n");
			System.out.print(point4.afficher());
			System.out.print("\n ******  déplacer à (-30,-40) ******");
			point4.deplacer(-30, -40);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("\n"+e);
		}

		

		System.out.print("\n\n\n");
		System.out.print("****** Afficher le dernière point dans la console ******\n");
		System.out.print(point4.afficher());



		try {
			System.out.print("\n\n\n");

			System.out.print("\n ******  Déplacer les point #2 et #3 aux coordonnées (50,60) ******");
			point2.deplacer(new Point(50,60));
			point3.deplacer(new Point(50,60));
			System.out.print("\n"+point2.afficher());
			System.out.print("\n"+point3.afficher());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("\n"+e);
		}
		
		
		

		System.out.print("\n\n\n ******  Comparaison avec == ******");
		
		if(point2==point3) 	System.out.print("\n point2==point3");
		else System.out.print("\n point2 != point3");

		System.out.print("\n rep: non identique car ce sont 2 objets differents ils ne pointent pas vers la meme adresse donc ils ne sont pas egaux ");


		
		
		
		System.out.print("\n\n\n ******  Comparaison avec equal ******");
		
		if(point2.equal(point3)) 	System.out.print("\n point2==point3");
		else System.out.print("\n point2 != point3");

		System.out.print("\n rep: identique car equal est programmer pour verifier si les X et Y sont egaux et non pas les adresses des objs ");

		
		
		
		
		
		System.out.print("\n\n\n"); 
		
		Carre carre=new Carre("carre", new Point(1,6), 4);
		System.out.println(carre.toString());


		Rectangle rectangle=new Rectangle("Rectangle", new Point(8,2),10,12);
		System.out.println(rectangle.toString());

		Cube cube=new Cube("Cube", point4,7);
		System.out.println(cube.toString());


		TriangleIsocele triangleIsocele=new TriangleIsocele("TriangleIsocele", new Point(4,3),8,9);
		System.out.println(triangleIsocele.toString());

		TriangleEquilateral triangleEquilateral=new  TriangleEquilateral("TriangleEquilateral", new Point(1,5),3);
		System.out.println(triangleEquilateral.toString());

		Cercle cercle =new Cercle("cercle",  new Point(21,7),3);
		System.out.println(cercle.toString());

		Sphere sphere =new Sphere("sphere",  new Point(13,3),2);
		System.out.println(sphere.toString());



		//*************** Methode 1 ***************

		System.out.println("\n\n ------------------------ Tableau ----------------------------\n\n");
		
		
		System.out.println("\n\n --------------------- Methode 1 ------------------\n\n");

		//l'ajoute des forme

		FormeGeometriques TableauForme[]= new FormeGeometriques[7];
		TableauForme[0]=carre;
		TableauForme[1]=rectangle;
		TableauForme[2]=cube;
		TableauForme[3]=triangleIsocele;
		TableauForme[4]=triangleEquilateral;
		TableauForme[5]=cercle;
		TableauForme[6]=sphere;

		System.out.println("****** Parcourir ce tableau et afficher dans la console la superficie de chaque élément ******  \n");
		for (Object object : TableauForme) {

			System.out.println(((FormeGeometriques) object).getNom()+" = "+((FormeGeometriques) object).superficie());
		}

		//trie des formes
		System.out.print("\n\n\n"); 
		System.out.println("****** Trie des formes selon la superficie ******  \n");

		Object tmpObject;

		for(int j=1;j<=TableauForme.length;j++) {
			for(int i=0;i<TableauForme.length-1;i++) {
				if ( TableauForme[i].superficie() > TableauForme[i+1].superficie() ) {
					tmpObject = TableauForme[i];
					TableauForme[i] = TableauForme[i+1];
					TableauForme[i+1] = (FormeGeometriques) tmpObject;
				}        
			}}

		for (Object object : TableauForme) {

			System.out.println(((FormeGeometriques) object).getNom()+" = "+((FormeGeometriques) object).superficie());
		}
		
		
		
		System.out.print("\n\n\n"); 
		System.out.println("****** Trie des formes par rapport a la distance avec le point (0,0) ****** \n");
		
		for(int j=1;j<=TableauForme.length;j++) {
			for(int i=0;i<TableauForme.length-1;i++) {
				if (Distance(TableauForme[i]) > Distance(TableauForme[i+1]) ) {
					tmpObject = TableauForme[i];
					TableauForme[i] = TableauForme[i+1];
					TableauForme[i+1] = (FormeGeometriques) tmpObject;
				}        
			}}

		for (Object object : TableauForme) {

			System.out.println(((FormeGeometriques) object).getNom()+" = "+Distance((FormeGeometriques) object));
		}
		
		
		
		

		System.out.print("\n\n\n"); 
		System.out.println("****** contenir que des cubes ou des sphères ****** \n");
		
		FormeGeometriques TableauSC[]= new FormeGeometriques[7];
		
	           int j=0;
	           
			for(int i=0;i<TableauForme.length-1;i++) {
				if (TableauForme[i].getClass().equals(Cube.class) || TableauForme[i].getClass().equals(Sphere.class)) {
					
					TableauSC[j] = TableauForme[i];
					j++;
				}        
			}

		for (Object object : TableauSC) {

			if (object==null) break;
			
			System.out.println(((FormeGeometriques) object).getNom()+" = "+((FormeGeometriques) object).getClass());
		}
		
		
		

		//**************** methode 2 ***************
		
		
		
		System.out.println("\n\n --------------------- Methode 2 ------------------\n\n");
		
		
		//l'ajoute des forme 
		List<Object> liste = new ArrayList<Object>();
		liste.add(carre);
		liste.add(rectangle);
		liste.add(cube);
		liste.add(triangleIsocele);
		liste.add(triangleEquilateral);
		liste.add(cercle);
		liste.add(sphere);

	
		
		//Parcourir ce tableau et afficher dans la console la superficie de chaque élément

		System.out.println("****** Parcourir ce tableau et afficher dans la console la superficie de chaque élément ****** \n");
		liste.forEach(e->System.out.println(((FormeGeometriques) e).getNom()+" = "+((FormeGeometriques) e).superficie()));

		
		
		System.out.print("\n\n\n"); 
		System.out.println("****** Trie des formes selon la superficie ****** \n");
		List<Object> listeTrie = liste.stream()
				.sorted(Comparator.comparing(o -> ((FormeGeometriques) o).superficie()))
				.collect(Collectors.toList());

		listeTrie.forEach(e->System.out.println(((FormeGeometriques) e).getNom()+" = "+((FormeGeometriques) e).superficie()));

		
		
		System.out.print("\n\n\n"); 
		System.out.println("****** Trie des formes par rapport a la distance avec le point (0,0) ****** \n");
		List<Object> listeDistance = liste.stream()
				.sorted(Comparator.comparing(o ->Distance((FormeGeometriques) o)))
				.collect(Collectors.toList());

		listeDistance.forEach(e->System.out.println(((FormeGeometriques) e).getNom()+" = "+Distance((FormeGeometriques) e)));
		
		
		
		System.out.print("\n\n\n"); 
		System.out.println("****** contenir que des cubes ou des sphères ****** \n");
		List<Object> listeCubeSphères = liste.stream()
				.filter(t -> t.getClass().equals(Cube.class) || t.getClass().equals(Sphere.class) )
				.collect(Collectors.toList());
		listeCubeSphères.forEach(e->System.out.println(((FormeGeometriques) e).getNom()+" = "+((FormeGeometriques) e).getClass()));
	}
	
	

	//d=√((x2 – x1)² + (y2 – y1)²).  d=√((x2 – 0)² + (y2 – 0)²).  d=√((x2)² + (y2)²).
	public static double Distance (FormeGeometriques f) {
		return Math.sqrt( Math.pow(f.getOrigine().getX() , 2)   +  Math.pow(f.getOrigine().getY() , 2) );
	}
}
