package com.mycompay.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProdutoMaterial.class)
public abstract class ProdutoMaterial_ {

	public static volatile SingularAttribute<ProdutoMaterial, Produto> produto;
	public static volatile SingularAttribute<ProdutoMaterial, Material> material;
	public static volatile SingularAttribute<ProdutoMaterial, Long> id;
	public static volatile SingularAttribute<ProdutoMaterial, Double> quantidade;

}

