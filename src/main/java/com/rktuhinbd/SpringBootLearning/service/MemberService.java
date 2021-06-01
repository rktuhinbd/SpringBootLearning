package com.rktuhinbd.SpringBootLearning.service;

import com.rktuhinbd.SpringBootLearning.entity.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>(Arrays.asList(new Member(1L, "Md. Rejaul Karim", "01841752600", "rktuhinbd@gmail.com", LocalDate.of(1994, Month.JULY, 15), 27),
            new Member(2L, "Amirul Islam", "01722835935", "justamirul@gmail.com", LocalDate.of(1992, Month.MARCH, 21), 29),
            new Member(3L, "A S M Tarek", "01772918738", "asmtarek7@gmail.com", LocalDate.of(1994, Month.APRIL, 23), 27)
    ));

    public List<Member> getAllMembers() {
        return members;
    }

    public Member getMember(Long id) {
        return members.stream().filter(member -> member.getId().equals(id)).findFirst().get();
    }

    public Boolean addMember(Member member) {
        return members.add(member);
    }

    public String updateMember(Member member) {

        if (member.getId() == null) return "Id required!!";

        Boolean flag = false;
        Long id = member.getId();

        for (int i = 0; i < members.size(); i++) {
            if (id.equals(members.get(i).getId())) {
                members.set(i, member);
                flag = true;
            }
        }

        if (flag) return "Request Successful!";
        else return "Request Failed!!";
    }

    public String deleteMember(Long id) {

        Boolean flag = false;

        for (int i = 0; i < members.size(); i++) {
            if (id.equals(members.get(i).getId())) {
                members.remove(i);
                flag = true;
            }
        }

        if (flag) return "Request Successful!";
        else return "Request Failed!!";
    }
}
