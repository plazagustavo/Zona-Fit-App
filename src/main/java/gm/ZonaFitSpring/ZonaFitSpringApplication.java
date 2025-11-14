package gm.ZonaFitSpring;

import gm.ZonaFitSpring.Modelo.Cliente;
import gm.ZonaFitSpring.Servicio.IClienteServicio;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZonaFitSpringApplication implements CommandLineRunner {
    
        @Autowired
        private IClienteServicio clienteServicio;
        
        
        private static final Logger logger = 
                LoggerFactory.getLogger(ZonaFitSpringApplication.class); // para enviar info a la consola
        
        String nl = System.lineSeparator();
        
        
	public static void main(String[] args) {
                logger.info("==== Iniciando la aplicacion ====");
            
		SpringApplication.run(ZonaFitSpringApplication.class, args);
                
                logger.info("**** Aplicacion finalizada! ****");
                
                
  
                
                
	}

    @Override
    public void run(String... args) throws Exception {
        zonaFitApp();
        
        
    }
    
    private void zonaFitApp(){
       var salir = false;
       var sc  = new Scanner(System.in);
       while(!salir){
           var opcion = mostrarMenu(sc);
           salir = ejecutarOpciones(sc, opcion);
           logger.info(nl);
       }   
    }
    
    private int mostrarMenu(Scanner sc){
        logger.info(nl +"""
                *** APLICACION ZONA FIT (GYM) ***
                    1. Listar clientes
                    2. Buscar cliente
                    3. Agregar cliente
                    4. Modificar cliente
                    5. Eliminar cliente
                    6. Salir
                    Elige una opcion: \s """);
        
        return Integer.parseInt(sc.nextLine());
            
    }
    
    private boolean ejecutarOpciones(Scanner sc, int opcion){
        var salir = false;
        switch(opcion){
            case 1 ->{
                logger.info(nl + "-- Listado de clientes --" + nl);
                List<Cliente> clientes = clienteServicio.listarCliente();
                clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
            }
            case 2 ->{
                logger.info(nl + "Proporciona el id del cliente: " + nl);
                var idCliente = Integer.parseInt(sc.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if (cliente != null){
                    logger.info(cliente + nl);
                }
                else{
                    logger.info("Cliente con id '" + idCliente + "' NO encontrado! ");
                }
            }
            case 3 ->{
                logger.info(nl + "-- Agregar cliente --" + nl);
                logger.info("Nombre: ");
                var nombre = sc.nextLine();
                logger.info("Apellido: ");
                var apellido = sc.nextLine();
                logger.info("Membresia: ");
                var membresia = Integer.parseInt(sc.nextLine());
                
                var cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setMembresia(membresia);
                clienteServicio.guardarCliente(cliente);
                logger.info("Cliente agregado" + nl + cliente);
                
            }
            case 4 ->{
                logger.info(nl + "-- Modificar cliente --" +  nl);
                logger.info("ID cliente: ");
                var idCliente = Integer.parseInt(sc.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if( cliente != null ){
                    logger.info("Nombre: ");
                    var nombre = sc.nextLine();
                    logger.info("Apellido: ");
                    var apellido = sc.nextLine();
                    logger.info("Membresia: ");
                    var membresia = sc.nextLine();
                    
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setMembresia(idCliente);
                    
                    clienteServicio.guardarCliente(cliente);
                    logger.info(nl + "Cliente modificado" + nl + cliente);
                }
                else{
                    logger.info("Cliente " + idCliente +  " NO ENCONTRADO");
                }
            }
            case 5 ->{
                logger.info(nl + "-- Eliminar cliente -- " + nl);
                logger.info("ID Cliente :");
                var idCliente = Integer.parseInt(sc.nextLine());
                var cliente = clienteServicio.buscarClientePorId(idCliente);
                if(cliente != null ){
                    clienteServicio.eliminarCliente(cliente);
                    logger.info("Cliente eliminado con exito!" + nl + cliente);
                }else{
                    logger.info("NO se encontro el cliente con ID: " + cliente);
                }
                
            }
            case 6 -> {
                salir = true;
            }
            default ->{
                logger.info("OPCION NO RECONOCIDA" + opcion + nl + "SELECCIONE UN NUMERO DEL (1 al 6)" + nl);
            }
            
        }
        return salir;
    }

        
     
}


