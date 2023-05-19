package com.example.easylogin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easylogin.model.entity.User;

// Repositoryは、データベースや永続化ストレージからデータを取得し、永続化するためのメソッドを提供するオブジェクトのことを指します。
@Repository

/*
 * Spring Frameworkでは、データベースアクセスを簡単に行うために、JpaRepositoryというジェネリックなインターフェースを提供しています。
 * JpaRepositoryを実装したリポジトリクラスを作成することで、データベースのCRUD操作を簡単に実装することができます。
 * 
 * 以下のようなUserRepositoryインターフェースは、Userエンティティを操作するためのJPAリポジトリであり、findByUserNameAndPasswordというメソッドを定義しています。
 * このメソッドは、ユーザ名とパスワードを引数に取り、該当するユーザを取得するために使用されます。
*/
public interface UserRepository extends JpaRepository<User, Long> {
	
	// findByUserNameAndPasswordは、与えられたユーザー名とパスワードに基づいて、ユーザー情報を検索するために使用されるメソッドです。
	List<User> findByUserNameAndPassword(String userName, String password);
}
