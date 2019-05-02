package ctag.application.utils;

import ctag.domain.model.customer.Customer_;

public class LibraryUtils {

  public static String wrongCustomerAtributtes(String column) {

    if (column.equalsIgnoreCase(Customer_.AGE) || column.equalsIgnoreCase(Customer_.NAME) ||
        column.equalsIgnoreCase(Customer_.ID_CUSTOMER) || column.equalsIgnoreCase(Customer_.SHOP)|| column.equalsIgnoreCase(Customer_.MONEY)) {
      return Errors.OK;
    }
    return Errors.ERR_001;

  }

}
