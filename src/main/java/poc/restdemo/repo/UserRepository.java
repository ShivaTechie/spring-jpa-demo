package poc.restdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poc.restdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(nativeQuery = true, value = "select * from User_Table  where user_id= ?1 and address_address_id= ?2")
	public User findByUserIdAndAddressId(int userId, int addressId);

}
