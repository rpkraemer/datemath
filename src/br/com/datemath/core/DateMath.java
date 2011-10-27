package br.com.datemath.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.datemath.exception.InvalidMaskException;


/**
 * 
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) <br>
 * 		   Édipo Luís Federle (edipofederle@gmail.com)
 * @since 25/10/2011
 * @version 1.0
 * 
 * A classe DateMath realiza operações em cima de uma data passada. 
 * É possível incrementar e decrementar dias, meses, anos, horas, minutos e segundos e armazenar em uma nova data
 * ou retornar uma string formatada com a nova data.
 * Também é possível verificar se a data passada, possui um ano bissexto
 * 
 */

public class DateMath {

	private int valor;
	private Calendar date;
	private DateFormat formatter = null;
		
	/**
	 * 
	 * @param date (Data a ser calculada pelo objeto DateMath, todas as operações serão efetuadas baseadas nessa data)
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()) ...<strong>
	 */
	public DateMath on(Date date) {
		this.date = Calendar.getInstance();
		this.date.setTime(date);
		return this;
	}
	
	/**
	 * 
	 * @param date (String contendo a data que deverá ser parseada)
	 * @param mask (Máscara na qual o parâmetro <strong>date</strong> é informado)
	 * @throws InvalidMaskException (se ocorrer um erro ao tentar parsear a data informada, 
	 * devido a problemas de máscara ou ela estiver nula)
	 * 
	 * <br><br>Exemplo:<br><br>
	 * 		<strong> Date myDate = new DateMath().on("26/10/2011 09:02", "dd/MM/yyyy HH:mm").result(); <strong>
	 */
	public DateMath on(String date, String mask) throws InvalidMaskException {
		if (mask == null) throw new InvalidMaskException("A máscara informada não deve ser nula");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(mask);
			Date tmpDate;
			tmpDate = sdf.parse(date);
			this.date = Calendar.getInstance();
			this.date.setTime(tmpDate);
		} catch (IllegalArgumentException e) {
			throw new InvalidMaskException(e.getMessage());
		} catch (ParseException e) {
			throw new InvalidMaskException(e.getMessage());
		}
		return this;
	}

	/**
	 * 
	 * @param valor (valor que deve ser incrementado na data passada)
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).increase(10) ...<strong>
	 */
	public DateMath increase(int valor) {
		if (valor <= 0) valor *= -1;
		this.valor = valor;
		return this;
	}
	
	/**
	 * 
	 * @param valor (valor que deve ser decrementado na data passada)
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10) ...<strong>
	 */
	public DateMath decrease(int valor) {
		if (valor >= 0) valor *= -1;
		this.valor = valor;
		return this;
	}
	
	/**
	 * Deve ser chamado sempre que se deseja adicionar mais operações na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).days().and().months() ...<strong>
	 */
	public DateMath and() { return this; }
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em ANOS na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).years() ...<strong>
	 */
	public DateMath years() {
		date.add(Calendar.YEAR, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em MESES na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).months() ...<strong>
	 */
	public DateMath months() {
		date.add(Calendar.MONTH, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em DIAS na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).days() ...<strong>
	 */
	public DateMath days() {
		date.add(Calendar.DAY_OF_MONTH, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em HORAS na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).hours() ...<strong>
	 */
	public DateMath hours() {
		date.add(Calendar.HOUR_OF_DAY, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em MINUTOS na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).minutes() ...<strong>
	 */
	public DateMath minutes() {
		date.add(Calendar.MINUTE, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em SEGUNDOS na data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date dataModificada = new DateMath().on(new Date()).decrease(10).seconds() ...<strong>
	 */
	public DateMath seconds() {
		date.add(Calendar.SECOND, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em ANOS na data passada
	 * Equivalente ao método <strong>years()</strong>
	 */
	public DateMath year() {
		date.add(Calendar.YEAR, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em MESES na data passada
	 * Equivalente ao método <strong>months()</strong>
	 */
	public DateMath month() {
		date.add(Calendar.MONTH, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em DIAS na data passada
	 * Equivalente ao método <strong>days()</strong>
	 */
	public DateMath day() {
		date.add(Calendar.DAY_OF_MONTH, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em HORAS na data passada
	 * Equivalente ao método <strong>hours()</strong>
	 */
	public DateMath hour() {
		date.add(Calendar.HOUR_OF_DAY, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em MINUTOS na data passada
	 * Equivalente ao método <strong>minutes()</strong>
	 */
	public DateMath minute() {
		date.add(Calendar.MINUTE, valor);
		return this;
	}
	
	/**
	 * Incrementa/decrementa o <strong>valor</strong> em SEGUNDOS na data passada
	 * Equivalente ao método <strong>seconds()</strong>
	 */
	public DateMath second() {
		date.add(Calendar.SECOND, valor);
		return this;
	}
	
	/**
	 * 
	 * @return retorna <strong>true</strong> se o ano da data passada for bissexto
	 * <strong>false</strong> caso o mesmo não seja
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>boolean bissexto = new DateMath().on(new Date()).isLeapYear();<strong>
	 */
	public boolean isLeapYear() {
		return new GregorianCalendar().isLeapYear(this.date.get(Calendar.YEAR));
	}
	
	/**
	 * 
	 * @return este método retorna um novo java.util.Date refletindo as operações efetuadas sobre a data passada
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date novoDate = new DateMath().on(new Date()).increase(1).day().result();<strong>
	 */
	public Date result() {
		return this.date.getTime();
	}
	
	/**
	 * 
	 * @param formatter Formatador a ser passado para definir o formato de retorno das operações realizadas
	 * @return retorna uma String formatada de acordo com o <strong>formatter</strong> passado
	 * <br><br>Exemplo:<br><br>
	 * 		<strong>Date novoDate = new DateMath().on(new Date()).increase(1).day().result(Results.pt_br());<strong>
	 */
	public String result(DateFormat formatter) {
		this.formatter = formatter;
		return this.formatter.format(this.date.getTime());
	}
}
