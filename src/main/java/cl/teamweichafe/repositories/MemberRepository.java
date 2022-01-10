package cl.teamweichafe.repositories;

import cl.teamweichafe.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> getByDegreeId(String degreeId);
    List<Member> getByClassId(String degreeId);
}
