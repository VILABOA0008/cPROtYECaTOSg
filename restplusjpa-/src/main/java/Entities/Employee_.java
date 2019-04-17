package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SetAttribute<Employee, Proyects> proy;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Departament> dept;
	public static volatile SingularAttribute<Employee, Float> salary;
	public static volatile SingularAttribute<Employee, Integer> age;

	public static final String NAME = "name";
	public static final String PROY = "proy";
	public static final String ID = "id";
	public static final String DEPT = "dept";
	public static final String SALARY = "salary";
	public static final String AGE = "age";

}

