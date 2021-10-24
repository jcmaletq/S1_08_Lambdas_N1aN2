package S1_08_Lambdas_N1_f1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Entrega {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// requerimiento 1	
		System.out.println("requerimiento 1	");
		 List<String> strList = Arrays.asList ("Ema","Ana","Alejandro","Ale");
		List<String> resList = nom_propio_3 (strList, 3, "a" );  // lo incluyo como parametro para hacerla mas general
		System.out.println (resList);
		
		// requerimiento 2
		System.out.println("requerimiento 2	");
		List<Integer> intList = Arrays.asList (1,2,3,5,8,13);
		String result = lista_a_cadena (intList);
		System.out.println (result);
		
		// requerimiento 3
		System.out.println("requerimiento 3	");
		List<String> lista = Arrays.asList ("Ema","Ana","Alejandro","Oscar", "Mario");
		System.out.println(cadena_o (lista, "o"));

		// requerimiento 4
		System.out.println("requerimiento 4	");
		List<String> listas = Arrays.asList ("Ema","Ana","Alejandro","Oscar", "Mario", "testeo");
		System.out.println(cadena_o_long (listas, "o", 5));
		
		// requerimiento 5
//		System.out.println("requerimiento 5	");
//		List<String> listam = Arrays.asList ("Enero","Febrero","Marzo","Abril", "Mayo", "Junio",
//				                     "Julio", "Agosto","Septiembre","Octubre", "Noviembre","Diciembre");
//		cadena_meses (listam, "o", 5);
	}
public static List<String>  nom_propio_3(List<String> strList, int longi, String f_l) {
	/*    requerimiento 1	
	* Tenint una llista de cadenes de noms propis,  escriu un mètode que retorn e una llista de totes les cadenes 
	 * que  comencen amb la lletra 'a' (mayuscula ) i  tenen exactament 3  lletres. Imprimeix el resultat
	 * */ 
    List<String> resList = (strList.stream()
                             .filter (nombre -> nombre.length() == longi)
                             .filter (nombre -> nombre.startsWith (f_l.toUpperCase()))
                            )
           .collect(Collectors.toList()
         );
   resList.forEach(System.out::println);                //output : spring, node
   return resList;  
   }
public static String  lista_a_cadena (List<Integer> intList) {
	/*  requerimiento 2
 * Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers. 
 * Cada element  hauria d'anar precedit per la  lletra  "e" si el nombre és parell , i precedit de la lletra  "o" 
 * si el nombre és im parell. Per exemple, si la llista  d'entrada és (3,44), la  sortida hauria de ser "o3, e44". 
 *  Imprimeix el  resultat.
	 * 
	 */ 	
    String res = intList.stream() 
			.map (x -> x % 2 == 0 ? ("e" + x  ):("o" + x ) )
			.collect(Collectors.joining(","))
			;	
   return res;	
   }
public static List<String> cadena_o (List<String> lista, String f_l){
/*    requerimiento 3
  * Tenint una llista de Strings, escriu un mètode  que retorne una llista de totes les  cadenes  que 
  * continguen la lletra ‘o’ i  imprimeix el resultat .  
 */
	List<String> ret = (lista.stream()
			.filter (cadena -> cadena.toUpperCase().contains(f_l.toUpperCase()))
			.collect(Collectors.toList())
			);
	return ret;
}
public static List<String> cadena_o_long (List<String> lista, String f_l, int longi){  // lo incluyo enparametros para generalizar
/*   requerimiento 4
  * Tenint una llista de Strings, escriu un mètode  que retorne una llista de totes les  cadenes  que 
  * continguen la lletra ‘o’ i  imprimeix el resultat . 
  * Has de fer el mateix que en el punt anterior,  però retornant una llista que  incloga els elements amb  més de 5 lletres.
  * Imprimeix  el  resultat. 

 */
	List<String> ret = (lista.stream()
			.filter (cadena -> cadena.toUpperCase().contains(f_l.toUpperCase()))
			.filter (cadena -> cadena.length() > longi)
			.collect(Collectors.toList())
			);
	return ret;
}
/*
public static void cadena_meses (List<String> lista, String f_l, int longi){
//          requerimiento 5
//  * Crea una llista amb  els nombs dels mesos de  l’any. Imprimeix tots els  elements de la llista amb  una lambda. 
//  * Has de  fer la mateixa impressió del punt  anterior  però fent-ho mitjançant method reference. 
    System.out.println(Entrega::cadena_o_long(lista,f_l,longi));
}
*/
}

