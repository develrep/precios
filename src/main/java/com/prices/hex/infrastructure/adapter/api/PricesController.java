package com.prices.hex.infrastructure.adapter.api;

import com.prices.hex.application.port.api.PricesUseCase;
import com.prices.hex.infrastructure.dto.PriceDto;
import com.prices.hex.infrastructure.adapter.persistence.entity.Price;
import com.prices.hex.infrastructure.mapper.PriceMapper;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @Autowired
    private PricesUseCase pricesUseCase;
    
    @Autowired
    private PriceMapper priceMapper;    
    
    @Operation(
        summary = "Obtener el precio actual de un producto",
        description = "Devuelve el ultimo precio disponible para un producto de una marca segun la fecha proporcionada",
        parameters = {
            @Parameter(name = "brandId", description = "ID de la marca", required = true, example = "1"),
            @Parameter(name = "productId", description = "ID del producto", required = true, example = "35455"),
            @Parameter(name = "date", description = "Fecha en formato ISO (yyyy-MM-dd'T'HH:mm:ss)", required = true, example = "2020-06-15T18:30:00")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Precio encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontro el precio para la fecha y producto especificados"),
        }
    )
    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDto> findPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        Price currentPrice = pricesUseCase.findPrice(brandId, productId, date);

        PriceDto response = priceMapper.toResponse(currentPrice);

        // Si no se ha encontrado un precio se devuelve 404 lanzando PriceNotFoundException
        // Si se ha encontrado se devuelve 200
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
