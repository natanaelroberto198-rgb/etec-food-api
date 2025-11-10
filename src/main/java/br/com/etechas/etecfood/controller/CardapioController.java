package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.data.jpa.domain.JpaSort.path;

@RestController
@RequestMapping("/cardapio")
@Validated
public class CardapioController {
    private CardapioRepository cardapioRepository;

    @GetMapping
    public List<Cardapio> select(){
        return cardapioRepository.fildAll();
    }

    @GetMapping("/(id)")
    public ResponseEntity<Cardapio> selectById(@PathVariable long id)  {
        Cardapio obj = this.cardapioRepository.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<Void> criar(@RequestBody Cardapio obj){
        this.cardapioRepository.create(obj);
        Uri uri = ServletUriComponentsBuilder.fromCurrentRequestUri();
        .path("(id)").buildAndExpand(obj.getId).toUi();
                return  ResponseEntity.created(uri).build();
    }

    @PutMapping("/(id)")
    public  ResponseEntity<Void> atualizar(@RequestBody Cardapio obj, @PathVariable long id)(
            obj.setId(id);
            this.CardapioRepository.update(obj);
            return ResponseEntity.noContent().build();
            )

    @DeleteMapping("/(id)")
    public ResponseEntity<Void> deletar(@PathVariable long id)  {
        this.cardapioRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
