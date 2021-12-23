package cl.teamweichafe.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Builder
@Document("members")
public class Member {

    @Id
    private String id;
    private String name;
    private String lastName;
    private LocalDate dob;
    private Integer phone;
    @Email(message = "Email should be valid")
    private String email;
    @Size(max = 200, message = "Address accept 200 characters at max")
    private String address;
}
