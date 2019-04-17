package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departament.class)
public abstract class Departament_ {

	public static volatile SingularAttribute<Departament, Integer> id_dep;
	public static volatile SingularAttribute<Departament, Employee> boss;
	public static volatile SetAttribute<Departament, Proyects> proyects;
	public static volatile SingularAttribute<Departament, String> name;
	public static volatile SetAttribute<Departament, Employee> employees;

	public static final String ID_DEP = "id_dep";
	public static final String BOSS = "boss";
	public static final String PROYECTS = "proyects";
	public static final String NAME = "name";
	public static final String EMPLOYEES = "employees";

}

