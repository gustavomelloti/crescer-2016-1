package com.mycompay.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PedidoItem.class)
public abstract class PedidoItem_ {

	public static volatile SingularAttribute<PedidoItem, Double> precoUnitario;
	public static volatile SingularAttribute<PedidoItem, Character> situacao;
	public static volatile SingularAttribute<PedidoItem, Produto> produto;
	public static volatile SingularAttribute<PedidoItem, Pedido> Pedido;
	public static volatile SingularAttribute<PedidoItem, Long> id;
	public static volatile SingularAttribute<PedidoItem, Double> quantidade;

}

