package com.example.demo_container_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "デモ用レスポンス")
public class DemoResponse {

    @Schema(type = "string", description = "message",
            example = "Good Morning, ○○")
    private String message;
}
