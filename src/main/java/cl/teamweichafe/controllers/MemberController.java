package cl.teamweichafe.controllers;

import cl.teamweichafe.common.dtos.MemberDto;
import cl.teamweichafe.services.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request Succeeded",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = MemberDto.class)) }),
        @ApiResponse(responseCode = "201", description = "Resource Created",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = MemberDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found",
                content = @Content) ,
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = @Content)})
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "Endpoint to add a member")
    @PostMapping
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto) {

        return ResponseEntity.ok(this.memberService.saveMember(memberDto));
    }

    @Operation(summary = "Endpoint to get a member by id")
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getById(@PathVariable String id) {

        return ResponseEntity.ok(this.memberService.getById(id));
    }

    @Operation(summary = "Endpoint to get a member by degree id")
    @GetMapping("/degree/{id}")
    public ResponseEntity<List<MemberDto>> getByDegreeId(@PathVariable String id) {

        return ResponseEntity.ok(this.memberService.getByDegreeId(id));
    }

    @Operation(summary = "Endpoint to get a member by class id")
    @GetMapping("/class/{id}")
    public ResponseEntity<List<MemberDto>> getByClassId(@PathVariable String id) {

        return ResponseEntity.ok(this.memberService.getByClassId(id));
    }

    @Operation(summary = "Endpoint to update a member by id")
    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> update(@PathVariable String id, @RequestBody MemberDto memberDto) {

        return ResponseEntity.ok(this.memberService.updateMember(id, memberDto));
    }

    @Operation(summary = "Endpoint to get all members")
    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {

        return ResponseEntity.ok(this.memberService.getAllMembers());
    }

    @Operation(summary = "Endpoint to delete a member by id")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        this.memberService.delete(id);
        return ResponseEntity.ok().build();
    }
}
