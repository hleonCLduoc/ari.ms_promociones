package cl_duoc.ms_promociones.controller;


import cl_duoc.ms_promociones.model.Promocion;
import cl_duoc.ms_promociones.repository.PromocionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PromocionController {

    @Autowired
    private PromocionRepository promocionRepository;

    @GetMapping
    public ResponseEntity<List<Promocion>> listar(){
        List<Promocion> promocions = promocionRepository.findAll();
        if (promocions.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(promocions);

    }
//crea promocion
    @PostMapping
    public ResponseEntity<Promocion> create(@Valid @RequestBody Promocion promocion){
        Promocion nueva = promocionService.guardar(promocion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);

    }

    //*buscar por id
    @GetMapping ("/{id}")
    public ResponseEntity<Promocion> buscarPorId(@PathVariable Long id){}




    //boooooorrar

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Promocion promocionExistente = promocionService.buscarPorId(id);
        if (promocionExistente == null) {
            return ResponseEntity.notFound().build();
        }
        promocionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }



}
