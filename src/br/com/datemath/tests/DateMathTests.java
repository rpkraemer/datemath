package br.com.datemath.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.datemath.core.DateMath;
import br.com.datemath.core.Results;
import br.com.datemath.exception.InvalidMaskException;
import static br.com.datemath.core.Results.*;

public class DateMathTests {

	private Date startDate, endDate, startDateENUS, endDateENUS;
	
	@Before
	public void setUp() throws ParseException {
		this.startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.parse("24/10/2011 09:23:45");
		this.endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.parse("13/11/2011 16:12:01");
		this.startDateENUS = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse("10/24/2011 9:23:45 AM");
		this.endDateENUS = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse("11/13/2011 4:12:01 PM");

	}

	@Test
	public void testShouldAdd2DaysInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).days()
				.result(pt_br());
		Assert.assertEquals("26/10/2011 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2DaysInStartDatePTBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).increase(-2).days()
				.result(pt_br());
		Assert.assertEquals("26/10/2011 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2MonthsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).months()
				.result(pt_br());
		Assert.assertEquals("24/12/2011 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2MonthsInStartDatePTBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).increase(-2).months()
				.result(pt_br());
		Assert.assertEquals("24/12/2011 09:23:45", formated);
	}

	@Test
	public void testShouldAdd4MonthsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(4).months()
				.result(pt_br());
		Assert.assertEquals("24/02/2012 09:23:45", formated);
	}

	@Test
	public void testShouldAdd4MonthsAndDescrease2DaysInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(4).months()
				.and().decrease(2).days().result(pt_br());
		Assert.assertEquals("22/02/2012 09:23:45", formated);
	}

	@Test
	public void testShouldAdd4MonthsAnd4Days() {
		String formated = new DateMath().on(startDate).increase(4).months()
				.and().days().result(Results.pt_br());
		Assert.assertEquals("28/02/2012 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2YearsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).years()
				.result(pt_br());
		Assert.assertEquals("24/10/2013 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2YearsInStartDatePTBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).increase(-2).years()
				.result(pt_br());
		Assert.assertEquals("24/10/2013 09:23:45", formated);
	}

	@Test
	public void testShouldAdd2HoursInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).hours()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 11:23:45", formated);
	}

	@Test
	public void testShouldAdd2HoursInStartDatePTBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).increase(-2).hours()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 11:23:45", formated);
	}

	@Test
	public void testShouldAdd2MinutesInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).minutes()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:25:45", formated);
	}

	@Test
	public void testShouldAdd2MinutesInStartDatePTBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).increase(-2).minutes()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:25:45", formated);
	}

	@Test
	public void testShouldAdd40MinutesInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(40).minutes()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 10:03:45", formated);
	}

	@Test
	public void testShouldAdd40MinutesAnd16SecondsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(40).minutes()
				.and().increase(16).seconds().result(pt_br());
		Assert.assertEquals("24/10/2011 10:04:01", formated);
	}

	@Test
	public void testShouldAdd40MinutesAnd16SecondsInStartDatePTBRWithNegativeValues() {
		String formated = new DateMath().on(startDate).increase(-40).minutes()
				.and().increase(-16).seconds().result(pt_br());
		Assert.assertEquals("24/10/2011 10:04:01", formated);
	}

	@Test
	public void testShouldAdd2SecondsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(2).seconds()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:23:47", formated);
	}

	@Test
	public void testShouldAdd30SecondsInStartDatePTBR() {
		String formated = new DateMath().on(startDate).increase(30).seconds()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:24:15", formated);
	}

	@Test
	public void testShouldReturnFalseToLeapYear() {
		boolean no = false;
		Assert.assertEquals(no, new DateMath().on(startDate).isLeapYear());
	}

	@Test
	public void testShouldReturnTrueToLeapYear() {
		boolean yes = true;
		boolean leapYear = new DateMath().on(startDate).increase(1).year()
				.isLeapYear();
		Assert.assertEquals(yes, leapYear);
	}

	@Test
	public void testShouldDescrease1SecondInStartdatePRBR() {
		String formated = new DateMath().on(startDate).decrease(1).seconds()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:23:44", formated);
	}

	@Test
	public void testShouldDescrease1SecondInStartdatePRBRWithNegativeValue() {
		String formated = new DateMath().on(startDate).decrease(-1).seconds()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:23:44", formated);
	}

	@Test
	public void testShouldDescrease2SecondInStartdatePRBR() {
		String formated = new DateMath().on(startDate).decrease(1).seconds()
				.result(pt_br());
		Assert.assertEquals("24/10/2011 09:23:44", formated);
	}

	@Test(expected = InvalidMaskException.class)
	public void testShouldExpWhenMaskInvalid() throws InvalidMaskException {
		String formated = new DateMath().on(startDate).decrease(1).seconds()
				.result(Results.custom(null));
	}

	@Test(expected = InvalidMaskException.class)
	public void testShouldExpWhenMaskInvalid1() throws InvalidMaskException {
		String formated = new DateMath().on(startDate).decrease(1).seconds()
				.result(Results.custom("Y"));
	}

	/*
	 * US format tests
	 */

	@Test
	public void testShouldAdd4HoursInStartDateENUS() {
		String formated = new DateMath().on(startDateENUS).increase(4).hours()
				.result(Results.en_us());
		Assert.assertEquals("10/24/2011 1:23:45 PM", formated);
	}

	@Test
	public void testShouldDecrease9HoursInStartDateENUS() {
		String formated = new DateMath().on(startDateENUS).decrease(9).hours()
				.result(Results.en_us());
		Assert.assertEquals("10/24/2011 12:23:45 AM", formated);
	}
	
	//US tests
	
	@Test
	public void testShouldAdd2DaysInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).days()
				.result(en_us());
		Assert.assertEquals("10/26/2011 9:23:45 AM", formated);
	}

	@Test
	public void testShouldAdd2DaysInStartDatePTBRWithNegativeValueUS() {
		String formated = new DateMath().on(startDateENUS).increase(-2).days()
				.result(en_us());
		Assert.assertEquals("10/26/2011 9:23:45 AM", formated);
	}
	

	@Test
	public void testShouldAdd2MonthsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).months()
				.result(en_us());
		Assert.assertEquals("12/24/2011 9:23:45 AM", formated);
	}

	
	@Test
	public void testShouldAdd2MonthsInStartDateUSWithNegativeValue() {
		String formated = new DateMath().on(startDateENUS).increase(-2).months()
				.result(en_us());
		Assert.assertEquals("12/24/2011 9:23:45 AM", formated);
	}

	
	@Test
	public void testShouldAdd4MonthsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(4).months()
				.result(en_us());
		Assert.assertEquals("02/24/2012 9:23:45 AM", formated);
	}

	@Test
	public void testShouldAdd4MonthsAndDescrease2DaysInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(4).months()
				.and().decrease(2).days().result(en_us());
		Assert.assertEquals("02/22/2012 9:23:45 AM", formated);
	}

	
	@Test
	public void testShouldAdd4MonthsAnd4DaysUS() {
		String formated = new DateMath().on(startDateENUS).increase(4).months()
				.and().days().result(en_us());
		Assert.assertEquals("02/28/2012 9:23:45 AM", formated);
	}

	
	@Test
	public void testShouldAdd2YearsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).years()
				.result(en_us());
		Assert.assertEquals("10/24/2013 9:23:45 AM", formated);
	}
	

	@Test
	public void testShouldAdd2YearsInStartDatePTBRWithNegativeValueUS() {
		String formated = new DateMath().on(startDateENUS).increase(-2).years()
				.result(en_us());
		Assert.assertEquals("10/24/2013 9:23:45 AM", formated);
	}

	@Test
	public void testShouldAdd2HoursInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).hours()
				.result(en_us());
		Assert.assertEquals("10/24/2011 11:23:45 AM", formated);
	}

	@Test
	public void testShouldAdd2HoursInStartDateUSWithNegativeValue() {
		String formated = new DateMath().on(startDateENUS).increase(-2).hours()
				.result(en_us());
		Assert.assertEquals("10/24/2011 11:23:45 AM", formated);
	}

	
	@Test
	public void testShouldAdd2MinutesInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).minutes()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:25:45 AM", formated);
	}

	@Test
	public void testShouldAdd2MinutesInStartDateUSWithNegativeValue() {
		String formated = new DateMath().on(startDateENUS).increase(-2).minutes()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:25:45 AM", formated);
	}

	@Test
	public void testShouldAdd40MinutesInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(40).minutes()
				.result(en_us());
		Assert.assertEquals("10/24/2011 10:03:45 AM", formated);
	}

	@Test
	public void testShouldAdd40MinutesAnd16SecondsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(40).minutes()
				.and().increase(16).seconds().result(en_us());
		Assert.assertEquals("10/24/2011 10:04:01 AM", formated);
	}

	@Test
	public void testShouldAdd40MinutesAnd16SecondsInStartDateUSWithNegativeValues() {
		String formated = new DateMath().on(startDateENUS).increase(-40).minutes()
				.and().increase(-16).seconds().result(en_us());
		Assert.assertEquals("10/24/2011 10:04:01 AM", formated);
	}

	@Test
	public void testShouldAdd2SecondsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(2).seconds()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:23:47 AM", formated);
	}

	@Test
	public void testShouldAdd30SecondsInStartDateUS() {
		String formated = new DateMath().on(startDateENUS).increase(30).seconds()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:24:15 AM", formated);
	}

	@Test
	public void testShouldDescrease1SecondInStartdateUS() {
		String formated = new DateMath().on(startDateENUS).decrease(1).seconds()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:23:44 AM", formated);
	}

	@Test
	public void testShouldDescrease1SecondInStartdateUSWithNegativeValue() {
		String formated = new DateMath().on(startDateENUS).decrease(-1).seconds()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:23:44 AM", formated);
	}

	@Test
	public void testShouldDescrease2SecondInStartdateUS() {
		String formated = new DateMath().on(startDateENUS).decrease(1).seconds()
				.result(en_us());
		Assert.assertEquals("10/24/2011 9:23:44 AM", formated);
	}
	
	@Test
	public void testShouldIncrease2DaysAnd10SecondsWithCustomFormart() throws InvalidMaskException{
		String formated = new DateMath().on(startDateENUS).increase(2)
						.days().and().increase(10).seconds().result(Results.custom("HH:mm:ss - dd/MM/yyyy"));
		Assert.assertEquals("09:23:55 - 26/10/2011", formated);
	}
	
	@Test
	public void testShouldIncrease2DaysAnd10SecondsWithCustomFormart2() throws InvalidMaskException{
		String formated = new DateMath().on(startDateENUS).increase(2)
						.days().and().increase(10).seconds().result(Results.custom("dd/MM/yyyy"));
		Assert.assertEquals("26/10/2011", formated);
	}
	
	@Test
	public void testShouldIncrease2DaysAnd10SecondsWithCustomFormart3() throws InvalidMaskException{
		String formated = new DateMath().on(startDateENUS).increase(2)
						.days().and().increase(10).seconds().result(Results.custom("dd-MM-yyyy"));
		Assert.assertEquals("26-10-2011", formated);
	}
	
	@Test
	public void testShouldReturnDateFromStringInputDate() throws InvalidMaskException {
		Date date = null;
		date = new DateMath().on("26-10-2011", "dd-MM-yyyy").result();
		Assert.assertNotNull(date);
	}
	
	@Test
	public void testShouldReturnDateFromStringInputDateAndIncrease1Day() throws InvalidMaskException {
		Date date = null;
		date = new DateMath().on("26-10-2011", "dd-MM-yyyy").increase(1).day().result();
		String formated = new DateMath().on(date).result(pt_br());
		Assert.assertNotNull(date);
		Assert.assertEquals("27/10/2011 00:00:00", formated);
	}
	
	@Test
	public void testShouldReturnDateFromStringInputDateAndIncrease7Days() throws InvalidMaskException {
		String date = null;
		date = new DateMath().on("26-10-2011", "dd-MM-yyyy").increase(7).days().result(pt_br());
		Assert.assertNotNull(date);
		Assert.assertEquals("02/11/2011 00:00:00", date);
	}
	
	@Test
	public void testShouldReturnFormatedResultPTBRFromStringInputDate() throws InvalidMaskException {
		String date = null;
		date = new DateMath().on("10-26-2011", "MM-dd-yyyy").result(pt_br());
		Assert.assertNotNull(date);
		Assert.assertEquals("26/10/2011 00:00:00", date);
	}
	
	@Test
	public void testShouldReturnFormatedResultENUSFromStringInputDate() throws InvalidMaskException {
		String date = null;
		date = new DateMath().on("10-26-2011", "MM-dd-yyyy").result(en_us());
		Assert.assertNotNull(date);
		Assert.assertEquals("10/26/2011 12:00:00 AM", date);
	}
	
	@Test(expected = InvalidMaskException.class)
	public void testShouldExpWhenMaskInvalid2() throws InvalidMaskException {
		String date = null;
		date = new DateMath().on("10-26-2011", "MM-dd-YYYY").result(en_us());
	}
}