package ctag.domain.model.product;

import javax.persistence.Embeddable;

import org.seedstack.business.domain.BaseValueObject;
@Embeddable
public class ProductId extends BaseValueObject{

  private static final long serialVersionUID = 1L;
  
  private int idProduct;
  
  ProductId(){
  }

  public int getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(int idProduct) {
    this.idProduct = idProduct;
  }

  

}
