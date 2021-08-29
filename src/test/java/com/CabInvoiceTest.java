package com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CabInvoiceTest {

	@Test
	public void totalFareShould60() {
		Float result= 60f;
		assertEquals(60.0, RideCalculate.totalFare(5, 10), result);
	}
	@Test
	public void totalFareshouldbe5() {
		Float result= 5f;
		assertEquals(5.0, RideCalculate.totalFare(0, 4), result);
	}

}
