package S1_08_Lambdas_N1_f3;
import javax.swing.JOptionPane;
public class met_N1_f3 {
public static void main(String[] args) {
		String origen = "A invertir";
		origen = JOptionPane.showInputDialog("introudce el string a invertir ",origen);  	// referencia a la interface
		In_Rever_String ref_re_st;                                                  	// lambda cuerpo invierte string
		ref_re_st = (para) -> {   
					String result = "";
					for(int i = para.length()-1; i >= 0; i--)
							result += para.charAt(i);
					return result;
					};	     
		System.out.println("String invertido = " + ref_re_st.Rever_String(origen));		
		}	
	}
//import java.lang.FunctionalInterface;