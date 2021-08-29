
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

	InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();

	@Test
	public void givenDistanceAndTime_WhenCalculated_ReturnTotalFare() {
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 5.0, 5) };
		double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
		Assert.assertEquals(55.0, cabInvoiceGeneratorTotalFare, 0);
	}

	@Test
	public void givenDistanceAndTime_WhenLessThanMinimumFareGetCalculated_ThenReturnMinimumFare() {
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 0.132, 1) };
		double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
		Assert.assertEquals(5, cabInvoiceGeneratorTotalFare, 0);
	}

	@Test
	public void givenMultipleRides_WhenCalculated_ReturnTotalFare() {
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 26.05, 29),
				new Rides(Rides.RideType.NORMAL_RIDE, 12.39, 25) };
		double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
		Assert.assertEquals(438.4, cabInvoiceGeneratorTotalFare, 0);
	}

	@Test
	public void givenMultipleRides_WhenCalculated_ReturnInvoiceSummery() {
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 25.12, 40),
				new Rides(Rides.RideType.NORMAL_RIDE, 12.39, 25) };
		InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoiceSummary(rides);
		InvoiceSummary summary = new InvoiceSummary(2, 440.1);
		Assert.assertEquals(summary, invoiceSummary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnUserInvoiceSummary() {
		String userId = "user@.com";
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 25.12, 40),
				new Rides(Rides.RideType.NORMAL_RIDE, 12.39, 25) };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary summary = new InvoiceSummary(2, 440.1);
		Assert.assertEquals(invoiceSummary, summary);
	}

	@Test
	public void givenDistanceAndTimeForNormalRides_ShouldReturnTotalFare() {
		Rides[] rides = { new Rides(Rides.RideType.NORMAL_RIDE, 25.12, 45) };
		double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
		Assert.assertEquals(296.2, cabInvoiceGeneratorTotalFare, 0.1);
	}

	@Test
	public void givenDistanceAndTimeForPremiumRides_ShouldReturnTotalFare() {
		Rides[] rides = { new Rides(Rides.RideType.PREMIUM_RIDE, 25.12, 45) };
		double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
		Assert.assertEquals(466.8, cabInvoiceGeneratorTotalFare, 0.1);
	}
}
