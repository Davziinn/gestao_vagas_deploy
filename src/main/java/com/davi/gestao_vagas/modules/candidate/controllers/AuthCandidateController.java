package com.davi.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import com.davi.gestao_vagas.modules.candidate.useCase.AuthCandidateUseCase;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {
    
    // @Autowired
    // private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
        try{
            var token = this.authCandidateUseCase.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // @GetMapping("/")
    // public ResponseEntity<Object> get (HttpServletRequest request) {
    //     var idCandidate = request.getAttribute("candidate_id");
        
    //     try {
    //         var profile = this.profileCandidateUseCase.execute(UUID.fromString(idCandidate.toString()));
    //         return ResponseEntity.status(HttpStatus.OK).body(profile);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    //     }
    // }
}
