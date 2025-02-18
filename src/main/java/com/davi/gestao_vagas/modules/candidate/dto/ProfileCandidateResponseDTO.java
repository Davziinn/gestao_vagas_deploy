package com.davi.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "JohDoe")
    private String username;

    @Schema(example = "Joh Doe")
    private String name;

    @Schema(example = "johDoe@gmail.com")
    private String email;

    @Schema(example = "Desenvolvedor Java")
    private String description;
    private UUID id;
}
