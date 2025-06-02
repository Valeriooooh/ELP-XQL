# XML Query Language

Este projeto implementa avisos com mensagens informativas para vários tipos de erros, com o objetivo de auxiliar o
utilizador a encontrar problemas no seu código XQL.

## Erros de compilação ("BUILD ERROR"):
- Utilização de referências a variáveis não declaradas anteriormente
- Utilização de argumentos com um número diferente dos existentes

## Erros de execução ("RUNTIME ERROR"):
- Utilização de um offset superior ao número de elementos do objeto da operação
- Referência a elementos inexistentes no documento XML passado por parâmetro
- Utilização de uma operação de soma sobre elementos não inteiros
- Utilização de uma operação de soma sobre elementos XML inválidos neste contexto, como tags
- Utilização de uma operação de soma sobre um objeto que não é uma lista
- Utilização de uma composição (operador ".") sobre um elemento que não uma tag (ex: "doc.course[0].code.any", onde
"code" é um atributo)
- Utilização de uma operação de mapeamento sobre um objeto que não é uma lista
- Utilização de um operação de contagem sobre elementos XML inválidos neste contexto, como atributos