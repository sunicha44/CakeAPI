package th.ac.ku.cakeAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.cakeAPI.model.CakesOrder;
import th.ac.ku.cakeAPI.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<CakesOrder> getAll(){
        return repository.findAll();
    }

    public CakesOrder create (CakesOrder order){
        repository.save(order);
        return order;
    }

    public CakesOrder getOrder(UUID id) {
        return repository.findById(id).get();
    }

    public CakesOrder update(UUID id, CakesOrder requestBody){

        CakesOrder record = repository.findById(id).get();
        record.setDate(requestBody.getDate());
        record.setName(requestBody.getName());
        record.setMobile(requestBody.getMobile());
        record.setAddress(requestBody.getAddress());
        record.setCakes(requestBody.getCakes());
        record.setAmount(requestBody.getAmount());
        record.setUsername(requestBody.getUsername());
        record.setPayment(requestBody.getPayment());
        record.setPrice(requestBody.getPrice());
        record.setStatus(requestBody.getStatus());

        repository.save(record);
        return record;
    }

    public CakesOrder delete(UUID id){
        CakesOrder record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }



}
