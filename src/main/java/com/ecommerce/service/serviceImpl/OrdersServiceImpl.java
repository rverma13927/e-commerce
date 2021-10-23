package com.ecommerce.service.serviceImpl;

import com.ecommerce.Repository.OrderDetailsRepository;
import com.ecommerce.Repository.OrdersRepository;
import com.ecommerce.dto.RequestDto.OrderDetailsRequestDto;
import com.ecommerce.dto.RequestDto.OrderRequestDto;
import com.ecommerce.dto.ResponseMessageDto;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.OrderDetails;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;
import com.ecommerce.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository, OrderDetailsRepository orderDetailsRepository) {
        this.ordersRepository = ordersRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public Orders getOrderDetailById(Integer order_id) {
        return ordersRepository.findById(order_id).orElse(null);
    }

    @Override
    public ResponseMessageDto saveOrderDetail(OrderRequestDto orders) {
        Customer customer = new Customer();
        customer.setCustomer_id(orders.getCustomer_id());
        Orders orders_ = new Orders(customer,orders.getAmount(),orders.getShipping_Address(),orders.getOrder_email(),orders.getOrder_phone(),orders.getOrder_status());

        List<OrderDetailsRequestDto> orderDetailsRequestDtos = orders.getOrderDetailsRequestDtos();
        List<OrderDetails> orderDetailsToSave = new ArrayList<>();
        for(OrderDetailsRequestDto orderDetailsRequestDto : orderDetailsRequestDtos){
            Product product = new Product();
            product.setProduct_id(orderDetailsRequestDto.getProduct_id());
            Orders ordersTOSave = new Orders();
            ordersTOSave.setOrder_id(orders.getOrder_id());
            OrderDetails orderDetails = new OrderDetails(product,ordersTOSave,orderDetailsRequestDto.getQuantity(),orderDetailsRequestDto.getBuying_price());
            orderDetailsToSave.add(orderDetails);
        }
        orderDetailsRepository.saveAll(orderDetailsToSave);
        ordersRepository.save(orders_);

        return new ResponseMessageDto("Order saved successfully",true);
    }
}
