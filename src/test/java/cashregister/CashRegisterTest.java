package cashregister;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
	private  static MockPrinter mockedPrinter;
	private  static CashRegister cashRegister;
	
	@BeforeAll
	private static void setup() {
		mockedPrinter = new MockPrinter();
		cashRegister = new CashRegister(mockedPrinter);
	}
	
	@BeforeEach
	private void cleanPrinter() {
		mockedPrinter.setTempText("");
	}
	
    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item[] items = {new Item("test product", 1)};
    	Purchase purchase =new Purchase(items);
    	MockPrinter mockedPrinter = new MockPrinter();
    	CashRegister cashRegister =new CashRegister(mockedPrinter);
        //when
    	cashRegister.process(purchase);
        //then
    	assertEquals("test product\t1.0\n", mockedPrinter.getTempText());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
    	StubPurchase subPurchase = new StubPurchase();
    	
        //when
    	cashRegister.process(subPurchase);
        //then
    	assertEquals("test product\t1.0\n", mockedPrinter.getTempText());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }

}
