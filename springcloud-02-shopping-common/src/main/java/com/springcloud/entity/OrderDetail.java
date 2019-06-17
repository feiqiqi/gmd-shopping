package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于保存OrderDetail表中一行订单明细的信息
 * 
 * @author 费琪琪
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements java.io.Serializable {

	
	private static final long serialVersionUID = -2281236879693007932L;

	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 商品编号
	 */
	private Integer goodId;

	/**
	 * 商品名称
	 */
	private String goodName;

	/**
	 * 成交价
	 */
	private Double transactionPrice;

	/**
	 * 成交数量
	 */
	private Integer transactionCount;

}