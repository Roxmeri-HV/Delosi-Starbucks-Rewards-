package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
