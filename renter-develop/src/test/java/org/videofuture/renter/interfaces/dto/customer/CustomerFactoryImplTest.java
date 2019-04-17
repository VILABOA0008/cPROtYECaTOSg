package org.videofuture.renter.interfaces.dto.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.videofuture.renter.domain.model.customer.Customer;

@RunWith(value = Parameterized.class)
public class CustomerFactoryImplTest {

  static CustomerFactoryImpl customerFactory;
  Customer expectedCustomer;
  String customerName;
  Date registerDate;

  @Parameters
  public static Iterable<Object[]> getDate() {
    return Arrays.asList(new Object[][] {
        { "Mariano", Date.valueOf("2001-11-04") },
        { "Sancho", Date.valueOf("2001-05-11") },
        { "Julio", Date.valueOf("2001-12-19") },
    });
  }

  public CustomerFactoryImplTest(String customerName, Date registerDate) {
    this.customerName = customerName;
    this.registerDate = registerDate;
  }

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    customerFactory = new CustomerFactoryImpl();
  }

  @Before
  public void setUp() {
    expectedCustomer = new Customer(customerName, registerDate);
  }

  @Test
  public void customerShouldBeCreated() {
    final Customer actualCustomer = customerFactory.create(customerName, registerDate);
    assertThat(actualCustomer.getName()).isExactlyInstanceOf(String.class).isNotNull()
        .isEqualTo(expectedCustomer.getName());
    assertThat(actualCustomer.getRegisterDate()).isInstanceOf(Date.class).isNotNull()
        .isEqualTo(expectedCustomer.getRegisterDate());
  }
  
  @After
  public void tearDown() {
    expectedCustomer = null;
  }
  
  @AfterClass
  public static void tearDownAfterClass() {
    customerFactory = null;
  }
}
