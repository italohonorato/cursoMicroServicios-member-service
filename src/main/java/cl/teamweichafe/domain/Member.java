package cl.teamweichafe.domain;

import cl.teamweichafe.common.configs.LocalDateDeserializer;
import cl.teamweichafe.common.configs.LocalDateSerializer;
import cl.teamweichafe.common.configs.LocalDateTimeDeserializer;
import cl.teamweichafe.common.configs.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Document("members")
public class Member {

    @Id
    private String id;
    private String name;
    private String lastName;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dob;
    private Integer phone;
    @Email(message = "Email should be valid")
    private String email;
    @Size(max = 200, message = "Address accept 200 characters at max")
    private String address;
    private String degreeId;
    private String classId;
}
