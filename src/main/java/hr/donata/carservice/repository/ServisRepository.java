package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Client;
import hr.donata.carservice.entity.Servis;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("servis")
@Component
@Repository
public interface ServisRepository extends JpaRepository<Servis, Long> {

    //List<Servis> findAllByDateOfService (Long servisId);

}
