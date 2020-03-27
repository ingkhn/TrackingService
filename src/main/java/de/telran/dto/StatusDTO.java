package de.telran.dto;

import de.telran.model.entity.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {
    @Nullable
    private Long statusId;

    private StatusType type;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date date;
}
