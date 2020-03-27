package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDTO {
    @Nullable
    private Long shipmentId;

    @NotBlank
    private String title;

    @Nullable
    private List<StatusDTO> statuses;
}
