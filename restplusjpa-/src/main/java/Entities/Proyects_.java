package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proyects.class)
public abstract class Proyects_ {

	public static volatile SingularAttribute<Proyects, Employee> director;
	public static volatile SingularAttribute<Proyects, String> name;
	public static volatile SingularAttribute<Proyects, Integer> id;
	public static volatile SetAttribute<Proyects, Employee> employee;
	public static volatile SingularAttribute<Proyects, Departament> departament;
	public static volatile SingularAttribute<Proyects, Float> anual_cost;

	public static final String DIRECTOR = "director";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMPLOYEE = "employee";
	public static final String DEPARTAMENT = "departament";
	public static final String ANUAL_COST = "anual_cost";

}

