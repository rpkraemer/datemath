package br.com.datemath.core;

import java.text.SimpleDateFormat;

import br.com.datemath.exception.InvalidMaskException;

/**
 * 
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) <br>
 * 		   Édipo Luís Federle (edipofederle@gmail.com)
 * @since 25/10/2011
 * @version 1.0
 * 
 * A classe Results disponibiliza objetos pré-definidos para formatar o resultado obtido da classe DateMath.
 * Deve ser utilizada sempre que se deseja retornar uma String formatada a partir da data calculada.
 * 
 */
public class Results {
	
	/**
	 * 
	 * @return SimpleDateFormat
	 * Retorna um SimpleDateFormat para o padrão ptBR (DD/MM/YYYY HH24:MM:SS)
	 * 
	 */
	public static SimpleDateFormat pt_br() { return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); }
	
	
	/**
	 * 
	 * @return SimpleDateFormat
	 * Retorna um SimpleDateFormat para o padrão enUS (MM/DD/YYYY H:MM:SS AM/PM)
	 */
	public static SimpleDateFormat en_us() { return new SimpleDateFormat("MM/dd/yyyy h:mm:ss a"); }
	
	
	/**
	 * 
	 * @param mask (Máscara na qual o resultado dos cálculos na data passada deve ser retornado)
	 * @return SimpleDateFormat
	 * @throws InvalidMaskException O método lança esta exceção caso a <strong>mask</strong> passada seja inválida ou nula
	 */
	public static SimpleDateFormat custom(String mask) throws InvalidMaskException {
		
		if (mask == null) throw new InvalidMaskException("A máscara utilizada não deve ser nula");
			
		try {
			return new SimpleDateFormat(mask);
		} catch (IllegalArgumentException e) {
			throw new InvalidMaskException(e.getMessage());
		}
	}
}
