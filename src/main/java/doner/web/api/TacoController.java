//package doner.web.api;
//
//import doner.DonerOrder;
//import doner.data.OrderRepository;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import doner.Doner;
//import doner.data.DonerRepository;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path="/api/tacos",
//        produces="application/json")
//@CrossOrigin(origins="http://tacocloud:8080")
//public class TacoController {
//    private final DonerRepository donerRepo;
//    private final OrderRepository orderRepo;
//
//    public TacoController(DonerRepository donerRepo, OrderRepository orderRepo) {
//        this.donerRepo = donerRepo;
//        this.orderRepo = orderRepo;
//    }
//    @GetMapping(params="recent")
//    public Iterable<Doner> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        return donerRepo.findAll(page).getContent();
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Doner> tacoById(@PathVariable("id") Long id) {
//        Optional<Doner> optTaco = donerRepo.findById(id);
//        if (optTaco.isPresent()) {
//            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping(consumes="application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Doner postTaco(@RequestBody Doner taco) {
//        return donerRepo.save(taco);
//    }
//
//    @PatchMapping(path="/{orderId}", consumes="application/json")
//    public DonerOrder patchOrder(@PathVariable("orderId") Long orderId,
//                                 @RequestBody DonerOrder patch) {
//        DonerOrder order = orderRepo.findById(orderId).get();
//        if (patch.getDeliveryName() != null) {
//            order.setDeliveryName(patch.getDeliveryName());
//        }
//        if (patch.getDeliveryStreet() != null) {
//            order.setDeliveryStreet(patch.getDeliveryStreet());
//        }
//        if (patch.getDeliveryCity() != null) {
//            order.setDeliveryCity(patch.getDeliveryCity());
//        }
//        if (patch.getCcNumber() != null) {
//            order.setCcNumber(patch.getCcNumber());
//        }
//        if (patch.getCcExpiration() != null) {
//            order.setCcExpiration(patch.getCcExpiration());
//        }
//        if (patch.getCc_CVV() != null) {
//            order.setCc_CVV(patch.getCc_CVV());
//        }
//        return orderRepo.save(order);
//    }
//
//    @DeleteMapping("/{orderId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteOrder(@PathVariable("orderId") Long orderId) {
//        try {
//            orderRepo.deleteById(orderId);
//        } catch (EmptyResultDataAccessException e) {}
//    }
//}