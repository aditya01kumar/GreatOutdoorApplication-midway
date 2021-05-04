package com.cg.goa.api;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.goa.exception.OrderException;
import com.cg.goa.model.OrderModel;
import com.cg.goa.service.IOrderService;

@RestController
@RequestMapping(path = "/OrderEntity")
public class OrderApi {

	@Autowired
	private IOrderService orderservice;
	
	/*
	 * to list orders by UserId
	 * return : List<Order>
	 * params : userId
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<List<OrderModel>> findOrdersByUserId(@PathVariable("userId")String userId) {
		//ResponseEntity<List<OrderModel>> response = null;
		return ResponseEntity.ok(orderservice.findOrdersByUserId(userId));
		// response;
	}
	/*
	 * to list allorders
	 * return : list
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<OrderModel>> findAllOrders() {
		return ResponseEntity.ok(orderservice.findAllOrders());
	}

	
	/*
	 * to add new order
	 * return : orderEntity
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<OrderModel> addOrder(@RequestBody OrderModel orderEntity) throws OrderException {
		orderEntity = orderservice.addOrder(orderEntity);

		return new ResponseEntity<>(orderEntity, HttpStatus.CREATED);

	}

	
	/*
	 * to delete All orders
	 * return : Boolean
	 * params : NIL
	 */
	@DeleteMapping
	public ResponseEntity<Boolean> deleteAllOrders() throws OrderException {
		return ResponseEntity.ok(orderservice.deleteAllOrders());

	}
	/*
	 * to updateDate id, dates
	 * return : Boolean
	 * params : orderId, dispatchDate,arrivalDate
	 */
	@PutMapping("/{oid},{diD},{deD}")
	public ResponseEntity<Boolean> updateDate(@PathVariable("oid") Integer orderId, @PathVariable("diD")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime dispatchDate, @PathVariable("deD")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate)
			throws OrderException {
		Boolean p = orderservice.updateDate(orderId, dispatchDate, arrivalDate);
		return ResponseEntity.ok(p);

	}
	/*
	 * to deleteOrderByorderId
	 * return : Boolean
	 * params : orderId
	 */
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Boolean> deleteOrderById(@PathVariable("orderId") Integer orderId)
			throws OrderException {
		Boolean p =orderservice.deleteOrderById(orderId);;
		
		return ResponseEntity.ok(p);
			
	
	}
}
