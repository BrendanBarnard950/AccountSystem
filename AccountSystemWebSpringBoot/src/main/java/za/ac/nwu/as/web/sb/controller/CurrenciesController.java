package za.ac.nwu.as.web.sb.controller;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateCurrenciesFlow;
import za.ac.nwu.as.logic.flow.FetchCurrenciesFlow;
import za.ac.nwu.as.domain.dto.CurrenciesDto;

import java.util.List;


@RestController
@RequestMapping("currencies")
public class  CurrenciesController {

    private final FetchCurrenciesFlow fetchCurrenciesFlow;
    private final CreateCurrenciesFlow createCurrenciesFlow;

    @Autowired
    public CurrenciesController(FetchCurrenciesFlow fetchCurrenciesFlow, CreateCurrenciesFlow createCurrenciesFlow){
        this.fetchCurrenciesFlow = fetchCurrenciesFlow;
        this.createCurrenciesFlow = createCurrenciesFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Currencies.", notes = "Returns a list of Currencies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currencies returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<CurrenciesDto>>> getAll() {
        List<CurrenciesDto> currencies = fetchCurrenciesFlow.getAllCurrencies();
        GeneralResponse<List<CurrenciesDto>> response = new GeneralResponse<>(true, currencies);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Currencies.", notes = "Creates new Currencies in Database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Currencies was created successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<CurrenciesDto>> create(
            @ApiParam(value = "Request body to create a new Currency.",
                    required = true)
            @RequestBody CurrenciesDto currencies) {
        CurrenciesDto currenciesResponse = createCurrenciesFlow.create(currencies);
        GeneralResponse<CurrenciesDto> response = new GeneralResponse<>(true, currenciesResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Gets specified Currency.", notes = "Returns specified Currency based on Mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<CurrenciesDto>> getCurrencies(
            @ApiParam(value = "Mnemonic that identifies Currency.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {

        CurrenciesDto currencies = fetchCurrenciesFlow.getCurrenciesByName(mnemonic);
        GeneralResponse<CurrenciesDto> response = new GeneralResponse<>(true, currencies);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}