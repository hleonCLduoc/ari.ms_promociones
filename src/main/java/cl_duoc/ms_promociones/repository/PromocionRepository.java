package cl_duoc.ms_promociones.repository;

import cl_duoc.ms_promociones.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public class PromocionRepository extends JpaRepository<Promocion> {
}
