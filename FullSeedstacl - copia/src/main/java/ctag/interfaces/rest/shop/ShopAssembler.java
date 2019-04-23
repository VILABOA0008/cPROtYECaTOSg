package ctag.interfaces.rest.shop;

import org.seedstack.business.assembler.BaseAssembler;

import ctag.domain.model.shop.Shop;
import ctag.domain.model.shop.ShopId;

public class ShopAssembler extends BaseAssembler<Shop, ShopRepresentation> {

  @Override
  public void mergeAggregateIntoDto(Shop sourceAggregate, ShopRepresentation targetDto) {

    targetDto.setNameShop(targetDto.getNameShop());

  }

  @Override
  public void mergeDtoIntoAggregate(ShopRepresentation sourceDto, Shop targetAggregate) {

    targetAggregate.setNameShop(sourceDto.getNameShop());

  }

}
