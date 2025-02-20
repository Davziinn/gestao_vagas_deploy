package com.davi.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.gestao_vagas.exceptions.JobNotFoundException;
import com.davi.gestao_vagas.exceptions.UserNotFoundException;
import com.davi.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.davi.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import com.davi.gestao_vagas.modules.candidate.repository.CandidateRepository;
import com.davi.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
            .orElseThrow(() -> {
                throw new UserNotFoundException();
            });

        this.jobRepository.findById(idJob)
            .orElseThrow(() -> {
                throw new JobNotFoundException();
            });

        var applyJob = ApplyJobEntity.builder()
            .candidateId(idCandidate)
            .jobId(idJob)
            .build();
        
        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
