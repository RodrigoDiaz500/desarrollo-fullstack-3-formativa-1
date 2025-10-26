package cl.duoc.semana1.controlador;



import cl.duoc.semana1.modelo.Libro;
import cl.duoc.semana1.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros") // Ruta base para todos los endpoints
public class LibroController {

    @Autowired
    private LibroService libroService;

    // POST: Agregar un nuevo libro
    // Endpoint: POST /api/libros
    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardarLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    // GET: Obtener la información de un libro por su ID
    // Endpoint: GET /api/libros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id)
                .map(libro -> new ResponseEntity<>(libro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // PUT: Actualizar la información de un libro existente
    // Endpoint: PUT /api/libros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Libro libroActualizado = libroService.actualizarLibro(id, libro);
        if (libroActualizado != null) {
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE: Eliminar un libro de la base de datos por su ID
    // Endpoint: DELETE /api/libros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        // Se recomienda una verificación de existencia, pero para simplicidad, se omite.
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}