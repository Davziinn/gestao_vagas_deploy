package com.davi.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.gestao_vagas.exceptions.UserNotFoundException;
import com.davi.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.davi.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
            .description(candidate.getDescription())
            .username(candidate.getUsername())
            .email(candidate.getEmail())
            .id(candidate.getId())
            .name(candidate.getName())
            .build();
            
        return candidateDTO;
    }
}
