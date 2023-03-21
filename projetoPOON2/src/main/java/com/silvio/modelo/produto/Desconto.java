package com.silvio.modelo.produto;

import org.springframework.stereotype.Component;

@Component
public interface Desconto {

	void DescontoAplicado(Double desconto);
}
