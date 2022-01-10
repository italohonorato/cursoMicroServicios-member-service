package cl.teamweichafe.services.impl;

import cl.teamweichafe.common.dtos.MemberDto;
import cl.teamweichafe.domain.Member;
import cl.teamweichafe.mappers.MemberMapper;
import cl.teamweichafe.repositories.MemberRepository;
import cl.teamweichafe.services.MemberService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public MongoRepository<Member, String> getRepository() {
        return this.memberRepository;
    }


    @Override
    public MemberDto saveMember(MemberDto memberDto) {
        Member member = memberMapper.map(memberDto);
        return memberMapper.map(this.save(member));
    }

    @Override
    public MemberDto updateMember(String id, MemberDto memberDto) {
        Member member = this.get(id);
        member.setAddress(memberDto.getAddress());
        member.setDob(memberDto.getDob());
        member.setEmail(memberDto.getEmail());
        member.setName(memberDto.getName());
        member.setLastName(memberDto.getLastName());
        member.setPhone(memberDto.getPhone());
        member.setDegreeId(memberDto.getDegreeId());
        member.setClassId(memberDto.getClassId());

        return memberMapper.map(this.save(member));
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<Member> memberList = this.getAll();
        return memberMapper.toMemberDtoList(memberList);
    }

    @Override
    public MemberDto getById(String id) {
        return memberMapper.map(this.get(id));
    }

    @Override
    public List<MemberDto> getByDegreeId(String id) {
        return memberMapper.toMemberDtoList(this.memberRepository.getByDegreeId(id));
    }

    @Override
    public List<MemberDto> getByClassId(String id) {
        return this.memberMapper.toMemberDtoList(this.memberRepository.getByClassId(id));
    }
}
