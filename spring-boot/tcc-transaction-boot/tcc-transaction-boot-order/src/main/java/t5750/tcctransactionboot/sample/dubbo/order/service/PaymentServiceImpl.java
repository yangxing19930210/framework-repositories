package t5750.tcctransactionboot.sample.dubbo.order.service;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import t5750.tcctransactionboot.sample.dubbo.capital.api.CapitalTradeOrderService;
import t5750.tcctransactionboot.sample.dubbo.capital.api.dto.CapitalTradeOrderDto;
import t5750.tcctransactionboot.sample.dubbo.order.domain.entity.Order;
import t5750.tcctransactionboot.sample.dubbo.order.domain.repository.OrderRepository;
import t5750.tcctransactionboot.sample.dubbo.redpacket.api.RedPacketTradeOrderService;
import t5750.tcctransactionboot.sample.dubbo.redpacket.api.dto.RedPacketTradeOrderDto;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 */
@Service
public class PaymentServiceImpl {
	@Reference
	CapitalTradeOrderService capitalTradeOrderService;
	@Reference
	RedPacketTradeOrderService redPacketTradeOrderService;
	@Autowired
	OrderRepository orderRepository;

	@Compensable(confirmMethod = "confirmMakePayment", cancelMethod = "cancelMakePayment", asyncConfirm = true)
	public void makePayment(Order order, BigDecimal redPacketPayAmount,
			BigDecimal capitalPayAmount) {
		System.out.println("order try make payment called.time seq:"
				+ DateFormatUtils.format(Calendar.getInstance(),
						"yyyy-MM-dd HH:mm:ss"));
		// check if the order status is DRAFT, if no, means that another call
		// makePayment for the same order happened, ignore this call
		// makePayment.
		if (order.getStatus().equals("DRAFT")) {
			order.pay(redPacketPayAmount, capitalPayAmount);
			try {
				orderRepository.updateOrder(order);
			} catch (OptimisticLockingFailureException e) {
				// ignore the concurrently update order exception, ensure
				// idempotency.
			}
		}
		String result = capitalTradeOrderService
				.record(buildCapitalTradeOrderDto(order));
		String result2 = redPacketTradeOrderService
				.record(buildRedPacketTradeOrderDto(order));
	}

	public void confirmMakePayment(Order order, BigDecimal redPacketPayAmount,
			BigDecimal capitalPayAmount) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("order confirm make payment called. time seq:"
				+ DateFormatUtils.format(Calendar.getInstance(),
						"yyyy-MM-dd HH:mm:ss"));
		Order foundOrder = orderRepository.findByMerchantOrderNo(order
				.getMerchantOrderNo());
		// check if the trade order status is PAYING, if no, means another call
		// confirmMakePayment happened, return directly, ensure idempotency.
		if (foundOrder != null && foundOrder.getStatus().equals("PAYING")) {
			order.confirm();
			orderRepository.updateOrder(order);
		}
	}

	public void cancelMakePayment(Order order, BigDecimal redPacketPayAmount,
			BigDecimal capitalPayAmount) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("order cancel make payment called.time seq:"
				+ DateFormatUtils.format(Calendar.getInstance(),
						"yyyy-MM-dd HH:mm:ss"));
		Order foundOrder = orderRepository.findByMerchantOrderNo(order
				.getMerchantOrderNo());
		// check if the trade order status is PAYING, if no, means another call
		// cancelMakePayment happened, return directly, ensure idempotency.
		if (foundOrder != null && foundOrder.getStatus().equals("PAYING")) {
			order.cancelPayment();
			orderRepository.updateOrder(order);
		}
	}

	private CapitalTradeOrderDto buildCapitalTradeOrderDto(Order order) {
		CapitalTradeOrderDto tradeOrderDto = new CapitalTradeOrderDto();
		tradeOrderDto.setAmount(order.getCapitalPayAmount());
		tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
		tradeOrderDto.setSelfUserId(order.getPayerUserId());
		tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
		tradeOrderDto.setOrderTitle(String.format("order no:%s",
				order.getMerchantOrderNo()));
		return tradeOrderDto;
	}

	private RedPacketTradeOrderDto buildRedPacketTradeOrderDto(Order order) {
		RedPacketTradeOrderDto tradeOrderDto = new RedPacketTradeOrderDto();
		tradeOrderDto.setAmount(order.getRedPacketPayAmount());
		tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
		tradeOrderDto.setSelfUserId(order.getPayerUserId());
		tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
		tradeOrderDto.setOrderTitle(String.format("order no:%s",
				order.getMerchantOrderNo()));
		return tradeOrderDto;
	}
}
