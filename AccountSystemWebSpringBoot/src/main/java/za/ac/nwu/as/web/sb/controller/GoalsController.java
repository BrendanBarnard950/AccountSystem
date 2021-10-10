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
import za.ac.nwu.as.logic.flow.CreateGoalsFlow;
import za.ac.nwu.as.logic.flow.FetchGoalsFlow;
import za.ac.nwu.as.logic.flow.CashGoalFlow;
import za.ac.nwu.as.domain.dto.GoalsDto;

import java.util.List;


@RestController
@RequestMapping("goals")
public class  GoalsController {

    private final FetchGoalsFlow fetchGoalsFlow;
    private final CreateGoalsFlow createGoalsFlow;
    private final CashGoalFlow cashGoalFlow;

    @Autowired
    public GoalsController(FetchGoalsFlow fetchGoalsFlow, CreateGoalsFlow createGoalsFlow, CashGoalFlow cashGoalFlow){
        this.fetchGoalsFlow = fetchGoalsFlow;
        this.createGoalsFlow = createGoalsFlow;
        this.cashGoalFlow = cashGoalFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Goals.", notes = "Returns a list of Goals")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goals returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<GoalsDto>>> getAll() {
        List<GoalsDto> goals = fetchGoalsFlow.getAllGoals();
        GeneralResponse<List<GoalsDto>> response = new GeneralResponse<>(true, goals); //IT'S GOT THE CUM
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("{name}")
    @ApiOperation(value = "Gets specified goals.", notes = "Returns specified goals based on name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<GoalsDto>> getGoals(
            @ApiParam(value = "Name of the goal.",
                    example = "10KRun",
                    name = "name",
                    required = true)
            @PathVariable("name") final String partner) {

        GoalsDto goals = fetchGoalsFlow.getGoalsByName(partner);
        GeneralResponse<GoalsDto> response = new GeneralResponse<>(true, goals); //IT'S GOT THE CUM
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("create")
    @ApiOperation(value = "Creates new Goals.", notes = "Creates new Goals in Database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Goals was created successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<GoalsDto>> create(
            @ApiParam(value = "Request body to create a new Goals.",
                    required = true)
            @RequestBody GoalsDto goals) {
        GoalsDto goalsResponse = createGoalsFlow.create(goals);
        GeneralResponse<GoalsDto> response = new GeneralResponse<>(true, goalsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("cashin")
    @ApiOperation(value = "Cashes in Goal.", notes = "Exchanges goal for Miles")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Goals was cahsed in successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> cashIn(
            @ApiParam(value = "Request body to cash in Goal.",
                    required = true)
            @RequestBody String goalID, String username) {
        String goalsResponse = cashGoalFlow.cashGoal(goalID, username);
        GeneralResponse<String> response = new GeneralResponse<>(true, goalsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}