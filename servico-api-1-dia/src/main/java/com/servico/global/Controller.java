package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired  //Autowired = responsavel por executar comandos previamente disponiveis do repositorio
	private ServicoRepository repository;

	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos(){
		return repository.findAll();
	}
	
	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {   //@RequestMapping(value="/servicos", method=RequestMethod.POST)
		/*public @ResponseBody ProdutoModelo 
		 * cadastrar(@RequestBody ProdutoModelo produto){
		return acoes.save(produto);*/
		repository.save(model);
		return model;
	}
}
