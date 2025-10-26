package cl.duoc.semana1.servicio;



import cl.duoc.semana1.modelo.Libro;
import cl.duoc.semana1.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // POST: Agregar nuevo libro
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // GET: Obtener por ID
    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    // PUT: Actualizar libro
    public Libro actualizarLibro(Long id, Libro detallesLibro) {
        return libroRepository.findById(id).map(libroExistente -> {
            libroExistente.setTitulo(detallesLibro.getTitulo());
            libroExistente.setAutor(detallesLibro.getAutor());
            libroExistente.setAnioPublicacion(detallesLibro.getAnioPublicacion());
            libroExistente.setGenero(detallesLibro.getGenero());
            return libroRepository.save(libroExistente);
        }).orElse(null); // Retorna null si no existe, idealmente se manejan excepciones.
    }

    // DELETE: Eliminar por ID
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}