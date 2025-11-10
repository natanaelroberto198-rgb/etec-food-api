package br.com.etechas.etecfood.controller;


import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.entity.ItemCardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;
import br.com.etechas.etecfood.repository.ItemCardapioRepository;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@RestController
@RequestMapping("/itemCardapio")
@Validated
public class ItemCardapioController {
    private ItemCardapioRepository itemCardapioRepository;

    @GetMapping
    public List<ItemCardapio> select(){
        return itemCardapioRepository.fildAll();
    }

    @GetMapping("/(id)")
    public ResponseEntity<Cardapio> selectById(@PathVariable long id)  {
        Cardapio obj = this.itemCardapioRepository.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<Void> criar(@RequestBody ItemCardapio obj){
        this.itemCardapioRepository.create(obj);
        Uri uri = ServletUriComponentsBuilder.fromCurrentRequestUri();
        .path("(id)").buildAndExpand(obj.getId).toUi();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping("/(id)")
    public  ResponseEntity<Void> atualizar(@RequestBody ItemCardapio obj, @PathVariable long id)(
            obj.setId(id);
            this.ItemCardapioRepository.update(obj);
    return ResponseEntity.noContent().build();
            )

    @DeleteMapping("/(id)")
    public ResponseEntity<Void> deletar(@PathVariable long id)  {
        this.itemCardapioRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
