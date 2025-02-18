package com.davi.gestao_vagas.modules.candidate.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davi.gestao_vagas.exceptions.UserFoundException;
import com.davi.gestao_vagas.modules.candidate.entity.CandidateEntity;
import com.davi.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });

            var password = passwordEncoder.encode(candidateEntity.getPassword());
            candidateEntity.setPassword(password);

            return this.candidateRepository.save(candidateEntity);
    }
}
