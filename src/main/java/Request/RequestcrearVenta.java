/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */

@Getter
@Setter
public class RequestcrearVenta { 
    private Date fechaventa;
    private Integer idcliente;
    private BigDecimal total;
    private List<RequestcrearDetalleVenta> detalles;
}
