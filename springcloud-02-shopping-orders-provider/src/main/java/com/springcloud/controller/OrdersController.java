package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrderService;
import com.springcloud.vo.ResultValue;

/**
 * ����ģ��Ŀ��Ʋ�
 * 
 * @author ������
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
	@Autowired
	private OrderService orderService;

	/**
	 * ��ѯ���������Ķ�����Ϣ
	 * 
	 * @param orders     ��ѯ����
	 * @param pageNumber ҳ��
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			// ��ѯ���������Ķ�����Ϣ
			PageInfo<Orders> pageInfo = this.orderService.selectOrders(orders, pageNumber);

			// �ӷ�ҳ��Ϣ�л�ö�����Ϣ
			List<Orders> list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				// ��������Ϣ��ָ���ļ�����Map��
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				// ����ҳ��Ϣ��ָ�������ִ���Map������
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("û���ҵ����������Ķ�����Ϣ������");
		return rv;

	}

	/**
	 * �޸�ָ����Ŷ����Ķ���״̬
	 * 
	 * @param orders �޸ĵĶ�����Ϣ
	 * @return
	 */
	@RequestMapping(value = "/updateOrderStatus")
	public ResultValue updateOrderStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			Integer orderStatus = this.orderService.updateOrderStatus(orders);
			if (orderStatus > 0) {
				rv.setCode(0);
				rv.setMessage("����״̬�޸ĳɹ�������");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("����״̬�޸�ʧ�ܣ�����");
		return rv;
	}

	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			List<Orders> list = this.orderService.selectGroup(orders);
			if (list != null && list.size() > 0) {
				rv.setCode(0);

				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				for (Orders o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				Map<String, Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);

				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		return rv;
	}

}
