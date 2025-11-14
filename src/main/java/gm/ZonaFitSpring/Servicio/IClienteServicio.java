
package gm.ZonaFitSpring.Servicio;

import gm.ZonaFitSpring.Modelo.Cliente;
import java.util.List;



public interface IClienteServicio {
    public List<Cliente> listarCliente();
    
    public Cliente buscarClientePorId(Integer idCliente);
    
    public void guardarCliente(Cliente cliente); // Inserta y actualiza
    
    public void eliminarCliente(Cliente cliente);
    
    
}
