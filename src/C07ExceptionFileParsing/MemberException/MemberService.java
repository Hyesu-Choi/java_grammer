package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//핵심로직을 구현하는 계층
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void register(String name, String email, String password) throws IllegalArgumentException {
        // 예외 여러개 발생할꺼같으면 throws 예외1, 예외2 콤마로 구분해서 적으면 됨.
//        List(DB)에 이메일이 중복일경우 예외발생
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일 입니다.");
        }

        Member newMember = new Member(name, email, password);
        memberRepository.register(newMember);
    }

    public Member findById(long id) throws NoSuchElementException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("없는 사용자입니다."));  //npe:null로 연산하려고할때 터지는 에러라서 적절하지 않음.
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void login(String email, String password) throws  NoSuchElementException, IllegalArgumentException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
//        email이 있는지 확인 후 없으면 예외발생
        Member member = optionalMember.orElseThrow(() -> new NoSuchElementException("찾을 수 없는 이메일 입니다."));
//        password가 일치한지 확인 후 일치하지 않으면 예외 발생
        if(member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }

}