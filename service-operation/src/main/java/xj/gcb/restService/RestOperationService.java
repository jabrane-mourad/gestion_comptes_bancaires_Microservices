package xj.gcb.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import xj.gcb.dao.OperationRepository;
import xj.gcb.entities.Operation;
import xj.gcb.entities.Retrait;
import xj.gcb.entities.Versement;

import java.util.List;

@RestController
public class RestOperationService {
    @Autowired
    private OperationRepository operationRepository;

    @PostMapping(value = "/addOperation")
    public Operation retait(@RequestBody Operation op) {
        return operationRepository.save(op);
    }

    @GetMapping(value = "/operations")
    public List<Operation> operation(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "20") int size) {
        return operationRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
