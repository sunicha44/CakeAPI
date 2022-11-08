package th.ac.ku.cakeAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.cakeAPI.model.Cakes;
import th.ac.ku.cakeAPI.repository.CakesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CakesService {

    @Autowired
    private CakesRepository repository;

    public List<Cakes> getAll(){
        return repository.findAll();
    }

    public Cakes create(Cakes cakes){
        repository.save(cakes);
        return cakes;
    }

    public Cakes getCakes(UUID id){
        return repository.findById(id).get();
    }

    public Cakes update(UUID id, Cakes requestBody){
        Cakes record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setWeight(requestBody.getWeight());
        record.setPrice(requestBody.getPrice());
        record.setAmount(requestBody.getAmount());

        repository.save(record);
        return record;
    }

    public Cakes delete(UUID id){
        Cakes record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
