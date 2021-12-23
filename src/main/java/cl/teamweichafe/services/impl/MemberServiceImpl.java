package cl.teamweichafe.services.impl;

import cl.teamweichafe.domain.Member;
import cl.teamweichafe.repositories.MemberRepository;
import cl.teamweichafe.services.MemberService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MongoRepository<Member, String> getRepository() {
        return this.memberRepository;
    }
}
