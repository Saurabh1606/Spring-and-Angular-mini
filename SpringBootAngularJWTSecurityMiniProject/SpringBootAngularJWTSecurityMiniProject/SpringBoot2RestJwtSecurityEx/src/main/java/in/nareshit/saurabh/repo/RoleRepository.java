package in.nareshit.saurabh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.saurabh.model.ERole;
import in.nareshit.saurabh.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(ERole name);
}
