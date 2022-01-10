package cl.teamweichafe.services;

import cl.teamweichafe.common.dtos.MemberDto;
import cl.teamweichafe.common.services.BaseService;
import cl.teamweichafe.domain.Member;

import java.util.List;

public interface MemberService extends BaseService<Member, String> {
    MemberDto saveMember(MemberDto memberDto);
    MemberDto updateMember(String id, MemberDto memberDto);
    MemberDto getById(String id);
    List<MemberDto> getAllMembers();
    List<MemberDto> getByDegreeId(String id);
    List<MemberDto> getByClassId(String id);
}
