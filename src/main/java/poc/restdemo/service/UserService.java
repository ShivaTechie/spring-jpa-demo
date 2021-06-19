package poc.restdemo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.restdemo.model.User;
import poc.restdemo.repo.AddressRepository;
import poc.restdemo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public User findById(Integer id) {

		Optional<User> user = null;
		try {
			user = userRepository.findById(id);
		} catch (Exception e) {
			System.out.println(String.format("Something bad happen!!!"));
			return new User();
		}
		if (user.isPresent())
			return user.get();
		return new User();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public String deleteById(Integer id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return String.format("Operation is not performed because user is not available in the database!!");
		}
		return String.format("User is deleted successfully with id: %d", id);

	}

	public User saveOrUpdateUser(User user, String key) {

		try {
			if (!Objects.isNull(user) && !Objects.isNull(user.getUserId()) && !Objects.isNull(user.getAddress())
					&& !Objects.isNull(user.getAddress().getAddressId()) && key.equalsIgnoreCase("update")) {
				addressRepository.save(user.getAddress());
				return user = userRepository.save(user);
			}

			else if (!Objects.isNull(user) && !Objects.isNull(user.getUserId()) && !Objects.isNull(user.getAddress())
					&& !Objects.isNull(user.getAddress().getAddressId()) && key.equalsIgnoreCase("save")) {
				User existUser = userRepository.findByUserIdAndAddressId(user.getUserId(),
						user.getAddress().getAddressId());
				if (!Objects.isNull(existUser))
					return existUser;
			}
			addressRepository.save(user.getAddress());
			return user = userRepository.save(user);
		} catch (Exception e) {
			System.out.println("Something really bad happen!!!");
			return new User();
		}
	}

}
