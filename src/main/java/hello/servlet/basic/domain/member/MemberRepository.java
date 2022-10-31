package hello.servlet.basic.domain.member;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *  동시성 문제가 고려되어 있지 않습니다, 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려해야 합니다
 */

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0; // 아이디가 하나씩 증거하는, static 이기 때문에 멤버리파지토리에 딱 하나만 사용될것

    private static final MemberRepository instance = new MemberRepository(); //싱글톤

    public static MemberRepository getInstance() { //getInstance로만 조회 가능
        return instance;
    }

    private MemberRepository() { // Singleton 사용시 아무나 사용 못하게 private 으로 막아야함함

   }

   public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
   }

   public Member findById(Long id) {
        return store.get(id);
   }

   public List<Member> findAll() {
        return new ArrayList<>(store.values()); //스토어에 있는 모든 값들을 담아서 다시 넘겨줌 //stroe 에 있는 밸류를 조작하고 싶지 안하서, 직접 조작하려면 또 가능하긴함
   }

   public  void clearStore() {
       store.clear(); //test에서만 사용, store 데이타 날림
   }


}
