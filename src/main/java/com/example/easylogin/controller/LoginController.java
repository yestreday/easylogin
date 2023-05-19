package com.example.easylogin.controller;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepos;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	/*
	 * @RequestMapping("login")によって、リクエストが/loginにマッピングされることになります。
	 * したがって、/loginにアクセスすると、アノテーションが付与されたメソッドが呼び出されます。
	 * このメソッドは、ログイン処理を行うためのコントローラーのメソッドとして使用されることが多いです。
	 */
	@RequestMapping("/login")
	public String login(
			// @RequestParamは、Spring Frameworkにおいて、HTTPリクエストのパラメーターから、指定された名前の値を取得するために使用されるアノテーションです。
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			// Modelオブジェクトは、コントローラーからビューにデータを渡すために使用されます。
			Model m) {
		
		String message = "Welcome,";
		
		List<User> users= userRepos.findByUserNameAndPassword(username, password);
		if (users.size() > 0) {
			// users.get(0)は、リストの先頭の要素（インデックス0の要素）を取得します。そして、User型の変数userに代入しています。
			User user = users.get(0);
			message += user.getFullName();
		} else {
			message += "guest";
		}
		
		/*
		 * m.addAttribute("message", message)は、Spring FrameworkのMVC（Model-View-Controller）アーキテクチャーにおいて、コントローラーからビューにデータを渡すために使用される方法の1つです。
		 * 具体的には、addAttributeメソッドは、ビューに渡すデータを格納するためのModelオブジェクトmに、キーと値のペアを追加します。上記の例では、キーとして"message"、値としてmessageという変数が使われています。
		 * この場合、コントローラー側で作成されたmessageという変数の値が、"message"というキーに関連付けられます。
		 */
		m.addAttribute("message", message);
		
		return "login";
	}
}
