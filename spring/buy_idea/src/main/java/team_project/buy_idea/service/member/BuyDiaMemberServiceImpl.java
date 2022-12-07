package team_project.buy_idea.service.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_project.buy_idea.entity.member.Authentication;
import team_project.buy_idea.entity.member.BasicAuthentication;
import team_project.buy_idea.entity.member.BuyDiaMember;
import team_project.buy_idea.repository.member.AuthenticationRepository;
import team_project.buy_idea.repository.member.BuyDiaMemberRepository;
import team_project.buy_idea.service.member.request.BuyDiaMemberRegisterRequest;

import java.util.Optional;

@Slf4j
@Service
public class BuyDiaMemberServiceImpl implements BuyDiaMemberService {

    @Autowired
    private BuyDiaMemberRepository buyDiaMemberRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;


    @Override
    public Boolean signUp(BuyDiaMemberRegisterRequest request) {
        final BuyDiaMember member = request.toMember();
        buyDiaMemberRepository.save(member);

        final BasicAuthentication auth = new BasicAuthentication(member,
                Authentication.BASIC_AUTH, request.getPassword());

        authenticationRepository.save(auth);

        return true;
    }

    @Override
    public Boolean memberIdValidation(String memberId) {
        Optional<BuyDiaMember> maybeMemberId = buyDiaMemberRepository.findByMemberId(memberId);

        if (maybeMemberId.isPresent()){
            return false;
        }

        return true;
    }

    @Override
    public Boolean memberNicknameValidation(String nickName) {
        Optional<BuyDiaMember> maybeMemberNickname = buyDiaMemberRepository.findBuyDiaMemberByNickName(nickName);

        if (maybeMemberNickname.isPresent()) {
            return false;
        }

        return true;
    }


}