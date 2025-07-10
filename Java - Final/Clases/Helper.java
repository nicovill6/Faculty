package Clases;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Helper {
//region Static Objects

	public static Scanner scanner = new Scanner(System.in);
	public static Scanner scanner2 = new Scanner(System.in);
	public static Random random = new Random();

	//endregion

	//region Integer Helper

	private static Integer getInt(String inputMessage, String errorMessage) {
	    while(true){
	        try {
	            System.out.println(inputMessage);
	            return Integer.parseInt(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println(errorMessage);
	        }
	    }
	}

	public static Integer getInt(String inputMessage) {
	    return getInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
	}
	
	private static Integer getPositiveInt(String inputMessage, String errorMessge) {
	    while (true) {
	        int num = getInt(inputMessage);
	        if(num > 0)return num;
	        System.out.println("\n" + errorMessge);
	    }
	}
	
	public static Integer getPositiveInt(String inputMessage){
	    return getPositiveInt(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
	}
	
	//endregion
	
	//region Float Helper
	private static Float getFloat(String inputMessage, String errorMessage) {
	    while(true){
	        try {
	            System.out.println(inputMessage);
	            return Float.parseFloat(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println(errorMessage);
	        }
	    }
	}

	public static Float getFloat(String inputMessage) {
	    return getFloat(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
	}
	private static Float getPositiveFloat(String inputMessage, String errorMessge) {
	    while (true) {
	        float num = getFloat(inputMessage);
	        if(num > 0)return num;
	        System.out.println("\n" + errorMessge);
	    }
	}
	
	public static Float getPositiveFloat(String inputMessage){
	    return getPositiveFloat(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
	}
	//end region Float
	
	//region Double Helper
	
	private static Double getDouble(String inputMessage, String errorMessage) {
	    while(true){
	        try {
	            System.out.println(inputMessage);
	            return Double.parseDouble(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println(errorMessage);
	        }
	    }
	}
	
	public static Double getDouble(String inputMessage){
	    return getDouble(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO");
	}
	
	//endregion
	
	
	//region Character Helper
	
	private static Character getChar(String inputMessage, String errorMessage) {
	
	    while (true) {
	        try {
	            System.out.println("\n" + inputMessage);
	            char caracter = scanner.nextLine().toUpperCase().charAt(0);
	            int valorASCII = (int)caracter;
	            if (valorASCII == 165 || (valorASCII >= 65 && valorASCII <= 90) || 
	            		 (valorASCII >= 97 && valorASCII <= 122) || valorASCII == 164)
	                return caracter;
	            else
	                throw new Exception(errorMessage);
	        } catch (Exception e) {
	            System.out.println("\n" + e.getMessage());
	            scanner.nextLine();
	        }
	    }
	}
	
	public static Character getChar(String inputMessage){
	    return getChar(inputMessage, "\nERROR: INGRESE UN CARACTER VALIDO");
	}
	
	//endregion
	//region Strings
	public static String validarCadena() {
		Scanner input= new Scanner(System.in);
		String cadena= input.nextLine();
		boolean control=false;
		while(!control) {
			if(cadena.length()>=3) {
				for(int i=0; i<cadena.length();++i) {
					if(Character.isDigit(cadena.charAt(i))) {
						System.out.println("Error! la cadena no puede contener números\n"
								+ "Cargue nuevamente el dato: ");
						cadena= input.nextLine();
						control=false;
						break;
					}
					else control=true;
				}
			}
			else {
				System.out.println("Error. Ingrese una cadena/palabra válida");
				cadena= input.nextLine();
			}
		}
		return cadena;
	}
	//end region
	//region Question (yes or no)
	
	public static char yesOrNo(String question){
	    char resp;
	    do {
	        System.out.println("\n" + question + "\nPRESIONE 'S'-SI\nPRESIONE 'N'-NO");
	        resp = Character.toUpperCase(scanner.nextLine().charAt(0));
	        if(resp == 'N' || resp == 'S')return resp;
	        System.out.println("\nERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO");
	    } while (true);
	}
	
	//endregion
	
	//region Date
	public static Date fecha(String fec) {
		
			while(true) {	
			try {
				Date fecha;
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				fecha = formato.parse(fec);
				return fecha;
			} catch (Exception e) {
				System.out.println("ERROR EN FECHA");
			}
		
		}	
	}
	public static LocalDate validarFecha() {
		LocalDate fecha = null;
		int mes= validarMes(Helper.getPositiveInt("Ingrese MES: "));
		int dia= validarDia(Helper.getPositiveInt("Ingrese DÍA: "), mes);
		System.out.println("*Fecha cargada acorde al corriente año (2025)\n");
		return fecha= LocalDate.of(2025,mes,dia);
	}
	private static int validarMes(int mes) {
		while(mes<1 || mes>12) {
			mes=Helper.getPositiveInt("Ingrese MES correctamente: ");
		}
		System.out.println("Mes cargado correctamente!\n");
		return mes;
	}
	private static int validarDia(int dia, int mes) {
		if(mes==2 && dia>28) {
			while(dia>28) {
				dia= Helper.getPositiveInt("Febrero solo puede tener hasta 28 días, intente nuevamente: ");
			}
		}
		else if((mes==4 || mes==6 || mes==5 ||mes== 9|| mes==11) && dia>30) {
			while(dia>30) {
				dia= Helper.getPositiveInt("El mes ingresado no puede tener más de 30 días, intente nuevamente: ");
			}
		}
		else {
			while(dia>31) {
				dia= Helper.getPositiveInt("El mes ingresado no puede tener más de 31 días, intente nuevamente: ");
			}
		}
		System.out.println("*Día cargado correctamente!\n");
		return dia;
	}
	//end region
	//region Random
	public static Integer generarNumRandom() {
		return random.nextInt(10000+1);
	}
	//end region
}