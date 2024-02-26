package dataTransferCommProject.example.RestApis.repo;

import dataTransferCommProject.example.RestApis.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Long> {

}
