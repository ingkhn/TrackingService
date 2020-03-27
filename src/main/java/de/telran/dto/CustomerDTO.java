package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @Nullable
    private Long customerId;

    @Length(min = 2, max = 20)
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Nullable
    private List<ShipmentDTO> shipments;
}
