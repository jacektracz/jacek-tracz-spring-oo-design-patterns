package com.jacektracz.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/** 
* @author arun.pandey 
*/
public class IncomeTaxClient {  
  public static final Log LOG = LogFactory.getLog(IncomeTaxClient.class);  
  private static final int NUMBER_OF_TAX_PAYER = 1000; 
  private static IncomeTaxDept incomeTaxDept = new IncomeTaxDept(1000, NUMBER_OF_TAX_PAYER);  

  public static void main(String[] args) {

    registerTaxPayers();  
    ExecutorService executor = Executors.newFixedThreadPool(30);    
    LOG.info("Initial IncomeTax Department's total revenue is ===>> "+incomeTaxDept.getTotalRevenue());    

    for(TaxPayer taxPayer : incomeTaxDept.getTaxPayersList())   
      executor.submit(() -> {             
        try {                 
          Thread.sleep(100);                 
          incomeTaxDept.payTax(taxPayer);                 
          double revenue = incomeTaxDept.getTotalRevenue();                                  
          LOG.info("IncomeTax Department's total revenue after tax paid at client code is --->> " +revenue);                                                   

          double returnAmount = incomeTaxDept.getFederalTaxReturn(taxPayer);                
          LOG.info(taxPayer.getTaxPayerName() + " received the Federal return amount = " +returnAmount);                                 
          revenue = incomeTaxDept.getTotalRevenueOptimisticRead();                

          LOG.info("IncomeTax Department's total revenue after getting Federal tax return at client code is --->> " +revenue);                                 
          double stateReturnAmount = incomeTaxDept.getStateTaxReturnUisngConvertToWriteLock(taxPayer);                                  

          LOG.info(taxPayer.getTaxPayerName() + " received the State tax return amount = " +stateReturnAmount);                                  
          revenue = incomeTaxDept.getTotalRevenueOptimisticRead();                 

          LOG.info("IncomeTax Department's total revenue after getting State tax return at client code is --->> " +revenue);                 
          Thread.sleep(100);             
        } catch (Exception e) {}          
      }
    );    

    executor.shutdown(); 
  }  

  private static void registerTaxPayers(){  
    for(int i = 1; i < NUMBER_OF_TAX_PAYER+1; i++){   
      TaxPayer taxPayer = new TaxPayer();    
      taxPayer.setTaxAmount(2000);   
      taxPayer.setTaxPayerName("Payer-"+i);   
      taxPayer.setTaxPayerSsn("xx-xxx-xxxx"+i);   
      incomeTaxDept.registerTaxPayer(taxPayer);  
    } 
  }
}