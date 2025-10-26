package cl.duoc.semana1.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data; // Anotación de Lombok para getters, setters, toString, etc.
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "LIBROS") 
@Data // Genera getters y setters
@NoArgsConstructor // Genera constructor sin argumentos
@AllArgsConstructor // Genera constructor con todos los argumentos
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // ID del libro

    private String titulo; // Título
    private String autor; // Autor
    private Integer anioPublicacion; // Año de publicación
    private String genero; // Género
    
    
}