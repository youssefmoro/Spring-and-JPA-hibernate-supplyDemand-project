package dataTransferCommProject.example.RestApis.repo;

import dataTransferCommProject.example.RestApis.models.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface InventoryRepo extends JpaRepository<InventoryModel,Long> {
}
