package ctag.domain.model.customer;

import javax.persistence.Embeddable;

import org.seedstack.business.domain.BaseValueObject;

 @Embeddable
public class CustomerId extends BaseValueObject {


   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   private int idCustomer;
   
   CustomerId(){
     
   }
   
   public CustomerId(int id) {
     this.idCustomer = id;
   }
   
   public int getCustomerId() {
     return idCustomer;
   }
 }


