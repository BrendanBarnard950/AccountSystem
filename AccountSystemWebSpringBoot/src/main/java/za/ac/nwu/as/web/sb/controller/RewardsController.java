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
import za.ac.nwu.as.logic.flow.CreateRewardsFlow;
import za.ac.nwu.as.logic.flow.FetchRewardsFlow;
import za.ac.nwu.as.logic.flow.RedeemRewardsFlow;
import za.ac.nwu.as.domain.dto.RewardsDto;

import java.util.List;


@RestController
@RequestMapping("rewards")
public class  RewardsController {

    private final FetchRewardsFlow fetchRewardsFlow;
    private final CreateRewardsFlow createRewardsFlow;
    private final RedeemRewardsFlow redeemRewardsFlow;

    @Autowired
    public RewardsController(FetchRewardsFlow fetchRewardsFlow, CreateRewardsFlow createRewardsFlow, RedeemRewardsFlow redeemRewardsFlow){
        this.fetchRewardsFlow = fetchRewardsFlow;
        this.createRewardsFlow = createRewardsFlow;
        this.redeemRewardsFlow = redeemRewardsFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Rewards.", notes = "Returns a list of Rewards")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Rewards returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<RewardsDto>>> getAll() {
        List<RewardsDto> currencies = fetchRewardsFlow.getAllRewards();
        GeneralResponse<List<RewardsDto>> response = new GeneralResponse<>(true, currencies);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("{partner}")
    @ApiOperation(value = "Gets specified Reward.", notes = "Returns specified Reward based on Partner")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "partner found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<RewardsDto>> getRewards(
            @ApiParam(value = "Partner that Supplies Rewards.",
                    example = "Woolworths",
                    name = "partner",
                    required = true)
            @PathVariable("partner") final String partner) {

        RewardsDto rewards = fetchRewardsFlow.getRewardsByPartner(partner);
        GeneralResponse<RewardsDto> response = new GeneralResponse<>(true, rewards);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("create")
    @ApiOperation(value = "Creates new Rewards.", notes = "Creates new Rewards in Database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rewards was created successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<RewardsDto>> create(
            @ApiParam(value = "Request body to create a new Reward.",
                    required = true)
            @RequestBody RewardsDto currencies) {
        RewardsDto currenciesResponse = createRewardsFlow.create(currencies);
        GeneralResponse<RewardsDto> response = new GeneralResponse<>(true, currenciesResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("redeem")
    @ApiOperation(value = "Redeems a Reward.", notes = "Exchanges reward for Miles")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Reward was claimed successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> redeem(
            @ApiParam(value = "Request body to Redeem Reward.",
                    required = true)
            @RequestBody String goalID, String username) {
        String goalsResponse = redeemRewardsFlow.redeemReward(goalID, username);
        GeneralResponse<String> response = new GeneralResponse<>(true, goalsResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}