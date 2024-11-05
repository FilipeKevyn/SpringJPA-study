Esse pequeno projeto, foi feito com o intuito de conhecer mais sobre alguns recursos do JPA.

## Annotation

Ao utilizar o Spring, é bastante importante entender as funcionalidades das anotações desse framework. Para a manipulação de dados, o JPA entrega algumas anotações para poder manipular as relações entre as classes. Aqui vão algumas delas.

`@Entity` - Indica a JVM que a classe é uma entidade.

`@Table` - Indica a criação de uma tabela no banco de dados.

- *name* - com este atributo, podemos dar o nome à tabela.

`@Colum` - Indica que o atributo será uma uma coluna na tabela.

- *nullable* *(true/false)* - indica que o atributo poderá ser - ou não - **vazio** na tabela.
- *unique* *(true/false)* - indica que o atributo poderá ser - ou não - ú**nico** na tabela.

**Relações de classes**

`@JoinColumn` - Quando falamos de banco de dados relacional, precisamos entender que a chave estrangeira também deve ter seu lugar na tabela. O Join Column adiciona uma coluna à tabela fazendo a relação entre as classes.

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
	private Book book;
}
```

`@JoinTable` - No caso de relações *many to many,* é necessário construir uma tabela auxiliar para armazenar os dados a partir dessa relação, e declarando essa anotação conseguimos criar a tabela de acordo com os atributos abaixo:

- *name* - Adiciona o nome da tabela.
- joinColumns - Junto da anotação `@JoinColumn` adiciona uma coluna à tabela.
