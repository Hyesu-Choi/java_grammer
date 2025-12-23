package C07ExceptionFileParsing.MemberException;

import java.util.ArrayList;
import java.util.List;

//저장소역할을 하는 계층
//DB에 CRUD를 수행하는 계층
public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository() {
        this.memberList = new ArrayList<>();
    }

    public void register(Member member) {
        this.memberList.add(member);
    }

    public Member findByEmail(String email) {
        Member member = null;
        for (Member a : memberList) {
            if (a.getEmail().equals(email)) {
                member = a;
            }
        }
        return member;
    }

    public Member findById(long id) {
        Member member = null;
        for (Member a : memberList) {
            if (a.getId().equals(id)) {
                member = a;
            }
        }
        return member;
    }

    public List<Member> findAll() {
        return this.memberList;
    }
}