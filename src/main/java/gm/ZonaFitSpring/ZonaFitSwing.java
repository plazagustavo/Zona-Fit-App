package gm.ZonaFitSpring;

import com.formdev.flatlaf.FlatDarculaLaf;

import gm.ZonaFitSpring.Servicio.igu.ZonaFitForma;
import javax.swing.SwingUtilities;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ZonaFitSwing {
    public static void main(String[] args) {
        
        FlatDarculaLaf.setup();
        
        
        ConfigurableApplicationContext contextSpring = new SpringApplicationBuilder(ZonaFitSwing.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        

        
        SwingUtilities.invokeLater(() -> {
            ZonaFitForma princ = contextSpring.getBean(ZonaFitForma.class);
            
            // 3. Configurar y Mostrar
            princ.setVisible(true);
            princ.setLocationRelativeTo(null);
        });
    }
    
    
}
