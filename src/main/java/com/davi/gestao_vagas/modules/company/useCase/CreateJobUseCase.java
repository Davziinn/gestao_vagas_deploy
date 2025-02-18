package com.davi.gestao_vagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.gestao_vagas.exceptions.CompanyNotFoundException;
import com.davi.gestao_vagas.modules.company.entities.JobEntity;
import com.davi.gestao_vagas.modules.company.repositories.CompanyRepository;
import com.davi.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;	

    public JobEntity execute (JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });

        return this.jobRepository.save(jobEntity);
    }

}
