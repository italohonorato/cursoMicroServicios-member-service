package cl.teamweichafe.mappers.impl;

import cl.teamweichafe.common.dtos.MemberDto;
import cl.teamweichafe.domain.Member;
import cl.teamweichafe.mappers.MemberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMapperImpl implements MemberMapper {

    private final ModelMapper modelMapper;

    public MemberMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MemberDto map(Member member) {
        return this.getMapper().map(member, MemberDto.class);
    }

    @Override
    public Member map(MemberDto memberDto) {
        return this.getMapper().map(memberDto, Member.class);
    }

    @Override
    public List<Member> toMemberList(List<MemberDto> dtoList) {
        return this.toEntityList(dtoList, Member.class);
    }

    @Override
    public List<MemberDto> toMemberDtoList(List<Member> entityList) {
        return this.toDtoList(entityList, MemberDto.class);
    }

    @Override
    public ModelMapper getMapper() {
        return this.modelMapper;
    }
}
