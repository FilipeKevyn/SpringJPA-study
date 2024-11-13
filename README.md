Esse pequeno projeto, foi feito com o intuito de conhecer mais sobre alguns recursos do JPA.

## Annotation

Ao utilizar o Spring, é bastante importante entender as funcionalidades das anotações desse framework. Para a manipulação de dados, o JPA entrega algumas anotações para poder manipular as relações entre as classes. Aqui vão algumas delas.

`@Entity` - Indica a JVM que a classe é uma entidade.

`@Table` - Indica a criação de uma tabela no banco de dados.

- *name* - com este atributo, podemos dar o nome à tabela.

`@Colum` - Indica que o atributo será uma uma coluna na tabela.

- *nullable* *(true/false)* - indica que o atributo poderá ser - ou não - **vazio** na tabela.
- *unique* *(true/false)* - indica que o atributo poderá ser - ou não - **único** na tabela.

**Relações de classes**

`@OneToOne` - Quando as classes tiverem relação de um para um, esta anotação deve  ser utilizada. Exemplo do projeto:

```java
public class Review {
// Um review tem apenas um livro

	@OneToOne
	private Book book;
}

public class Book {
// Um livro tem apenas um review

	@OneToOne
	private Review review;
}
```

`@OneToMany` - Quando as classes tiverem relação de um para muitos, esta anotação deve  ser utilizada.

`@ManyToOne` - Quando as classes tiverem relação de muitos para um, esta anotação deve  ser utilizada. Exemplo do projeto:

```java
public class Book {
// Vários livros tem apenas uma editora

	@ManyToOne
	private Publisher publisher;
}

public class Publisher {
// Uma editora pode ter vários livros

	@OneToMany
	private Book book;
}
```

`@ManyToMany` - Quando as classes tiverem relação de muitos para muitos, esta anotação deve ser utilizada. Exemplo do projeto:

```java
public class Book {
// Vários livros pode ter vários autores 

	@ManyToMany
	private Set<Author> authors = new HashSet<>();
}

public class Publisher {
// Uma editora pode ter vários livros

	@OneToMany
	private Set<Book> book = new HashSet<>();
}
```
`@JoinColumn` - Quando falamos de banco de dados relacional, precisamos entender que a chave estrangeira também deve ter seu lugar na tabela. O Join Column adiciona uma coluna à tabela fazendo a relação entre as classes.

- *mappedBy* - Define o lado não dominante da relação entre as entidades. Quando usamos `@JoinColumn`, estamos especificando o lado dominante (ou seja, o lado que controla a relação e onde a chave estrangeira é armazenada). Já o atributo *mappedBy* é utilizado na anotação de relação do lado oposto, indicando que essa entidade é a parte não dominante e que a propriedade que mapeia a relação pertence à outra entidade. 

Exemplo:

```java
public class Publisher {
    // Uma editora pode ter vários livros
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}

public class Book {
    // Vários livros têm uma única editora
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
