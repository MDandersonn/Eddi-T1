import 'package:buy_idea/component/account/select_sign_up_button.dart';
import 'package:flutter/cupertino.dart';
import 'package:buy_idea/utility/size.dart';

class SelectSignUpForm extends StatelessWidget{
  SelectSignUpForm({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Form(
      child: Column(
        children: [
          SelectSignUpButton(buttonName: "판매자 회원가입"),
          SizedBox(height: large_gap),
          SelectSignUpButton(buttonName: "일반회원 회원가입"),
        ],
      )
    );
  }
}