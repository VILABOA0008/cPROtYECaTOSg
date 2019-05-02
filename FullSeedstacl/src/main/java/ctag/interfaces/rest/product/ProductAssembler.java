package ctag.interfaces.rest.product;

import org.seedstack.business.assembler.BaseAssembler;

import ctag.domain.model.product.Product;

public class ProductAssembler extends BaseAssembler<Product, ProductRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Product sourceAggregate, ProductRepresentation targetDto) {
    targetDto.setCost(sourceAggregate.getCost());
    targetDto.setQuantity(sourceAggregate.getQuantity());
    targetDto.setShop(sourceAggregate.getShop());

  }

  @Override
  public void mergeDtoIntoAggregate(ProductRepresentation sourceDto, Product targetAggregate) {
    targetAggregate.setCost(sourceDto.getCost());
    targetAggregate.setQuantity(sourceDto.getQuantity());
    targetAggregate.setShop(sourceDto.getShop());
  }

}
