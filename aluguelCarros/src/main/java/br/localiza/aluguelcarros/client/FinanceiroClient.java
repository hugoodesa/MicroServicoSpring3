package br.localiza.aluguelcarros.client;

import br.localiza.aluguelcarros.DTO.TransacaoFinaceiraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-financeiro")
public interface FinanceiroClient {

    @RequestMapping(method = RequestMethod.POST,value = "/financeiro")
    void cadastrarTransacao (@RequestBody TransacaoFinaceiraDTO valor);

}
