package com.mycompay.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile SingularAttribute<Pedido, Character> situacao;
	public static volatile ListAttribute<Pedido, PedidoItem> itens;
	public static volatile SingularAttribute<Pedido, Date> dataEntrega;
	public static volatile SingularAttribute<Pedido, Date> dataPedido;
	public static volatile SingularAttribute<Pedido, Long> id;
	public static volatile SingularAttribute<Pedido, Double> valorPedido;

}

