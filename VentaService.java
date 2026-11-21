package co.ayb.auth.service;
import co.ayb.auth.dto.VentaRequest; import co.ayb.auth.model.*; import co.ayb.auth.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.math.BigDecimal; import java.util.*;
@Service public class VentaService {
 private final VentaRepository ventas; private final ProductoRepository productos; private final ClienteRepository clientes;
 public VentaService(VentaRepository v,ProductoRepository p,ClienteRepository c){ventas=v;productos=p;clientes=c;}
 public List<Venta> listar(){return ventas.findAll();}
 @Transactional public Venta crear(VentaRequest req){
  Cliente cliente=null;if(req.getClienteId()!=null)cliente=clientes.findById(req.getClienteId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente no encontrado"));
  BigDecimal total=BigDecimal.ZERO;List<String> lineas=new ArrayList<>();
  for(VentaRequest.Item item:req.getItems()){
   Producto p=productos.findById(item.getProductoId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Producto no encontrado: "+item.getProductoId()));
   if(p.getStock()<item.getCantidad())throw new ResponseStatusException(HttpStatus.CONFLICT,"Stock insuficiente para "+p.getNombre());
   p.setStock(p.getStock()-item.getCantidad());productos.save(p);
   BigDecimal subtotal=p.getPrecio().multiply(BigDecimal.valueOf(item.getCantidad()));total=total.add(subtotal);lineas.add(p.getNombre()+" x"+item.getCantidad()+" = "+subtotal);
  }
  return ventas.save(new Venta(cliente,total,String.join("; ",lineas)));
 }
}
