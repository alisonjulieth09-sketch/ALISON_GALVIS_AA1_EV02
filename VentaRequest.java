package co.ayb.auth.dto;
import jakarta.validation.constraints.*; import jakarta.validation.Valid; import java.util.List;
public class VentaRequest {
 private Long clienteId;
 @NotEmpty private List<@Valid Item> items;
 public Long getClienteId(){return clienteId;} public void setClienteId(Long v){clienteId=v;} public List<Item> getItems(){return items;} public void setItems(List<Item> v){items=v;}
 public static class Item { @NotNull @Positive private Long productoId; @NotNull @Min(1) private Integer cantidad;
 public Long getProductoId(){return productoId;} public void setProductoId(Long v){productoId=v;} public Integer getCantidad(){return cantidad;} public void setCantidad(Integer v){cantidad=v;} }
}
