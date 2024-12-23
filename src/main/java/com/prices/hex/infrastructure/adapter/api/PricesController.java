package com.prices.hex.infrastructure.adapter.api;

import com.prices.hex.application.port.api.PricesUseCase;
import com.prices.hex.infrastructure.adapter.api.dto.PriceResponseDto;
import com.prices.hex.infrastructure.adapter.api.mapper.PriceMapper;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PricesUseCase pricesService;
    
    private final PriceMapper priceMapper;
    
    public PricesController(PricesUseCase pricesService, PriceMapper priceMapper) {
        this.pricesService = pricesService;
        this.priceMapper = priceMapper;
    } 

    @Operation(
        summary = "Listado de todos los precios",
        description = "Devuelve una lista de todos los precios disponibles",
        responses = {
            @ApiResponse(responseCode = "200", description = "Listado de precios", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponseDto.class))),
        }
    )    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceResponseDto> getAll() {
        return pricesService.findAll().stream()
            .map(priceMapper::toPriceResponseDto)
            .collect(Collectors.toList());        
    }
    
    @Operation(
        summary = "Obtener el precio actual de un producto",
        description = "Devuelve el ultimo precio disponible para un producto de una marca segun la fecha proporcionada",
        parameters = {
            @Parameter(name = "brandId", description = "ID de la marca", required = true, example = "1"),
            @Parameter(name = "productId", description = "ID del producto", required = true, example = "35455"),
            @Parameter(name = "date", description = "Fecha en formato ISO (yyyy-MM-dd'T'HH:mm:ss)", required = true, example = "2020-06-15T18:30:00")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Precio encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontro el precio para la fecha y producto especificados"),
        }
    )
    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponseDto> findPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        return new ResponseEntity<>(priceMapper.toPriceResponseDto(pricesService.findPrice(brandId, productId, date)),
                                    HttpStatus.OK);
    }
    
}
