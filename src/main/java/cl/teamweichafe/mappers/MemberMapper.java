package cl.teamweichafe.mappers;

import cl.teamweichafe.common.dtos.MemberDto;
import cl.teamweichafe.common.mappers.MapperUtil;
import cl.teamweichafe.domain.Member;

import java.util.List;

public interface MemberMapper extends MapperUtil<Member, MemberDto> {

    MemberDto map(Member member);
    Member map(MemberDto memberDto);
    List<Member> toMemberList(List<MemberDto> dtoList);
    List<MemberDto> toMemberDtoList(List<Member> entityList);
}
