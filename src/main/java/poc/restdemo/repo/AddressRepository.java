package poc.restdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.restdemo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
