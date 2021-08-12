package knut.circle.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Embeddable
public class CommonTime {

    public CommonTime() {
    }

    @NotNull
    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate = null;
}
