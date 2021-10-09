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
import za.ac.nwu.as.logic.flow.CreateMembersFlow;
import za.ac.nwu.as.logic.flow.FetchMembersFlow;
import za.ac.nwu.as.domain.dto.MembersDto;

import java.util.List;


@RestController
@RequestMapping("members")
public class  MembersController {

    private final FetchMembersFlow fetchMembersFlow;
    private final CreateMembersFlow createMembersFlow;

    @Autowired
    public MembersController(FetchMembersFlow fetchMembersFlow, CreateMembersFlow createMembersFlow){
        this.fetchMembersFlow = fetchMembersFlow;
        this.createMembersFlow = createMembersFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Members.", notes = "Returns a list of Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<MembersDto>>> getAll() {
        List<MembersDto> members = fetchMembersFlow.getAllMembers();
        GeneralResponse<List<MembersDto>> response = new GeneralResponse<>(true, members); //IT'S GOT THE CUM
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Member.", notes = "Creates new Member in Database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member was created successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MembersDto>> create(
            @ApiParam(value = "Request body to create a new Member.",
                    required = true)
            @RequestBody MembersDto members) {
        MembersDto membersResponse = createMembersFlow.create(members);
        GeneralResponse<MembersDto> response = new GeneralResponse<>(true, membersResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("{username}")
    @ApiOperation(value = "Gets specified Member.", notes = "Returns specified Member based on Username")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MembersDto>> getMember(
            @ApiParam(value = "Username that identifies Member.",
                    example = "The Irishman",
                    name = "username",
                    required = true)
            @PathVariable("username") final String name) {

        MembersDto members = fetchMembersFlow.getMembersByName(name);
        GeneralResponse<MembersDto> response = new GeneralResponse<>(true, members); //IT'S GOT THE CUM
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}