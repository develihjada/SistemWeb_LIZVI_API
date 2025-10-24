/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */

@Getter
@Setter
public class RequestcrearDetalleVenta {
    private Integer idproducto;
    private BigDecimal cantidad;
    private BigDecimal subtotal;
}
