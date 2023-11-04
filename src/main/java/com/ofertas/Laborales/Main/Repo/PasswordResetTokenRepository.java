package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	PasswordResetToken findByToken(String token);
}