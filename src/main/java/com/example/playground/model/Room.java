package com.example.playground.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {

    @NotBlank
    private String roomId;

    @NotBlank
    @Valid
    private RoomType roomType;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class RoomType {

        @NotNull
        private Integer typeId;

        @NotBlank
        private String name;

        @NotNull
        private String price;

    }
}
