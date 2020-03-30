package de.telran.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.telran.model.entity.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {
    @Nullable
    private Long statusId;

    private StatusType type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
}
